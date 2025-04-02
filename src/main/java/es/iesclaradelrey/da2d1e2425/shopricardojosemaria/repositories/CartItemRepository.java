package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByProductId(Long productId);
}
