package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import jakarta.persistence.*;
import lombok.*;

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

    public Product(Category category, String name, String description, String productDetail, Double price, String imageUrl) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.productDetail = productDetail;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
