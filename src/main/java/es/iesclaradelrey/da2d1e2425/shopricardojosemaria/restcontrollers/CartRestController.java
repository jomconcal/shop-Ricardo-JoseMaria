package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.restcontrollers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.ProductInCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    private final CartItemServiceImpl cartItemService;

    @PostMapping
    public ResponseEntity<String> addProductToCart(@RequestBody ProductInCartDto productToCartDto) {
        cartItemService.save(productToCartDto);
        return ResponseEntity.ok("Product with id "+productToCartDto.getProductId()+" added to Cart");
    }

}
