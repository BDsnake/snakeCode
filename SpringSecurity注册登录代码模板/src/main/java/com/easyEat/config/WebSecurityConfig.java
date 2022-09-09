package com.easyEat.config;


import com.easyEat.handler.LoginEntryHandler;
import com.easyEat.handler.LoginFailHandler;
import com.easyEat.handler.LoginSuccessHandler;
import com.easyEat.handler.LogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.ws.rs.HttpMethod;

/**
 * @author BDsnake
 * @since 2022/7/17 17:59
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法级安全验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 指定加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/register").permitAll() // 允许post请求/add-user，而无需认证
                .antMatchers(HttpMethod.POST, "/login").permitAll() // 允许post请求/add-user，而无需认证
                .antMatchers("/kfc/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()// 所有请求都需要验证
                .and()
                .formLogin().loginProcessingUrl("/login") // 分离登录
                .usernameParameter("username").passwordParameter("password")
                .successHandler(new LoginSuccessHandler())
                .failureHandler(new LoginFailHandler())
                .and()
                .logout().logoutSuccessHandler(new LogoutHandler())
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginEntryHandler())
                .and()
                .csrf().disable();// post请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 从数据库读取的用户进行身份认证
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
