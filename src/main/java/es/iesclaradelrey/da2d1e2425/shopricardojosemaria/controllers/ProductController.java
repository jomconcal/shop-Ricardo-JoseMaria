package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    public ModelAndView getAllProducts(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        Collection<Product> products;
        String categoryName="";
        if (categoryId != null) {
            products = productService.findByCategory(categoryId);
            Optional<Category> optionalCategory = categoryService.findById(categoryId);
            categoryName = optionalCategory.isPresent() ? optionalCategory.get().getName() : "";
        } else {
            products = productService.findAll();
        }
        ModelAndView mav = new ModelAndView("products");
        mav.addObject("products", products);
        mav.addObject("categoryName", categoryName);
        return mav;

    }
}
