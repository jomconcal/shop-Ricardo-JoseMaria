package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService{
    long count();
    void save(Category category);
    Collection<Category> findAll();
    Optional<Category> findById(Long id);
}
