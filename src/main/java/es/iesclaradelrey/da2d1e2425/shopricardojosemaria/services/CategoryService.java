package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.EditCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService{
    void save(Category category);
    Collection<Category> findAll();
    Optional<Category> findById(Long id);
    void create(String name, String description);

    Page<Category> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir);

    void createCategory(AddCategoryDto addCategoryDto);

    void updateCategory(EditCategoryDto editCategoryDto, Long id);

    void deleteCategory(Long id);
    void deleteAllProducts(Long id);
}
