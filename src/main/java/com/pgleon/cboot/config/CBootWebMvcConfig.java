package com.pgleon.cboot.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.pgleon.cboot.api.CustomHttpMessageConverter;
import com.pgleon.cboot.auth.UserIdentityHandlerMethodArgumentResolver;
import com.pgleon.cboot.auth.SignInterceptor;
import com.pgleon.cboot.auth.UserIdentityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Auther: leon
 * @Date: 2019-06-26 17:27
 * <p>
 * 在Spring Boot 1.5版本都是靠重写WebMvcConfigurerAdapter的方法来添加自定义拦截器，消息转换器等。
 * SpringBoot 2.0 后，该类被标记为@Deprecated。因此我们靠实现WebMvcConfigurer接口来实现。
 */

@Import({
        UserIdentityConfig.class})
@Configuration
public class CBootWebMvcConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor signInterceptor() {
        return new SignInterceptor();
    }

    @Bean
    public HandlerInterceptor userIdentityInterceptor() {
        return new UserIdentityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor());
        registry.addInterceptor(userIdentityInterceptor());

    }

    @Bean
    public CustomHttpMessageConverter getCustomHttpMessageConverter() {
        CustomHttpMessageConverter converter = new CustomHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(getCustomHttpMessageConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserIdentityHandlerMethodArgumentResolver());
    }


}
