package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.admin;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteCategoryDto {
    @NotBlank(message = "Please enter a name")
    private String name;
    private String description;

    public DeleteCategoryDto(Category category) {
        this.name = category.getName();
        this.description = category.getDescription();
    }
}
