package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Category implements Entity<Long> {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
}
