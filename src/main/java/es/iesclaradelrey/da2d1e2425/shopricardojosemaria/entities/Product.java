package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String description;
    private String productDetail;
    private Double price;
    private String imageUrl;
    @OneToMany(mappedBy = "product")
    private Set<Rating> ratings;
    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems;

}
