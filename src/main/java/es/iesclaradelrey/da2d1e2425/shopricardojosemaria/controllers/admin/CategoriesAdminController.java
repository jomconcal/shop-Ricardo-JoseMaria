package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin/categories")
@AllArgsConstructor
public class CategoriesAdminController {

    private CategoryService categoryService;
    @GetMapping({"","/"})
    public String categoryAdmin(@RequestParam(defaultValue = "1") Integer pageNumber,
                                @RequestParam(defaultValue = "2") Integer pageSize,
                                @RequestParam(defaultValue = "name") String orderBy,
                                @RequestParam(defaultValue = "asc") String orderDir,
                                Model model) {
        Map<String,String> orders= new LinkedHashMap<>();
        orders.put("Id", "id");
        orders.put("Name", "name");
        model.addAttribute("categories", categoryService.findAll(pageNumber,
                pageSize,orderBy,orderDir));
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("orderDir", orderDir);
        model.addAttribute("orders", orders);
        return "admin/adminCategories";
    }

    @GetMapping("/new")
    public String getAddCategory(Model model) {
        model.addAttribute("category", new AddCategoryDto());
        return "admin/newCategory";
    }

    @PostMapping("/new")
    public String postAddCategory(@Valid @ModelAttribute("category") AddCategoryDto addCategoryDto,
                                        BindingResult bindingResult, Model model) {

        model.addAttribute("category", addCategoryDto);

        if(bindingResult.hasErrors()) {
            return "admin/newCategory";
        }

        try {
//            if(new Random().nextBoolean()){
//                throw new RuntimeException("Error");
//            }
            categoryService.createCategory(addCategoryDto);
        }catch (AlreadyExistsException e) {
            bindingResult.rejectValue("name", "error.category.alreadyExists","Name already exists");
            return "admin/newCategory";
        }catch (Exception e) {
            bindingResult.reject("",e.getMessage());
            return "admin/newCategory";
        }
        return"redirect:/admin/categories";
    }

}
