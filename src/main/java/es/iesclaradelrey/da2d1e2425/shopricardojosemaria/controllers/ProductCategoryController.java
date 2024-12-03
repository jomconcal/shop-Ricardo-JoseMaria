package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.ProductCategory;
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
public class ProductCategoryController {

    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    public ModelAndView getAllProductCategories() {

        ProductCategory test= new ProductCategory(1L,"Test","This is a test","/img/menu-item-1.jpg");
        ProductCategory test2= new ProductCategory(2L,"Test2","This is another test","/img/menu-item-2.jpg");
        categoryService.save(test);
        categoryService.save(test2);
        Collection<ProductCategory> categories = categoryService.findAll();
        return new ModelAndView("product-category","productCategories",categories);
    }
}
