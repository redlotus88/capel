package com.redlotus.security.config;

import com.redlotus.security.common.CapelEnvironmentUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Capel Web Security Configuration.
 * <p>
 * 来自官网的注释：
 * When to use CSRF protection 什么时候使用CSRF保护.
 * When should you use CSRF protection? Our recommendation is to use CSRF protection for any request that could be processed by a browser by normal users.
 * If you are only creating a service that is used by non-browser clients, you will likely want to disable CSRF protection.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Log4j2
public class CapelSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Spring Security Configure.
     *
     * - 开发环境禁用CSRF。
     * - 配置API接口的权限。
     *
     * @param http HttpSecurity
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApplicationContext applicationContext = getApplicationContext();
        if (CapelEnvironmentUtils.isDev(applicationContext.getEnvironment().getActiveProfiles())) {
            log.info("当前环境为开发环境， 禁用CSRF保护");
            http.csrf().disable();
        } else {
            log.info("当前环境非开发环境，CSRF保护启用。");
        }

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/swagger-resources/**", "/v2/api-docs/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
