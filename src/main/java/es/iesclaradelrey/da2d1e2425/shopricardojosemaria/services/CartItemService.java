package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddProductToCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface CartItemService {
    void save(CartItem cartItem);
    Collection<CartItem> findAll();
    Optional<CartItem> findById(long id);
    Double pricePerCart(Collection<CartItem> cartItems);

    void removeItemFromCart(Long cartItem);

    void removeCart();

    void changeQuantity(Long cartItemId, boolean increase);

    void save(AddProductToCartDto productToCartDto);
}
