package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddProductToCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    private final CartItemServiceImpl cartItemService;

    public CartRestController(CartItemServiceImpl cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public ResponseEntity<String> addProductToCart(@RequestBody AddProductToCartDto productToCartDto) {

        cartItemService.save(productToCartDto);
        return ResponseEntity.ok().body(productToCartDto.toString());
    }

}
