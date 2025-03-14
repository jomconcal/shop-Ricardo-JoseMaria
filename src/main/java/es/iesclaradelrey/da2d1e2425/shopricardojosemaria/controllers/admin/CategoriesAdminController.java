package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

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
}
