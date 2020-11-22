package com.laoxu.java.bookman.config;

import com.laoxu.java.bookman.interceptor.SessionTimeoutInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**  mvc配置，例如：资源映射、视图解析、拦截器等
 * @author laoxu
 * @create 2018-10-23
 **/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    SessionTimeoutInterceptor sessionTimeoutInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/assets/ckeditor/**").
                addResourceLocations("classpath:/static/assets/ckeditor/").
                setCachePeriod(2592000);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/success").setViewName("success");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/book").setViewName("book");
        registry.addViewController("/bookAdd").setViewName("bookAdd");
        registry.addViewController("/bookEdit").setViewName("bookEdit");
        registry.addViewController("/bookBorrow").setViewName("bookBorrow");
        registry.addViewController("/bookBorrowAdd").setViewName("bookBorrowAdd");
        registry.addViewController("/bookBorrowEdit").setViewName("bookBorrowEdit");
        registry.addViewController("/bookReBorrow").setViewName("bookReBorrow");
        registry.addViewController("/bookReBorrowEdit").setViewName("bookReBorrowEdit");
        registry.addViewController("/bookReturn").setViewName("bookReturn");
        registry.addViewController("/bookCategory").setViewName("bookCategory");
        registry.addViewController("/bookLanguage").setViewName("bookLanguage");
        registry.addViewController("/bookPublisher").setViewName("bookPublisher");
        registry.addViewController("/bookShelf").setViewName("bookShelf");
        registry.addViewController("/bookReader").setViewName("bookReader");
        registry.addViewController("/bookStat").setViewName("bookStat");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(sessionTimeoutInterceptor).addPathPatterns("/**").
               excludePathPatterns("/api/book/list","/bookDetail/*","/","/index","/login","/static/**","/logout");
    }
}
