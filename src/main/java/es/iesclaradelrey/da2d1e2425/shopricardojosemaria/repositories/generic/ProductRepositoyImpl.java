package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.generic;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.base.RepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoyImpl extends RepositoryImpl<Product,Long> implements ProductRepository{
}
