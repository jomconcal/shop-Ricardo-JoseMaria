package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product,Long> {
}
