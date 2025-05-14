package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.ProductInCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.InsufficientStock;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.ItemNotBelongingToUserException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.ProductNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final EntityManager entityManager;
    private final AppUserService appUserService;

    @Override
    public CartItem save(CartItem cartItem) {
        Optional<CartItem> previousCartItem = cartItemRepository.findByProductIdAndAppUser(cartItem.getProduct().getId(),cartItem.getAppUser());
        if (previousCartItem.isPresent()) {
            int quantity = cartItem.getQuantity();
            cartItem = previousCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }
        return cartItemRepository.save(cartItem);
    }

    @Override
    public Collection<CartItem> findAll() {
        Long userId = appUserService.currentUser().orElseThrow(() -> new UsernameNotFoundException("User not found")).getId();
        return cartItemRepository.findAllByAppUserId(userId);
    }

//    @Override
//    public Optional<CartItem> findById(long id) {
//        return cartItemRepository.findById(id);
//    }

    @Override
    public Double pricePerCart(Collection<CartItem> cartItems) {
        return cartItems.stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum();
    }

    @Override
    public void removeItemFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public void removeProductFromCart(Long productId) {
        AppUser user = appUserService.currentUser().orElseThrow(() -> new UsernameNotFoundException("User not found"));
        CartItem cartItem = cartItemRepository.findByProductIdAndAppUser(productId,user).orElseThrow(()->
                new ItemNotBelongingToUserException(user.getEmail() + " cannot delete this item ")
        );
        if(!user.equals(cartItem.getAppUser())){
            throw new ItemNotBelongingToUserException(user.getEmail()+ " cannot delete this item ");
        }
        cartItemRepository.delete(cartItem);
    }

    @Override
    @Transactional
    public void removeCart() {
        Long userId = appUserService.currentUser().orElseThrow(() -> new UsernameNotFoundException("User not found")).getId();
        cartItemRepository.deleteAllByUserId(userId);
    }


    @Override
    @Transactional
    public void save(ProductInCartDto productInCart) {
        this.save(productInCart.getProductId(), productInCart.getQuantity());
    }

    @Override
    @Transactional
    public void addToCart(Long productId, int quantity) {
        save(productId, quantity);
    }

    //Esta función tiene dos métodos para actualizar la información de los DTOs relativa a la fecha en tiempo real.
    private void save(Long productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found"));

        if(product.getStock()==0){
            throw new InsufficientStock("There's no such product in stock");
        }

        if (product.getStock() < quantity) {
            throw new InsufficientStock("There's only " + product.getStock() + " products in stock");
        }

        AppUser appUser = appUserService.currentUser().orElseThrow(() -> new UsernameNotFoundException("User not found"));
        CartItem cartItem = new CartItem(quantity, product, appUser);
        cartItem = this.save(cartItem);

        entityManager.flush();
        entityManager.refresh(cartItem);
    }

    //Esta solo se usa en la web y no es de José Luis ni de Julio
    @Override
    public void changeQuantity(Long cartItemId, boolean increase) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow();
        if (cartItem.getQuantity() > 1 || increase) {
            cartItem.setQuantity(cartItem.getQuantity() + (increase ? 1 : -1));
            cartItemRepository.save(cartItem);
        }
    }

}
