package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.config;

import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.entities.AppUser;
import es.iesclaradelrey.da2d1e2425.shopricardojosemaria.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Componente que se ejecuta automáticamente al iniciar la aplicación para codificar las contraseñas
 * de los usuarios que aún no la tienen codificada.
 */
@Component
public class EncodePasswordsCommandLineRunners implements CommandLineRunner {

    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;

    public EncodePasswordsCommandLineRunners(AppUserService appUserService, PasswordEncoder passwordEncoder) {
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        List<AppUser> allUsers = appUserService.findAll();

        for (AppUser appUser : allUsers) {
            String oldPassword = appUser.getPassword();
            if (!maybeBcryptHash(oldPassword)) {
                appUser.setPassword(passwordEncoder.encode(oldPassword));
                appUserService.save(appUser);
            }
        }
    }

    private boolean maybeBcryptHash(String password) {
        return password != null && password.matches("^\\$2[aby]?\\$\\d{2}\\$.{53}$");
    }

}