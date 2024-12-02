package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import java.util.Collection;
import java.util.Optional;

public interface Service <T>{
    long count();
    void save(T t);
    Collection<T> findAll();
    Optional<T> findById(Long id);
}
