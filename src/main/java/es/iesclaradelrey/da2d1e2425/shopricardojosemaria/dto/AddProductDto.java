package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddProductDto {
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
}
