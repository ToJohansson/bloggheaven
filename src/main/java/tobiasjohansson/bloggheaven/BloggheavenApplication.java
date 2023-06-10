package tobiasjohansson.bloggheaven;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloggheavenApplication {

    /**
     *
     * Author: Tobias Johansson
     */

    public static void main(String[] args) {
        SpringApplication.run(BloggheavenApplication.class, args);
    }

    @Bean // För att slippa använda keycloak.json
    public KeycloakSpringBootConfigResolver keycloakSpringBootConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }
}
