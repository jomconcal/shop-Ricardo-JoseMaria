package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.controllers.app;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.LoginUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.RegisterUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.TokensDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AppUserService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AppUserServiceImpl;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.JwtService;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.JwtServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AppAuthController {
//
//    private final AppUserService appUserService;
//    private final JwtService jwtService;
//
//    @PostMapping("/register")
//    public ResponseEntity<TokensDto> register(@RequestBody RegisterUserDto registerUserDto) {
//        AppUser appUser = appUserService.register(registerUserDto);
//        String accessToken = jwtService.generateAccessToken(appUser);
//        String refreshToken = jwtService.generateRefreshToken(appUser);
//
//        return ResponseEntity.ok(TokensDto.builder()
//                .accessToken(accessToken)
//                .refreshToken(refreshToken)
//                .build());
//       // throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<TokensDto> login(@RequestBody LoginUserDto loginUserDto) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @PostMapping("/refresh")
//    public ResponseEntity<TokensDto> refresh() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @PostMapping("/revoke")
//    public ResponseEntity<TokensDto> revoke() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

}
