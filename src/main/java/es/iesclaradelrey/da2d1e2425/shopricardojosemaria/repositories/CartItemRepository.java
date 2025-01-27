package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CartItemRepository extends ListCrudRepository<CartItem, Long> {

    Optional<CartItem> findByProductId(Long productId);
}
