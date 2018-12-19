package com.jp2;

import com.jp2.security.AccountLoginAuthenticationProvider;
import com.jp2.security.LoginFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountLoginAuthenticationProvider accountLoginAuthenticationProvider;

    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/Repairs",true)
                .failureUrl("/errorcred")
               // .successHandler(loginSucessHandler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/logout")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/","/login","/errorcred").permitAll()
                .antMatchers("/logout").anonymous()
                .antMatchers("/Owners/*").hasAuthority("ADMIN")
                .antMatchers("/Update/*").hasAuthority("ADMIN")
                .antMatchers("/Create").hasAuthority("ADMIN")
                .antMatchers("/Delete/*").hasAuthority("ADMIN")
                .antMatchers("/Repairs",
                        "/Data",
                        "/Repairs/Data",
                        "/Repairs/search").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/Repairs/*").hasAuthority("ADMIN")
                .and()
                .authenticationProvider(accountLoginAuthenticationProvider)
                .headers()
                .frameOptions()
                .sameOrigin();
    }
}
