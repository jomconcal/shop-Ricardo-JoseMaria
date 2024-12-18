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

import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    public ModelAndView getAllProducts(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        Collection<Product> products;
        ModelAndView mav = new ModelAndView("products");

        if (categoryId != null) {
            products = productService.findByCategory(categoryId);
            Optional<Category> optionalCategory = categoryService.findById(categoryId);
            Category category = optionalCategory.orElse(null);
            Collection<Category> categories = new ArrayList<Category>();
            categories.add(category);
            Collection<Category> allCategories = categoryService.findAll();

            mav.addObject("products", products);
            mav.addObject("categories", categories);
            assert category != null;
            Long previousCategoryId = previousCategoryId(category, allCategories);
            Long nextCategoryId = nextCategoryId(category, allCategories);
            mav.addObject("title", category.getName());
            mav.addObject("previousCategoryId", previousCategoryId);
            mav.addObject("nextCategoryId", nextCategoryId);
        } else {
            products = productService.findAll();
            Collection<Category> categories = categoryService.findAll();
            mav.addObject("products", products);
            mav.addObject("categories", categories);
            mav.addObject("title", "All Products");
        }
        return mav;
    }

    private static Long previousCategoryId(Category category, Collection<Category> categories) {
       ArrayList<Category>allCategories=new ArrayList<>(categories);
       int index=allCategories.indexOf(category);
       if(index>0){
           return allCategories.get(index-1).getId();
       }else{
           return allCategories.getLast().getId();
       }
    }

    private static Long nextCategoryId(Category category, Collection<Category> categories) {
        ArrayList<Category>allCategories=new ArrayList<>(categories);
        int index=allCategories.indexOf(category);
        if(index<allCategories.size()-1){
            return allCategories.get(index+1).getId();
        }else{
            return allCategories.getFirst().getId();
        }
    }
}
