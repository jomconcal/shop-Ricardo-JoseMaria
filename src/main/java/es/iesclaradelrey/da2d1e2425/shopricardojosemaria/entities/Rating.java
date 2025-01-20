package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ratings", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name","product_id"})})
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double rating;
    private String userName;
    @Column(length = 1000)
    private String comment;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Rating(double rating, String userName, String comment, LocalDateTime date, Product product) {
        this.rating = rating;
        this.userName = userName;
        this.comment = comment;
        this.date = date;
        this.product = product;
    }

}
