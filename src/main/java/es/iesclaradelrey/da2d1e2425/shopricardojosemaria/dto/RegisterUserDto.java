package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
