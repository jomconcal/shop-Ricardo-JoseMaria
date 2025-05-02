package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class AppListCategoriesDto {
    private Collection<AppCategoryDto> categories;
}
