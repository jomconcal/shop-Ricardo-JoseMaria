package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.CreateCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
//@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    public ModelAndView getAllCategories() {
        Collection<Category> categories = categoryService.findAll();
        ModelAndView mav= new ModelAndView("index","categories",categories);
        mav.addObject("title","Coffee Shop");
        return mav;
    }

    // Muestra el formulario de crear categoría
    @GetMapping("/new")
    public ModelAndView newCategory(Model model) {
        ModelAndView mav= new ModelAndView("new");
        mav.addObject("category",new CreateCategoryDto());
        return mav;
    }

    // Procesar el post del formulario
    @PostMapping("/new")
    public ModelAndView newCategory(@ModelAttribute CreateCategoryDto categoryDto) {
        categoryService.create(categoryDto.getName(), categoryDto.getDescription());
        return new ModelAndView("new", "category", categoryDto);
    }
}

