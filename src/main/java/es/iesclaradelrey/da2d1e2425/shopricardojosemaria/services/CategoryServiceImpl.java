package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.EditCategoryDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.CategoryNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void create(String name, String description) {
        if (categoryRepository.existsCategoryByNameIgnoreCase(name)) {
            throw new AlreadyExistsException(String.format("Ya existe una categoría con el nombre %s", name));
        }
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryRepository.save(category);
    }

    @Override
    public Page<Category> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
        Sort.Direction direction = orderDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable categories = PageRequest.of(pageNumber-1, pageSize, Sort.by(direction, orderBy));
        return categoryRepository.findAll(categories);
    }

    @Override
    public void createCategory(AddCategoryDto addCategoryDto) {
        if(categoryRepository.existsCategoryByNameIgnoreCase(addCategoryDto.getName())) {
            throw new AlreadyExistsException("Category with name "+addCategoryDto.getName()+" already exists");
        }
        Category category = new Category();
        category.setName(addCategoryDto.getName());
        category.setDescription(addCategoryDto.getDescription());

        if(addCategoryDto.getImageUrl().isEmpty()){
            addCategoryDto.setImageUrl("/img/categories/default.jfif");
        }
        category.setImageUrl(addCategoryDto.getImageUrl());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(EditCategoryDto editCategoryDto, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->
            new CategoryNotFoundException("category not found")
        );

        category.setName(editCategoryDto.getName());
        category.setDescription(editCategoryDto.getDescription());

        if(editCategoryDto.getImageUrl().isEmpty()){
            editCategoryDto.setImageUrl("/img/categories/default.jfif");
        }
        category.setImageUrl(editCategoryDto.getImageUrl());
        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(Long id) {
        deleteAllProducts(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts(Long id) {
        categoryRepository.deleteAll(categoryRepository.findAllByProductsId(id));
    }

}
