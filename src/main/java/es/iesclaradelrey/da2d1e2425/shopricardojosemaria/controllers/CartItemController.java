package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.ProductInCartDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AppUserService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemServiceImpl;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartItemController {

    private final CartItemServiceImpl cartItemService;

    @PostMapping
    public ResponseEntity<String> addProductToCart(@RequestBody ProductInCartDto productToCartDto) {
        cartItemService.save(productToCartDto);
        return ResponseEntity.ok("Product with id "+productToCartDto.getProductId()+" added to Cart");
    }

}
