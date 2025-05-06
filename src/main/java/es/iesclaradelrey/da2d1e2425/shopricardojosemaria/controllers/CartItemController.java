package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AppUserService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/add-product-to-cart")
public class CartItemController {

    private final CartItemService cartItemService;
    private final ProductService productService;
    private final AppUserService appUserService;

    @GetMapping("/{productId}")
    public String addToCartItem(
            @PathVariable Long productId,
            @RequestParam(name = "from") String from) {

        Product product = productService.findById(productId).orElseThrow();
        AppUser appUser = appUserService.currentUser().orElseThrow(() -> new UsernameNotFoundException("User not found"));
        CartItem cartItem= new CartItem(1,product,appUser);
        cartItemService.save(cartItem);
        return "redirect:"+from;
    }

}
