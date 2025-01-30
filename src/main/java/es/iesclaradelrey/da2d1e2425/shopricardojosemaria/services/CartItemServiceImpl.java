package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Override
    public void save(CartItem cartItem) {

        Optional<CartItem> previousCartItem = cartItemRepository.findByProductId(cartItem.getProduct().getId());
        if (previousCartItem.isPresent()) {
            CartItem newCartItem = previousCartItem.get();
            newCartItem.setQuantity(newCartItem.getQuantity() + 1);
            cartItemRepository.save(newCartItem);
        } else {
            cartItemRepository.save(cartItem);
        }
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
}
