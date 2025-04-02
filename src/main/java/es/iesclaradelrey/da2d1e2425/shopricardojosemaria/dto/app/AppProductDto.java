package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppProductDto {
    private Long id;
    private String categoryName;
    private String name;
    private String description;
    private String productDetail;
    private Integer stock;
    private Double price;
    private String imageUrl;
}
