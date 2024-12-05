package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/product-category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    public ModelAndView getAllProductCategories() {

        Collection<Category> categories = categoryService.findAll();
        return new ModelAndView("product-category","categories",categories);
    }
}
