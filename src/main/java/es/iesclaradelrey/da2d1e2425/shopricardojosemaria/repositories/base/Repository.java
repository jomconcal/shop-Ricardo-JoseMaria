package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.base;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T,ID> {
    long count();
    void save(T t);
    Collection<T> findAll();
    Optional<T> findById(ID id);
}