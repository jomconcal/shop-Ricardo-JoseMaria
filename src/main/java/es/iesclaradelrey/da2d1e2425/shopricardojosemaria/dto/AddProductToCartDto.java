package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddProductToCartDto {
    private Long productId;
    private Integer quantity;
}
