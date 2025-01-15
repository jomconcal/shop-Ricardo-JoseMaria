package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Rating;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RatingRepository extends ListCrudRepository<Rating, Long> {
    List<Rating> findByProductId(Long id);
}
