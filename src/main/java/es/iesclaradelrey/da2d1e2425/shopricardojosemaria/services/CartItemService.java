package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.ProductInCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;

import java.util.Collection;
import java.util.Optional;

public interface CartItemService {
    CartItem save(CartItem cartItem);
    Collection<CartItem> findAll();
//    Optional<CartItem> findById(long id);
    Double pricePerCart(Collection<CartItem> cartItems);

    void removeItemFromCart(Long cartItemId);

    void removeProductFromCart(Long productId);

    void removeCart();

    void changeQuantity(Long cartItemId, boolean increase);

    void save(ProductInCartDto productToCartDto);

    void addToCart(Long productId, int quantity);

//    Page<CartItem> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir);
}
