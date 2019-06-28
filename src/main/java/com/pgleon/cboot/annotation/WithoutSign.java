package com.pgleon.cboot.annotation;

import java.lang.annotation.*;

/**
 * @Auther: leon
 * @Date: 2019-06-26 16:43
 * @Description: 无需签名自定义注解
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WithoutSign {
}
