package com.pgleon.cboot.config;

import com.pgleon.cboot.interceptor.SignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: leon
 * @Date: 2019-06-26 17:27
 *
 * 在Spring Boot 1.5版本都是靠重写WebMvcConfigurerAdapter的方法来添加自定义拦截器，消息转换器等。
 * SpringBoot 2.0 后，该类被标记为@Deprecated。因此我们靠实现WebMvcConfigurer接口来实现。
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor signInterceptor() {
        return new SignInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor());
    }
}
