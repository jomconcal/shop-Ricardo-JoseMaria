package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends ListCrudRepository<Rating, Long> {
    @Query("select avg (r.rating) from Rating r where r.product.id= :productId")
    Optional<Double> averageRatingByProductId(@Param("productId") Long id);

    List<Rating> findRatingByProductId(Long productId);

    boolean existsRatingByProductId(Long productId);
}
