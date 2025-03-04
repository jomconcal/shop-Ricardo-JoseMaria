package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.AddProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        if(addProductDto.getStock() == null || addProductDto.getStock() < 0) {
            product.setStock(0);
        }else{
            product.setStock(addProductDto.getStock());
        }

        //añadimos imagen por defecto si no se pone ninguna imagen
        if(addProductDto.getImageUrl().isEmpty()){
            addProductDto.setImageUrl("/img/products/others/defaultImage.jpg");
        }
        product.setImageUrl(addProductDto.getImageUrl());
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
        Sort.Direction direction = orderDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(pageNumber-1 , pageSize, Sort.by(direction, orderBy));
        return productRepository.findAll(pageable);
    }
}
