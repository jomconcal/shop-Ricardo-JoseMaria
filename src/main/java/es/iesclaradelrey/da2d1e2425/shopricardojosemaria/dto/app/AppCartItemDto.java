package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AppCartItemDto {
    private int quantity;
    @CreationTimestamp
    private LocalDateTime addingDate;
    @UpdateTimestamp
    private LocalDateTime updatingDate;
    private Long productId;
    private String productName;
    private String imageUrl;
    private Double unitPrice;
    private Double totalPrice;
}
