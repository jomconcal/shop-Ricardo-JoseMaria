package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService{
    void save(Category category);
    Collection<Category> findAll();
    Optional<Category> findById(Long id);
    void create(String name, String description);

}
