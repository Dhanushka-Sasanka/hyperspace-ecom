package com.b127.exams.utils.security;

import com.b127.exams.utils.security.jwt.AuthEntryPointJwt;
import com.b127.exams.utils.security.jwt.AuthTokenFilter;
import com.b127.exams.utils.security.services.custome.impl.UserDetailsServiceImpl;

import com.b127.exams.utils.service.UrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



/**
 * @author dhanu
 * @since 3/1/2021 4:58 PM
 **/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl  userDetailService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(UrlProvider.AUTH_SERVICE +"/**").permitAll()
                .antMatchers(UrlProvider.EXAMS_SERVICE +"/**").permitAll()
                .antMatchers(UrlProvider.LEADER_BOARD_SERVICE +"/**").permitAll()
                .antMatchers(UrlProvider.TEMPLATE_ADMIN_SERVICE +"/**").permitAll()
                .antMatchers(UrlProvider.PAPER_SERVICE +"/**").permitAll()
                .antMatchers(UrlProvider.REPORT_SERVICE +"/**").permitAll()
                .antMatchers("/test/**").hasRole("USER")
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**",
                        "/static/**",
                        "/dist/**",
                        "/css/**",
                        "/js/**",
                        "/img/**"
                        ,"/lib/**"
                );
    }
}
