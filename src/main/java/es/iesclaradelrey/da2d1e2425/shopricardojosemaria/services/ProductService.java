package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin.AddProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin.EditProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {
    long count();
    void save(Product product);
    Optional<Product> findById(long id);
    Collection<Product> findAll();
    Collection<Product> findByCategoryId(Long categoryId);

    void createProduct(AddProductDto addProductDto);

    Page<Product> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir);

    void updateProduct(EditProductDto editProductDto, Long idProduct);

    void deleteProduct(Long idProduct);
}
