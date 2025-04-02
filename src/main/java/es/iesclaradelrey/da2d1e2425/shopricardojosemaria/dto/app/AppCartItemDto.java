package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AppCartItemDto {
    private int quantity;
    private LocalDateTime addingDate;
    private LocalDateTime updatingDate;
    private Long productId;
    private String productName;
}
