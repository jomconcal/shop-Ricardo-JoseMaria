package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddCategoryDto {
    @NotBlank(message = "Please enter a name")
    private String name;
    private String description;
    private String imageUrl;
}
