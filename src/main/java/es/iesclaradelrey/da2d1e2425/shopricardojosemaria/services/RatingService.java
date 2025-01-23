package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Rating;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    Optional<Double> averageRatingByProductId(@Param("productId") Long id);
    List<Rating> getRatingsByProductId(@Param("productId") Long id);
}
