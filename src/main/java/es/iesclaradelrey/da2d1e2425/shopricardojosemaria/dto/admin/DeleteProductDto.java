package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteProductDto {
    private String name;
    private String description;

    public DeleteProductDto(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
    }

}
