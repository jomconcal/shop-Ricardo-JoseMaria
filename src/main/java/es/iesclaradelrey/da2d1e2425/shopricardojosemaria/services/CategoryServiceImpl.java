package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.ProductCategory;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.generic.ProductCategoryRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    //La variable es de tipo interfaz, pero la inicialización será de la clase.
    private final ProductCategoryRep productCategoryRep;

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
