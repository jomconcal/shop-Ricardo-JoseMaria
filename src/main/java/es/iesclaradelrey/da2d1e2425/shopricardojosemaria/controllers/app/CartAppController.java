package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppCartItemDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/cart")
public class CartAppController {

    private final CartItemService cartItemService;

    @GetMapping({"", "/"})
    public ResponseEntity<AppCartDto> getAppCartItems() {

        Collection<CartItem> cartItems = cartItemService.findAll();
        ModelMapper modelMapper = new ModelMapper();

        List<AppCartItemDto> cartItemsDto = cartItems.stream().map(cartItem -> {
            AppCartItemDto dto = modelMapper.map(cartItem, AppCartItemDto.class);
            dto.setImageUrl(cartItem.getProduct().getImageUrl());
            dto.setUnitPrice(cartItem.getProduct().getPrice());
            dto.setTotalPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
            return dto;
        }).toList();

        AppCartDto appCartDto= new AppCartDto(cartItemsDto,cartItemService.pricePerCart(cartItems));

        return ResponseEntity.ok(appCartDto);
    }

    @PostMapping("{productId}/{quantity}")
    public ResponseEntity<AppCartDto> addAppCartItems(
            @PathVariable Long productId,
            @PathVariable Integer quantity) {
        cartItemService.addToCart(productId, quantity);
        return getAppCartItems();
    }

    @PostMapping("{productId}")
    public ResponseEntity<AppCartDto> addAppCartItem(
            @PathVariable Long productId) {
        cartItemService.addToCart(productId, 1);
        return getAppCartItems();
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<AppCartDto> deleteCartItem(
            @PathVariable(value = "productId") Long productId) {

        cartItemService.removeProductFromCart(productId);
        return getAppCartItems();
    }

    @DeleteMapping("")
    public ResponseEntity<AppCartDto> deleteCart() {

        cartItemService.removeCart();
        return getAppCartItems();
    }

}
