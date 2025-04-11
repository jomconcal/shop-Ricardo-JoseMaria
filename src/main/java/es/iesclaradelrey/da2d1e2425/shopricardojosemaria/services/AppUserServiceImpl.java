package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.App;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.dto.RegisterUserDto;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.errors.UserNameAlreadyExistsException;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserServiceImpl {
 //   public class AppUserServiceImpl implements AppUserService {
//    private final AppUserRepository appUserRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public AppUser register(RegisterUserDto registerUserDto) {
//        if(appUserRepository.existsByEmail(registerUserDto.getEmail())){
//            throw new UserNameAlreadyExistsException(registerUserDto.getEmail()+" exists already");
//        }
//
//        AppUser appUser = AppUser.builder()
//                .email(registerUserDto.getEmail())
//                .password(passwordEncoder.encode(registerUserDto.getPassword()))
//                .firstName(registerUserDto.getFirstName())
//                .lastName(registerUserDto.getLastName())
//                .build();
//
//        return appUserRepository.save(appUser);
//    }

}
