package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;


import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;

public interface JwtService {
    String generateAccessToken(AppUser user);

    String generateRefreshToken(AppUser user);

    void validateAccessToken(String token);

    void validateRefreshToken(String token);

    String extractUsername(String token);
}