package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppCartItemDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/cart")
public class CartAppController {

    private final CartItemService cartItemService;

    @GetMapping({"", "/"})
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> getAppCartItems() {

        return getHashMapResponseEntity();
    }

    @PostMapping("{productId}/{quantity}")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> addAppCartItemWithQuantity(
            @PathVariable Long productId,
            @PathVariable Integer quantity) {
        cartItemService.addToCart(productId, quantity);
        return getHashMapResponseEntity();
    }

    @PostMapping("{productId}")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> addAppCartItemDefaultQuantity(
            @PathVariable Long productId) {
        cartItemService.addToCart(productId, 1);
        return getHashMapResponseEntity();
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> deleteCartItem(
            @PathVariable(value = "productId") Long productId) {

        cartItemService.removeProductFromCart(productId);
        return getHashMapResponseEntity();
    }

    @DeleteMapping("")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> deleteCart() {

        cartItemService.removeCart();
        return getHashMapResponseEntity();
    }

    private ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> getHashMapResponseEntity() {
        Collection<CartItem> cartItems = cartItemService.findAll();
        ModelMapper modelMapper = new ModelMapper();

        List<AppCartItemDto> cartItemsDto = cartItems.stream().map(cartItem -> modelMapper.map(cartItem, AppCartItemDto.class)).toList();
        HashMap<String, Collection<AppCartItemDto>> map = new HashMap<>();
        map.put("content", cartItemsDto);
        return ResponseEntity.ok(map);
    }


}
