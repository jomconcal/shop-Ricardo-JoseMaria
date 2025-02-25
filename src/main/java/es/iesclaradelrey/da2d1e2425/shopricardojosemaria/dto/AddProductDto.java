package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddProductDto {

    private Long categoryId;
    private String name;
    private String description;
    private String productDetail;
    private Integer stock;
    private Double price;
    private String imageUrl;
}
