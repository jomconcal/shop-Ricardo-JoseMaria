package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.LoginUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.RegisterUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.app.JwtTokensDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AppUserService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AuthService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<JwtTokensDto> register(@RequestBody RegisterUserDto registerUserDto) {
        return ResponseEntity.ok(authService.register(registerUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokensDto> login(@RequestBody LoginUserDto loginUserDto) {
        return ResponseEntity.ok(authService.login(loginUserDto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtTokensDto> refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        return ResponseEntity.ok(authService.refresh(authHeader));
    }

    @PostMapping("/revoke")
    public ResponseEntity<Void> revoke() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
