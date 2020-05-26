package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 日志增强
 *
 * @author wangzhuang
 * @date 2020/05/26
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyLog {
    String value() default "";
}
