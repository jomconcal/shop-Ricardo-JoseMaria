package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping({"","/"})
    public ModelAndView getLogin(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
}
