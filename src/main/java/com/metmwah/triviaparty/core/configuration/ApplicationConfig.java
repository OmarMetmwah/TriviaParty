package com.metmwah.triviaparty.core.configuration;

import com.metmwah.triviaparty.core.entity.BasicUser;
import com.metmwah.triviaparty.core.exception.WrongCredentialsException;
import com.metmwah.triviaparty.feature.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Configuration
@EnableAsync
@RequiredArgsConstructor
public class ApplicationConfig {

    private final PlayerRepository playerRepository;

    private final static int BCRYPT_STRENGTH = 10; // log base 2 of hashing rounds

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Optional<? extends BasicUser> user = playerRepository.findByEmail(username);
            //TODO: ADD all other types of users
            return user.orElseThrow(WrongCredentialsException::new);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCRYPT_STRENGTH);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
