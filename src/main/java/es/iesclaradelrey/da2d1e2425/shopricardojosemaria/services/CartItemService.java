package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.ProductInCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import org.springframework.data.domain.Page;

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

    void save(ProductInCartDto productToCartDto);

    Page<CartItem> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir);
}
