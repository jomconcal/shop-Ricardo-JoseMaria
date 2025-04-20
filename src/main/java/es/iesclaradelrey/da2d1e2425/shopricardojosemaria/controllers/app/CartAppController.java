package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppCartItemDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import jakarta.persistence.EntityManager;
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

        Collection<CartItem> cartItems = cartItemService.findAll();
        ModelMapper modelMapper = new ModelMapper();

        List<AppCartItemDto> cartItemsDto = cartItems.stream().map(cartItem -> {
            AppCartItemDto dto = modelMapper.map(cartItem, AppCartItemDto.class);
            dto.setImageUrl(cartItem.getProduct().getImageUrl());
            return dto;
        }).toList();

        HashMap<String, Collection<AppCartItemDto>> map = new HashMap<>();
        map.put("content", cartItemsDto);
        return ResponseEntity.ok(map);
    }

    @PostMapping("{productId}/{quantity}")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> addAppCartItems(
            @PathVariable Long productId,
            @PathVariable Integer quantity) {
        cartItemService.addToCart(productId, quantity);
        return getAppCartItems();
    }

    @PostMapping("{productId}")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> addAppCartItem(
            @PathVariable Long productId) {
        cartItemService.addToCart(productId, 1);
        return getAppCartItems();
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> deleteCartItem(
            @PathVariable(value = "productId") Long productId) {

        cartItemService.removeProductFromCart(productId);
        return getAppCartItems();
    }

    @DeleteMapping("")
    public ResponseEntity<HashMap<String, Collection<AppCartItemDto>>> deleteCart() {

        cartItemService.removeCart();
        return getAppCartItems();
    }

}
