package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.ProductInCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.InsufficientStock;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.ProductNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
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

    @Override
    public void save(CartItem cartItem) {

        Optional<CartItem> previousCartItem = cartItemRepository.findByProductId(cartItem.getProduct().getId());
        if (previousCartItem.isPresent()) {
            int quantity = cartItem.getQuantity();
            cartItem = previousCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() +quantity);
        }
        cartItemRepository.save(cartItem);

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
    public void removeCart() {
        cartItemRepository.deleteAll();
    }


    @Override
    public void save(ProductInCartDto productInCart) {
        this.save(productInCart.getProductId(), productInCart.getQuantity());

    }

    private void save(Long productId, int quantity) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found"));

        if (product.getStock() < quantity) {
            throw new InsufficientStock("There's only " + product.getStock() + " products in stock");
        }

        CartItem cartItem = new CartItem(quantity, product);
        save(cartItem);
    }

    @Override
    public void changeQuantity(Long cartItemId, boolean increase) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow();
        cartItem.setQuantity(cartItem.getQuantity() + (increase ? 1 : -1));
        cartItemRepository.save(cartItem);
    }

}
