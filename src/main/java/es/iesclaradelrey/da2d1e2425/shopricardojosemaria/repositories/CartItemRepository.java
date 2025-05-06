package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByProductId(Long productId);
    @Query("select ci from CartItem ci where ci.appUser.id=:userId")
    Collection<CartItem> findAllByAppUserId(Long userId);
    @Transactional
    @Modifying
    @Query("delete from CartItem ci where ci.appUser.id=:userId")
    void deleteAllByUserId(Long userId);
}
