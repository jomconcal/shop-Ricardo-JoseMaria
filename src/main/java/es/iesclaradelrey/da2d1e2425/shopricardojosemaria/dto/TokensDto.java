package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
public class TokensDto {
    private String accessToken;
    private String refreshToken;
}
