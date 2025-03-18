package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.CategoryNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin/products")
@AllArgsConstructor
public class ProductAdminController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping({"", "/"})
    public String categoryAdmin(@RequestParam(defaultValue = "1") Integer pageNumber,
                                @RequestParam(defaultValue = "5") Integer pageSize,
                                @RequestParam(defaultValue = "category.name") String orderBy,
                                @RequestParam(defaultValue = "asc") String orderDir,
                                Model model) {
        Map<String, String> orders = new LinkedHashMap<>();
        orders.put("Id", "id");
        orders.put("Name", "name");
        orders.put("Category", "category.name");
        model.addAttribute("products", productService.findAll(pageNumber,
                pageSize, orderBy, orderDir));
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("orderDir", orderDir);
        model.addAttribute("orders", orders);
        return "admin/adminProducts";
    }

    @GetMapping("/new")
    public String getAddProduct(Model model) {
        Collection<Category> categoryList = categoryService.findAll();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", new AddProductDto());
        return "admin/newProduct";
    }

    @PostMapping({"/new", "/new/"})
    public String postAddProduct(@Valid @ModelAttribute("product") AddProductDto addProductDto
            , BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        Collection<Category> categoryList = categoryService.findAll();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", addProductDto);

        if (bindingResult.hasErrors()) {
            return "admin/addProduct";
        }

        try {

//            if (new Random().nextBoolean()) {
//                throw new RuntimeException("Error");
//            }

            productService.createProduct(addProductDto);
            attributes.addFlashAttribute("message", "Product added successfully");
        } catch (AlreadyExistsException aE) {
            bindingResult.rejectValue("name", "error.product.alreadyExists", aE.getMessage());
            return "admin/newProduct";
        } catch (CategoryNotFoundException cE) {
            bindingResult.rejectValue("categoryId", "error.category.doesntExist", cE.getMessage());
            return "admin/newProduct";
        } catch (Exception e) {
            bindingResult.reject("", e.getMessage());
            return "admin/newProduct";
        }

        return "redirect:/admin/products";
    }

}
