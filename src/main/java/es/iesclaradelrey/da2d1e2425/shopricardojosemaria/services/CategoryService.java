package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService{
    void save(Category category);
    Collection<Category> findAll();
}
