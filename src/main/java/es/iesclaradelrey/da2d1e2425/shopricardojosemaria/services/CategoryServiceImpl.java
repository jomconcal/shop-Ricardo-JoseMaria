package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.generic.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Collection<Category> findAll() {
        return categoryRepository.findAll();
    }

}
