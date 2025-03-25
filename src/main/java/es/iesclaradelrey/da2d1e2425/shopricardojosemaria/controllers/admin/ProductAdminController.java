package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin.AddProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin.DeleteProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin.EditProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.CategoryNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.ProductNotFoundException;
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

    @GetMapping({"/new","/new/"})
    public String getAddProduct(Model model) {
        Collection<Category> categoryList = categoryService.findAll();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", new AddProductDto());
        model.addAttribute("title", "Add new product");
        model.addAttribute("textButton", "Add");
        
        return "admin/newProduct";
    }

    @PostMapping({"/new", "/new/"})
    public String postAddProduct(@Valid @ModelAttribute("product") AddProductDto addProductDto
            , BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        Collection<Category> categoryList = categoryService.findAll();

        model.addAttribute("categoryList", categoryList);
//        model.addAttribute("product", addProductDto);
        model.addAttribute("textButton", "Add");
        model.addAttribute("title", "Add new product");


        if (bindingResult.hasErrors()) {
            return "admin/newProduct";
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

    @GetMapping("/edit/{idProduct}")
    public String getEditProduct(Model model, @PathVariable Long idProduct) {
        Product product = productService.findById(idProduct).orElseThrow();
        EditProductDto editProductDto = new EditProductDto(product);

        Collection<Category> categoryList = categoryService.findAll();

        model.addAttribute("product", editProductDto);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("title", "Edit Product");
        model.addAttribute("textButton", "Update");

        return "admin/newProduct";
    }

    @PostMapping ("/edit/{idProduct}")
    public String postEditCategory(Model model, @PathVariable Long idProduct,
                                   @Valid @ModelAttribute("product") EditProductDto editProductDto,
                                   BindingResult bindingResult,
                                   RedirectAttributes attributes) {

        Collection<Category> categoryList = categoryService.findAll();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("title", "Edit Product");
        model.addAttribute("textButton", "Update");
        try{
//            if (new Random().nextBoolean()) {
//                throw new RuntimeException("Error");
//            }
            if(bindingResult.hasErrors()) {
                System.out.println(bindingResult.getAllErrors());
                return "admin/newProduct";
            }
            productService.updateProduct(editProductDto, idProduct);
        } catch (AlreadyExistsException e) {
            bindingResult.rejectValue("name",null, e.getMessage());
            return "admin/newProduct";
        } catch (CategoryNotFoundException e) {
            bindingResult.rejectValue("categoryId",null, e.getMessage());
            return "admin/newProduct";
        } catch (Exception e) {
            bindingResult.reject("", e.getMessage());
            return "admin/newProduct";
        }
        attributes.addFlashAttribute("message", "Category updated successfully");
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{idProduct}")
    public String getDeleteCategory(Model model,@PathVariable Long idProduct) {
        Product product= productService.findById(idProduct).orElseThrow();
        DeleteProductDto deleteProductDto = new DeleteProductDto(product);

        model.addAttribute("product", deleteProductDto);

        return "admin/deleteProduct";
    }

    @PostMapping("/delete/{idProduct}")
    public String postDeleteCategory(@PathVariable Long idProduct,
                                     @Valid @ModelAttribute("product") DeleteProductDto deleteProductDto,
                                     BindingResult bindingResult,
                                     RedirectAttributes attributes,Model model) {

//        System.out.println(deleteCategoryDto);
//        model.addAttribute("category", deleteCategoryDto);

        try{
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Error");
            }
            productService.deleteProduct(idProduct);
            attributes.addFlashAttribute("message", "Product deleted successfully");
            return "redirect:/admin/products";
        }catch (ProductNotFoundException e) {
            bindingResult.reject("", e.getMessage());
            return "redirect:/admin/products";
        } catch (Exception e) {
            bindingResult.reject("", e.getMessage());
            System.out.println(e.getMessage());
        }
        return "admin/deleteProduct";

    }

}
