package ru.stason.study.spring.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .regexMatchers("/spitter/register").hasRole("ADMIN")
                .regexMatchers("/spittles.*").hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll()
                .and().formLogin().and().httpBasic() //.loginPage("/login")
                .and().requiresChannel()
                .regexMatchers(HttpMethod.POST, "/spitter/register").requiresSecure()
                .anyRequest().requiresInsecure();

        http.portMapper()                //maps the port 8080(http) to 8080  (https)
                .http(8080).mapsTo(8080);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("livotov").password("krutoi").roles("ADMIN").and().withUser("anna")
                .password("krutaya").roles("USER");
    }
}
