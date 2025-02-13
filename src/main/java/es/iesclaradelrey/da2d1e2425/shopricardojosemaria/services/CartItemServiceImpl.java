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
            CartItem newCartItem = previousCartItem.get();
            newCartItem.setQuantity(newCartItem.getQuantity() + cartItem.getQuantity());
            cartItemRepository.save(newCartItem);
        } else {
            cartItemRepository.save(cartItem);
        }
        Product productChanged = productRepository.findById(cartItem.getProduct().getId()).orElseThrow();
        productChanged.setStock(productChanged.getStock() - cartItem.getQuantity());
        productRepository.save(productChanged);
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
    public void changeQuantity(Long cartItemId, boolean increase) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow();
        if (increase) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItemRepository.save(cartItem);
        } else if (cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            cartItemRepository.save(cartItem);
        }
    }

    @Override
    public void save(ProductInCartDto productInCart) {
        if (productRepository.findById(productInCart.getProductId()).isEmpty()) {
            throw new ProductNotFoundException("Product with id " + productInCart.getProductId() + " not found");
        }else if (productRepository.findById(productInCart.getProductId()).get().getStock() < productInCart.getQuantity()) {
            throw new InsufficientStock("There's only " + productRepository.findById(productInCart.getProductId()).get().getStock() + " products in stock");
        }else{
            CartItem cartItem = new CartItem(productInCart.getQuantity(),productRepository.findById(productInCart.getProductId()).get());
            save(cartItem);
        }
    }



}
