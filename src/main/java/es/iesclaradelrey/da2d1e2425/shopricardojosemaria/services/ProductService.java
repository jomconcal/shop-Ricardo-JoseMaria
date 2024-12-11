package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {
    long count();
    void save(Product product);
    Collection<Product> findAll();
    Collection<Product> findByCategory(Long categoryId);
}
