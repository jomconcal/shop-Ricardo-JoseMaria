package es.iesclaradelrey.da2d1e2425.shopricardojosemaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad por defecto para las rutas web.
 * <p>
 * Esta clase proporciona la configuración de seguridad por defecto para la aplicación,
 * permitiendo el acceso sin restricciones a todas las rutas de la aplicación.
 * </p>
 * <p>
 * Se asigna un orden muy alto {@link Order}(999) para que esta configuración sea la última
 * aplicada cuando no exista ninguna otra configuración específica más restrictiva.
 * </p>
 * <p>
 * Esta clase asegura que, en ausencia de configuraciones adicionales, todas las solicitudes
 * se permitan sin ningún tipo de autenticación o autorización.
 * </p>
 *
 * @see HttpSecurity
 */
@Configuration
@Order(999) // El más alto porque es la configuración por defecto, cuando no aplica otra.
public class WebSecurityConfig {

    /**
     * Configura la cadena de filtros de seguridad para todas las rutas de la aplicación.
     * <p>
     * Permite el acceso sin restricciones a todas las solicitudes entrantes.
     * </p>
     * <p>
     * Esta configuración se aplica en la capa más general y está diseñada para ser
     * sobrescrita o complementada por otras configuraciones más específicas si es necesario.
     * </p>
     *
     * @param http instancia de {@link HttpSecurity} utilizada para configurar las políticas de seguridad.
     * @return un {@link SecurityFilterChain} configurado para permitir todas las solicitudes.
     * @throws Exception si ocurre algún error durante la configuración de la seguridad.
     */
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // De momento, permitir el acceso a cualquier parte de la aplicación.
        http.csrf(csrf ->
                        csrf.ignoringRequestMatchers("/api/cart"))
                .headers(heather ->
                        heather.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login-> login
                        .loginPage("/login")
                        .usernameParameter("email"));
        return http.build();
    }

}