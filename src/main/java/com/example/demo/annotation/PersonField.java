package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 字段
 *
 * @author wangzhuang
 * @date 2020/03/05
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface PersonField {

    String name();

}
