package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/addProduct")
    public ModelAndView getAddProduct() {

        Collection<Category> categoryList = categoryService.findAll();

        ModelAndView mav = new ModelAndView("admin/addProduct");
        mav.addObject("product", new AddProductDto());
        mav.addObject("categoryList", categoryList);
        return mav;
    }

    @PostMapping("/addProduct")
    public ModelAndView postAddProduct(@ModelAttribute AddProductDto addProductDto) {
        Collection<Category> categoryList = categoryService.findAll();

        ModelAndView mav = new ModelAndView("admin/addProduct", "product", addProductDto);
        mav.addObject("categoryList", categoryList);
        productService.createProduct(addProductDto);
        return mav;
    }
}
