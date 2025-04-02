package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin.AddProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin.EditProductDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.AlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.CategoryNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.ForeignKeyViolationException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.ProductNotFoundException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.CategoryRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.ProductRepository;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.RatingRepository;
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
    private final CategoryRepository categoryRepository;
    private final RatingRepository ratingRepository;
    private ProductRepository productRepository;

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

        if(!categoryRepository.existsById(addProductDto.getCategoryId())) {
            throw new CategoryNotFoundException("Category with id "+addProductDto.getCategoryId()+" does not exist");
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

    @Override
    public Page<Product> findAll(String search, Long cat, Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
        Sort.Direction direction = orderDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(pageNumber , pageSize, Sort.by(direction, orderBy));

        if (cat==null){
            if(search.isBlank()) {
                return productRepository.findAll(pageable);
            }else{
                return productRepository.findProductsBySearch(search, pageable);
            }
        }else{
            if(search.isBlank()) {
                return productRepository.findProductsByCategoryId(cat,pageable);
            }
        }
        return productRepository.findProductsBySearchAndCategoryId(search,cat,pageable);
    }

    @Override
    public void updateProduct(EditProductDto editProductDto, Long idProduct) {

        Product product = productRepository.findById(idProduct).orElseThrow(()->
                new ProductNotFoundException("Product with id "+idProduct+" does not exist")
        );

        if(!product.getName().equalsIgnoreCase(editProductDto.getName())&&
                productRepository.existsProductByNameIgnoreCase(editProductDto.getName())) {
            throw new AlreadyExistsException("Product with name "+editProductDto.getName()+" already exists");
        }

        if(!categoryRepository.existsById(editProductDto.getCategoryId())) {
            throw new CategoryNotFoundException("Category with id "+editProductDto.getCategoryId()+" does not exist");
        }




        product.setName(editProductDto.getName());
        product.setDescription(editProductDto.getDescription());
        product.setProductDetail(editProductDto.getProductDetail());

        if(editProductDto.getStock() == null || editProductDto.getStock() < 0) {
            product.setStock(0);
        }else{
            product.setStock(editProductDto.getStock());
        }

        product.setPrice(editProductDto.getPrice());

        if(editProductDto.getImageUrl().isEmpty()){
            editProductDto.setImageUrl("/img/products/others/defaultImage.jpg");
        }
        product.setImageUrl(editProductDto.getImageUrl());

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        if(ratingRepository.existsRatingByProductId(idProduct)) {
            throw new ForeignKeyViolationException("This product is already rated. Delete first the ratings associated with this product.");
        }
      productRepository.deleteById(idProduct);
    }

}
