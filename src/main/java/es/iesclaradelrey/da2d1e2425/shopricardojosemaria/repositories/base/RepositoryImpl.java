package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.base;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Entity;

import java.util.*;

public class RepositoryImpl<T extends Entity<ID>, ID> implements Repository<T, ID> {
    Map<ID, T> productCategories = new HashMap<>();

    @Override
    public long count() {
        return productCategories.size();
    }

    @Override
    public void save(T T) {
        productCategories.put(T.getId(), T);
    }

    @Override
    public Collection<T> findAll() {
        return productCategories.values();
    }

    @Override
    public Optional<T> findById(ID id) {
        if (productCategories.containsKey(id))
            return Optional.of(productCategories.get(id));
        return Optional.empty();
    }
}
