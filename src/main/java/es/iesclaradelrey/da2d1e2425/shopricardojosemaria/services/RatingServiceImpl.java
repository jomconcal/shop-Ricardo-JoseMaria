package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Rating;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {
    RatingRepository ratingRepository;

    public OptionalDouble avg(Long productId) {
        List<Rating>ratings= ratingRepository.findByProductId(productId);
        return ratings.stream().mapToDouble(Rating::getRating).average();
    }

    @Override
    public Optional<Double> averageRatingByProductId(Long id) {
        return ratingRepository.averageRatingByProductId(id);
    }
}
