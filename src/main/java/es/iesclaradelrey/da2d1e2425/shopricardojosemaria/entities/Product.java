package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Entity<Long>{

    private Long id;
    private Category category;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
}
