package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;


import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.LoginUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.RegisterUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.JwtTokensDto;

/**
 * Interfaz que define los servicios de autenticación para la aplicación.
 * <p>
 * Esta interfaz contiene los métodos necesarios para el registro de un nuevo usuario
 * y el inicio de sesión de un usuario existente, generando los tokens de acceso y refresco
 * requeridos para la autenticación en la API.
 * </p>
 */
public interface AuthService {

    /**
     * Registra un nuevo usuario y genera los tokens de acceso y refresco para la autenticación.
     *
     * @param registerUserDto DTO que contiene los datos necesarios para registrar un nuevo usuario.
     * @return un {@link JwtTokensDto} con los tokens de acceso y refresco generados.
     */
    JwtTokensDto register(RegisterUserDto registerUserDto);

    /**
     * Realiza el inicio de sesión de un usuario, verificando sus credenciales y generando los tokens.
     *
     * @param loginUserDto DTO que contiene las credenciales (correo y contraseña) del usuario para iniciar sesión.
     * @return un {@link JwtTokensDto} con los tokens de acceso y refresco generados para el usuario autenticado.
     */
    JwtTokensDto login(LoginUserDto loginUserDto);

    JwtTokensDto refresh(String authHeader);
}