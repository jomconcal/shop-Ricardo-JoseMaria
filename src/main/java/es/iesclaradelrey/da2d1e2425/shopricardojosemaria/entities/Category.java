package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="categories")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public Category(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

}
