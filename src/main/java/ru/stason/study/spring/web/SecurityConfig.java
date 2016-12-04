package ru.stason.study.spring.web;

import org.springframework.context.annotation.Configuration;
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
                .and().formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").and()
                .httpBasic()
                .and().requiresChannel().anyRequest().requiresSecure();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("livotov").password("krutoi").roles("ADMIN").and().withUser("anna")
                .password("krutaya").roles("USER");

        //auth
        //        .jdbcAuthentication()
        //        .dataSource(dataSource)
        //        .usersByUsernameQuery(
        //                "select username, password, true " +
        //                        "from Spitter where username=?")
        //        .authoritiesByUsernameQuery(
        //                "select username, 'ROLE_USER' from Spitter where username=?")
        //.passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }
}
