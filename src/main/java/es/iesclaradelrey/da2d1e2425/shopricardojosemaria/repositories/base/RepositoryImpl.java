package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.base;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T> implements Repository<T> {
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void save(T t) {

    }

    @Override
    public Collection<T> findAll() {
        return List.of();
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.empty();
    }
}
