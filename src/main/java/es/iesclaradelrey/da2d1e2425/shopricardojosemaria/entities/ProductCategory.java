package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductCategory {
    private long id;
    private String name;
    private String description;
    private String image;
}
