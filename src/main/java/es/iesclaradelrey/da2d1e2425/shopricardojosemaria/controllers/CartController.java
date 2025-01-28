package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CartItemServiceImpl cartItemServiceImpl;

    @GetMapping({"/",""})
    public ModelAndView getCart() {
        ModelAndView mv = new ModelAndView("cart");
        Collection<CartItem> cartItems = cartItemServiceImpl.findAll();

        mv.addObject("title", "Cart");
        mv.addObject("cartItems", cartItems);
        mv.addObject("totalPrice",cartItemServiceImpl.pricePerCart(cartItems));

        return mv;
    }
}
