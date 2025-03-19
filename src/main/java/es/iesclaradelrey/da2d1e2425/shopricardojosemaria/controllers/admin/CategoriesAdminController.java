package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.DeleteCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.EditCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.CategoryNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin/categories")
@AllArgsConstructor
public class CategoriesAdminController {

    private CategoryService categoryService;

    @GetMapping({"", "/"})
    public String categoryAdmin(@RequestParam(defaultValue = "1") Integer pageNumber,
                                @RequestParam(defaultValue = "2") Integer pageSize,
                                @RequestParam(defaultValue = "name") String orderBy,
                                @RequestParam(defaultValue = "asc") String orderDir,
                                Model model) {
        Map<String, String> orders = new LinkedHashMap<>();
        orders.put("Id", "id");
        orders.put("Name", "name");
        model.addAttribute("categories", categoryService.findAll(pageNumber,
                pageSize, orderBy, orderDir));
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("orderDir", orderDir);
        model.addAttribute("orders", orders);
        return "admin/adminCategories";
    }

    @GetMapping("/new")
    public String getAddCategory(Model model) {
        model.addAttribute("category", new AddCategoryDto());
        model.addAttribute("title","Add Category");
        model.addAttribute("textButon","Add");
        return "admin/newCategory";
    }

    @PostMapping("/new")
    public String postAddCategory(@Valid @ModelAttribute("category") AddCategoryDto addCategoryDto,
                                  BindingResult bindingResult, Model model, RedirectAttributes attributes) {

        model.addAttribute("category", addCategoryDto);
        model.addAttribute("title","Add Category");
        model.addAttribute("textButon","Add");
        if (bindingResult.hasErrors()) {
            return "admin/newCategory";
        }

        try {
            if(new Random().nextBoolean()){
                throw new RuntimeException("Error");
            }
            categoryService.createCategory(addCategoryDto);
        } catch (AlreadyExistsException e) {
            bindingResult.rejectValue("name", "error.category.alreadyExists", "Name already exists");
            return "admin/newCategory";
        } catch (Exception e) {
            bindingResult.reject("", e.getMessage());
            return "admin/newCategory";
        }

        attributes.addFlashAttribute("message", "Category added successfully");
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{idCategory}")
    public String getEditCategory(Model model, @PathVariable Long idCategory) {
        Category category= categoryService.findById(idCategory).orElseThrow();
        EditCategoryDto editCategoryDto = new EditCategoryDto(category);
        model.addAttribute("category", editCategoryDto);
        model.addAttribute("title","Update Category");
        model.addAttribute("textButon","Update");
        return "admin/newCategory";
    }

    @PostMapping ("/edit/{idCategory}")
    public String postEditCategory(Model model, @PathVariable Long idCategory,
                                   @Valid @ModelAttribute("category") EditCategoryDto editCategoryDto,
                                   BindingResult bindingResult,
                                   RedirectAttributes attributes) {

        model.addAttribute("category", editCategoryDto);
        model.addAttribute("title","Update Category");
        model.addAttribute("textButon","Update");
        try{
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Error");
            }
            categoryService.updateCategory(editCategoryDto, idCategory);
        }catch (CategoryNotFoundException e) {
            e.printStackTrace();
            return "redirect:/admin/categories";
        } catch (Exception e) {
            bindingResult.reject("", e.getMessage());
            System.out.println(e.getMessage());
            return "admin/newCategory";
        }
        attributes.addFlashAttribute("message", "Category updated successfully");
        return "redirect:/admin/categories";
    }

    @GetMapping("/delete/{idCategory}")
    public String getDeleteCategory(Model model,@PathVariable Long idCategory) {
        Category category= categoryService.findById(idCategory).orElseThrow();
        DeleteCategoryDto deleteCategoryDto = new DeleteCategoryDto(category);

        model.addAttribute("category", deleteCategoryDto);
        model.addAttribute("title","Delete Category");
        model.addAttribute("textButon","Delete");

        return "admin/deleteCategory";
    }

    @PostMapping("/delete/{idCategory}")
    public String postDeleteCategory(@PathVariable Long idCategory,
                                     @Valid @ModelAttribute("category") DeleteCategoryDto deleteCategoryDto,
                                     BindingResult bindingResult,
                                     RedirectAttributes attributes,Model model) {

        System.out.println(deleteCategoryDto);

//        model.addAttribute("category", deleteCategoryDto);
        model.addAttribute("title","Delete Category");
        model.addAttribute("textButon","Delete");

        try{
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Error");
            }
            categoryService.deleteCategory(idCategory);
            attributes.addFlashAttribute("message", "Category delete successfully");
            return "redirect:/admin/categories";
        }catch (CategoryNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            bindingResult.reject("", e.getMessage());
            System.out.println(e.getMessage());
        }
        return "admin/deleteCategory";
    }
}
