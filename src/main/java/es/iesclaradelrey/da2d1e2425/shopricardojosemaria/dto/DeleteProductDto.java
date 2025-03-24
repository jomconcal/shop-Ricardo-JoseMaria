package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteProductDto {
    @NotNull(message = "Please select one category")
    private Long categoryId;
    @NotBlank(message = "Please enter a neme")
    private String name;
    private String description;
    private String productDetail;
    private Integer stock;
    @NotNull(message = "Please enter a valid price")
    private Double price;

    public DeleteProductDto(Product product) {
        this.categoryId = product.getCategory().getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.productDetail = product.getProductDetail();
        this.stock = product.getStock();
        this.price = product.getPrice();
    }

}
