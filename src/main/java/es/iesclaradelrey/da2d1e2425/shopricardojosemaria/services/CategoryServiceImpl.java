package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.ProductCategory;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.generic.ProductCategoryRepImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final ProductCategoryRepImpl productCategoryRep;

    @Override
    public long count() {
        return productCategoryRep.count();
    }

    @Override
    public void save(ProductCategory productCategory) {
        productCategoryRep.save(productCategory);
    }

    @Override
    public Collection<ProductCategory> findAll() {
        return productCategoryRep.findAll();
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        return productCategoryRep.findById(id);
    }
}
