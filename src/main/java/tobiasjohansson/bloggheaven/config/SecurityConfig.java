package tobiasjohansson.bloggheaven.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.management.HttpSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@EnableWebSecurity
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        SimpleAuthorityMapper grantedAuthorityWrapper = new SimpleAuthorityMapper();
        KeycloakAuthenticationProvider authenticationProvider = keycloakAuthenticationProvider();
        authenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityWrapper);
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    @Override
    @ConditionalOnMissingBean(HttpSessionManager.class)
    protected HttpSessionManager httpSessionManager() {
        return new HttpSessionManager();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http

                .authorizeHttpRequests()
                // PERMIT ALL
                .antMatchers("/api/newuser").permitAll()
                .antMatchers("/api/posts").permitAll()
                .antMatchers("/api/posts/{id}").permitAll()

                // USER
                .antMatchers("/api/deletepost/{id}").hasRole("user")
                .antMatchers("/api/updatepost/{id}").hasRole("user")
                .antMatchers("/api/newpost").hasRole("user")

                // ADMIN
                .antMatchers("/api/users").hasRole("admin")
                .antMatchers("/api/{id}").hasRole("admin")

                .anyRequest().authenticated();
        http.csrf().disable();

    }
}