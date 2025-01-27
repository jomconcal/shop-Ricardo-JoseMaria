package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import org.springframework.data.repository.ListCrudRepository;

public interface CartItemRepository extends ListCrudRepository<CartItem, Long> {
}
