package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/products")
@AllArgsConstructor
public class ProductAdminController {

    private final ProductService productService;

    @GetMapping({"","/"})
    public String categoryAdmin(@RequestParam(defaultValue = "1") Integer pageNumber,
                                @RequestParam(defaultValue = "5") Integer pageSize,
                                @RequestParam(defaultValue = "category.name") String orderBy,
                                @RequestParam(defaultValue = "asc") String orderDir,
                                Model model) {
        Map<String,String>orders= new LinkedHashMap<>();
        orders.put("Id", "id");
        orders.put("Name", "name");
        orders.put("Category", "category.name");
        model.addAttribute("products", productService.findAll(pageNumber,
                pageSize,orderBy,orderDir));
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("orderDir", orderDir);
        model.addAttribute("orders", orders);
        return "admin/adminProducts";
    }
}
