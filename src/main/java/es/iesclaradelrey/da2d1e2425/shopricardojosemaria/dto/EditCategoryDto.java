package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditCategoryDto {
    @NotBlank(message = "Please enter a name")
    private String name;
    private String description;
    private String imageUrl;

    public EditCategoryDto(Category category) {
        this.name = category.getName();
        this.description = category.getDescription();
        this.imageUrl = category.getImageUrl();
    }
}
