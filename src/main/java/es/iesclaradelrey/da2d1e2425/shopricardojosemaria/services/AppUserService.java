package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.RegisterUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;

public interface AppUserService {
    AppUser register(RegisterUserDto registerUserDto);
}
