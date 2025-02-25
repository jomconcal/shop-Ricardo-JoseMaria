package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;
    private ProductRepository productRepository;

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Collection<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public void createProduct(AddProductDto addProductDto) {

        if(productRepository.existsProductByNameIgnoreCase(addProductDto.getName())) {
            throw new AlreadyExistsException("Product with name "+addProductDto.getName()+" already exists");
        }

        Product product = new Product();
        product.setCategory(categoryService.findById(addProductDto.getCategoryId()).orElseThrow());
        product.setName(addProductDto.getName());
        product.setDescription(addProductDto.getDescription());
        product.setPrice(addProductDto.getPrice());
        product.setStock(addProductDto.getStock());
        product.setImageUrl(addProductDto.getImageUrl());
        productRepository.save(product);
    }
}
