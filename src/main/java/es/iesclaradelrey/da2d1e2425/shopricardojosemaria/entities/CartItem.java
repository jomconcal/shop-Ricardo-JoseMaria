package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cart_item", uniqueConstraints = @UniqueConstraint(columnNames = {"product_id"}))
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp",insertable = false, updatable = false)
    private LocalDateTime addingDate;
    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp on update current_timestamp",insertable = false, updatable = false)
    private LocalDateTime updatingDate;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private AppUser appUser;

    public CartItem(int quantity, Product product, AppUser appUser) {
        this.quantity = quantity;
        this.product = product;
        this.appUser = appUser;
    }
}
