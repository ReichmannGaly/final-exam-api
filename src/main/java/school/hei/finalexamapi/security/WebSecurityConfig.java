package school.hei.finalexamapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(GET,"/computers").authenticated()
                .antMatchers(GET,"/computers/*").authenticated()
                .antMatchers(POST,"/computers").authenticated()
                .antMatchers(PUT,"/computers/**").authenticated()
                .antMatchers(GET,"/softwares").authenticated()
                .antMatchers(GET,"/softwares/*").authenticated()
                .antMatchers(POST,"/softwares").authenticated()
                .antMatchers(PUT,"/softwares/**").authenticated()
                .antMatchers(GET,"/users").authenticated()
                .antMatchers(GET,"/users/*").authenticated()
                .antMatchers(POST,"/users").authenticated()
                .antMatchers(PUT,"/users/**").authenticated()
                .antMatchers(GET,"/peripherals").authenticated()
                .antMatchers(GET,"/peripherals/*").authenticated()
                .antMatchers(POST,"/peripherals").authenticated()
                .antMatchers(PUT,"/peripherals/**").authenticated()
                .antMatchers(GET,"/networkEquipments").authenticated()
                .antMatchers(GET,"/networkEquipments/*").authenticated()
                .antMatchers(POST,"/networkEquipments").authenticated()
                .antMatchers(PUT,"/networkEquipments/**").authenticated()
                .and()
                .formLogin()
                .and()
                .logout().permitAll()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
