package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserDetailsService{
//    public class AppUserDetailsService implements UserDetailsService {


//    private final AppUserRepository appUserRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Buscar el usuario con el servicio / repositorio de usuarios de la aplicacion usando
//        // como como username lo que se haya establecido.
//        // En este caso se buca por email
//
//        AppUser appUser = appUserRepository.findByEmail(username).orElseThrow(
//                () -> new UsernameNotFoundException("User with email " + username + " not found: ")
//        );
//
//        return User
//                .withUsername(username)
//                .password(appUser.getPassword())
//                .build();
//    }

}
