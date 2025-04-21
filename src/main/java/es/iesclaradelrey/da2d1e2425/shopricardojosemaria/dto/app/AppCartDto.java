package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppCartDto {
    private Collection<AppCartItemDto> appCartItems;
    private Double totalPrice;
}
