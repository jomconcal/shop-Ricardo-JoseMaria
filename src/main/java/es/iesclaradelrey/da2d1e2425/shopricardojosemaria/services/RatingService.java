package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RatingService {
    Optional<Double> averageRatingByProductId(@Param("productId") Long id);
}
