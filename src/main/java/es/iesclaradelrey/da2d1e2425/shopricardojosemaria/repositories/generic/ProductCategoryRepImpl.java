package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.ProductCategory;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.base.RepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.*;

//No entiendo por qué tengo que hacer extends e implements. Me parece redundante. ¿No funcionaría sólo con uno de los dos?
@Repository
public class ProductCategoryRepImpl extends RepositoryImpl<ProductCategory> implements ProductCategoryRep {

    Map<Long, ProductCategory> productCategories = new HashMap<Long, ProductCategory>();

    @Override
    public long count() {
        return productCategories.size();
    }

    @Override
    public void save(ProductCategory productCategory) {
        productCategories.put(productCategory.getId(), productCategory);
    }

    @Override
    public Collection<ProductCategory> findAll() {
        return productCategories.values();
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        if(productCategories.containsKey(id))
            return Optional.of(productCategories.get(id));
        return Optional.empty();
    }
}
