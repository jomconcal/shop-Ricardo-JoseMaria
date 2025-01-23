package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Rating;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {
    RatingRepository ratingRepository;

    @Override
    public Optional<Double> averageRatingByProductId(Long id) {
        return ratingRepository.averageRatingByProductId(id);
    }

    @Override
    public List<Rating> getRatingsByProductId(Long id) {
        return ratingRepository.findRatingByProductId(id);
    }
}
