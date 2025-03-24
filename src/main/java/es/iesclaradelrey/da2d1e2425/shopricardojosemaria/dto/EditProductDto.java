package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EditProductDto {
    @NotNull(message = "Please select one category")
    private Long categoryId;
    @NotBlank(message = "Please enter a name")
    private String name;
    private String description;
    private String productDetail;
    private Integer stock;
    @NotNull(message = "Please enter a valid price")
    private Double price;
    private String imageUrl;

    public EditProductDto(Product product) {
        this.categoryId = product.getCategory().getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.productDetail = product.getProductDetail();
        this.stock = product.getStock();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
    }

}
