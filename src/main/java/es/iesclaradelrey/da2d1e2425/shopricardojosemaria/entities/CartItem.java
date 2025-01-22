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
@Table(name = "cart-item", uniqueConstraints = @UniqueConstraint(columnNames = {"product_id"}))
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private LocalDateTime addingDate;
    private LocalDateTime updatingDate;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
