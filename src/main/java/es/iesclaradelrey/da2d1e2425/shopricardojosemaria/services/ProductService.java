package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {
    long count();
    void save(Product product);
    Optional<Product> findById(long id);
    Collection<Product> findAll();
    Collection<Product> findByCategoryId(Long categoryId);
}
