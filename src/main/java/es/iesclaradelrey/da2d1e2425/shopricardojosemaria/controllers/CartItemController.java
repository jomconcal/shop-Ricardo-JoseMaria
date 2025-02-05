package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CartItemRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/add-product-to-cart")
public class CartItemController {

    private final CartItemService cartItemService;
    private final ProductService productService;

    @GetMapping({"/", ""})
    public String addToCartItem(
            @RequestParam(name = "productId", required = true) Long productId,
            @RequestParam(name = "from", required = true) String from) {

        Product product = productService.findById(productId).orElseThrow();
        CartItem cartItem= new CartItem(1,product);
        cartItemService.save(cartItem);
        return "redirect:"+from;
    }

}
