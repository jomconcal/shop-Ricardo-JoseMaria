package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CartItemService cartItemService;

    @GetMapping({"/", ""})
    public ModelAndView getCart() {
        ModelAndView mv = new ModelAndView("cart");
        Collection<CartItem> cartItems = cartItemService.findAll();

        mv.addObject("title", "Cart");
        mv.addObject("cartItems", cartItems);
        mv.addObject("totalPrice", cartItemService.pricePerCart(cartItems));

        return mv;
    }

    @GetMapping({"/delete-cartItem/{cartItemId}"})
    public String deleteCartItem(@PathVariable Long cartItemId) {
        cartItemService.removeItemFromCart(cartItemId);
        return "redirect:/cart";
    }

    @GetMapping({"/delete-cart"})
    public String deleteCart() {
        cartItemService.removeCart();
        return "redirect:/cart";
    }

    @GetMapping({"/update-cartItem"})
    public String changeQuantity(
            @RequestParam(name = "increase", required = true) Boolean increase,
            @RequestParam(name = "cartItemId", required = true) Long cartItemId) {

        cartItemService.changeQuantity(cartItemId,increase);

        return "redirect:/cart";

    }
}

