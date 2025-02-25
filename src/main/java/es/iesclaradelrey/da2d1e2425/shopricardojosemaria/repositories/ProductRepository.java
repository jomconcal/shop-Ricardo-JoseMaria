package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Collection;

public interface ProductRepository extends ListCrudRepository<Product,Long> {

    //Consulta derivada. No hace falta definir el cuerpo. Lo hace IntelliJ que es muy listo y sabe lo que quiero.
    Collection<Product> findByCategoryId(Long categoryId);

    Boolean existsProductByNameIgnoreCase(String name);
}