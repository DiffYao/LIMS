package com.laoxu.java.bookman.config;


import com.laoxu.java.bookman.common.MyPasswordEncoder;
import com.laoxu.java.bookman.model.User;
import com.laoxu.java.bookman.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Spring Security配置
 *
 * @author laoxu
 * @create 2018-10-26
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }*/
    @Autowired
    MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;

    @Resource
    private DataSource dataSource;

    @Resource(name = "userDetailServiceImpl")
    private UserDetailServiceImpl<User> userService;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 配置数据源
        jdbcTokenRepository.setDataSource(dataSource);
        // 第一次启动的时候自动建表（可以不用这句话，自己手动建表，源码中有语句的）
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new MyPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/book/list").permitAll()
                .antMatchers("/bookDetail/*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll().successHandler(myAuthenctiationSuccessHandler)
                .and().logout().permitAll()
                .and().headers().frameOptions().disable()
        ;

        //开启记住我功能
        //http.rememberMe().tokenRepository(persistentTokenRepository()).userDetailsService(userService).tokenValiditySeconds(86400);
        //http.rememberMe().rememberMeParameter("remember-me").key("laoxu").tokenValiditySeconds(86400);
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略
        web.ignoring().antMatchers("/static/**");
        web.ignoring().antMatchers("/","/index");
    }
}
