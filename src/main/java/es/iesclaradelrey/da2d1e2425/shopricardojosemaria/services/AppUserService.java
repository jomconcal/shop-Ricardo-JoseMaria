package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.RegisterUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser register(RegisterUserDto registerUserDto);

    Optional<AppUser> findByEmail(String email);

    AppUser save(AppUser user);

    List<AppUser> findAll();

    Optional<AppUser> currentUser();
}