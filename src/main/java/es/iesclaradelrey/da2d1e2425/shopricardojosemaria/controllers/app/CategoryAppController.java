package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/categories")
public class CategoryAppController {

    private final CategoryService categoryService;


    @GetMapping("/find")
    public ResponseEntity<List<AppCategoryDto>>getCategories(){

        Collection<Category>categories=categoryService.findAll();
        ModelMapper modelMapper=new ModelMapper();
        List<AppCategoryDto> appCategories=categories
                .stream()
                .map(category ->
                        modelMapper.map(category, AppCategoryDto.class))
                .toList();

        return ResponseEntity.ok(appCategories);
    }
}
