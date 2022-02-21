package ru.ssau.labs.toolwarehousebackend.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true )
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    private final UserDetailsService userDetailsService;

//    private final AuthTokenFilter authTokenFilter;
//
//    private final RestAuthEntryPointJwt restAuthEntryPointJwt;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.cors().and().csrf().disable()
               // .exceptionHandling()
                //authenticationEntryPoint(restAuthEntryPointJwt).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers(
                        "/auth/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html**",
                        "/webjars/**",
                        "/v2/api-docs",
                        "/swagger-ui/**",
                        "favicon.ico"
                ).permitAll()
                .anyRequest().authenticated();*/

        //http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors().and().csrf().disable();
    }
}
