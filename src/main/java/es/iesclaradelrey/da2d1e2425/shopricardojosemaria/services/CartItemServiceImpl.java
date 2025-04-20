package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.ProductInCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.InsufficientStock;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.ProductNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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

    @Override
    public CartItem save(CartItem cartItem) {
        Optional<CartItem> previousCartItem = cartItemRepository.findByProductId(cartItem.getProduct().getId());
        if (previousCartItem.isPresent()) {
            int quantity = cartItem.getQuantity();
            cartItem = previousCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }
        return cartItemRepository.save(cartItem);
    }

    @Override
    public Collection<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public Optional<CartItem> findById(long id) {
        return cartItemRepository.findById(id);
    }

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
        CartItem cartItem = cartItemRepository.findByProductId(productId).orElseThrow();
        cartItemRepository.delete(cartItem);
    }

    @Override
    public void removeCart() {
        cartItemRepository.deleteAll();
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
        if (quantity<=0){
            throw new IllegalArgumentException("quantity must be positive");
        }
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found"));

        if (product.getStock() < quantity) {
            throw new InsufficientStock("There's only " + product.getStock() + " products in stock");
        }

        CartItem cartItem = new CartItem(quantity, product);
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

//    @Override
//    public Page<CartItem> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
//        Sort.Direction direction = orderDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
//        Pageable pageable = PageRequest.of(pageNumber-1 , pageSize, Sort.by(direction, orderBy));
//
//        return cartItemRepository.findAll(pageable);
//    }

}
