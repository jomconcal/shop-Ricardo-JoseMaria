package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/add-product-to-cart")
public class AddToCartItemController {

    @GetMapping("/{id}")
    public String addToCartItem(@PathVariable Long id) {
        return "redirect:/products";
    }

}
