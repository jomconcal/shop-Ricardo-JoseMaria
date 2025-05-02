package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.AppListCategoriesDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/categories")
public class CategoryAppController {

    private final CategoryService categoryService;


    @GetMapping("/find")
    public ResponseEntity<AppListCategoriesDto>getCategories(){

        Collection<Category>categories=categoryService.findAll();
        ModelMapper modelMapper=new ModelMapper();
        List<AppCategoryDto> appCategories=categories
                .stream()
                .map(category ->
                        modelMapper.map(category, AppCategoryDto.class))
                .toList();

        List<AppCategoryDto> mutableList = new ArrayList<>(appCategories);

        mutableList.addFirst(new AppCategoryDto(null,"All"));
        AppListCategoriesDto appListCategoriesDto=new AppListCategoriesDto(mutableList);
        return ResponseEntity.ok(appListCategoriesDto);
    }
}
