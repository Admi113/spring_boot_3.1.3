package com.nikanorov.task_3_1_1.spring_boot.config;

import com.nikanorov.task_3_1_1.spring_boot.config.handler.LoginSuccessHandler;
import com.nikanorov.task_3_1_1.spring_boot.config.handler.LogoutSuccessHandlerr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("ADMIN").password("ADMIN").roles("ADMIN");
//    }
    private LoginSuccessHandler loginSuccessHandler;
    private UserDetailsService userService;
    private LogoutSuccessHandlerr logoutSuccessHandlerr;


    @Autowired
    public SecurityConfig(LoginSuccessHandler loginSuccessHandler
            , @Qualifier("userServiceDetails") UserDetailsService userService
            ,LogoutSuccessHandlerr logoutSuccessHandlerr) {
        this.loginSuccessHandler = loginSuccessHandler;
        this.userService = userService;
        this.logoutSuccessHandlerr =logoutSuccessHandlerr;
    }

//    public SecurityConfig(boolean disableDefaults, LoginSuccessHandler loginSuccessHandler, UserDetailsService userService) {
//        super(disableDefaults);
//        this.loginSuccessHandler = loginSuccessHandler;
//        this.userService = userService;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()// указываем страницу с формой логина
//                .loginPage("/users/login")
//                //указываем логику обработки при логине
                .successHandler(loginSuccessHandler)

//                // указываем action с формы логина
//                .loginProcessingUrl("/users/login")
////                // Указываем параметры логина и пароля с формы логина
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                // даем доступ к форме логина всем
                .permitAll();
//
        http.logout()
                // разрешаем делать логаут всем
                .permitAll()
                // указываем URL логаута
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // указываем URL при удачном логауте
//                .logoutSuccessUrl("/login?logout")
                .logoutSuccessHandler(logoutSuccessHandlerr)
                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
                .and().csrf().disable();


        http
                // делаем страницу регистрации недоступной для авторизированных пользователей
                .authorizeRequests()
                //страницы аутентификаци доступна всем
                .antMatchers("/login").anonymous()
                // защищенные URL
                .antMatchers("/admin/**")
                .access("hasAnyRole('ADMIN')")
                .antMatchers("/users/**")
                .access("hasAnyRole('ADMIN','USER')")
                .anyRequest().authenticated();
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }

    //    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

}
