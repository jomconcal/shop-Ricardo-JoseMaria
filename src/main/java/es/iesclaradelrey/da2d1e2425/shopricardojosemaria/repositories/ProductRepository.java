package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //Consulta derivada. No hace falta definir el cuerpo. Lo hace IntelliJ que es muy listo y sabe lo que quiero.
    Collection<Product> findByCategoryId(Long categoryId);

    Boolean existsProductByNameIgnoreCase(String name);
    Boolean existsProductByCategoryId(Long categoryId);
    Page<Product> findProductsByCategoryId(Long categoryId, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:search% OR p.description LIKE %:search%")
    Page<Product> findProductsBySearch(@Param("search") String search, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE (p.name LIKE %:search% OR p.description LIKE %:search%) AND p.category.id = :categoryId")
    Page<Product> findProductsBySearchAndCategoryId(@Param("search") String search, @Param("categoryId") Long categoryId, Pageable pageable);

}