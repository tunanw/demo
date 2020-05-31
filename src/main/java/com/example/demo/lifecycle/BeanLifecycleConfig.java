package com.example.demo.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean生命周期配置类
 *
 * @author wangzhuang
 * @date 2020/05/31
 */
@Configuration
public class BeanLifecycleConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle();
    }
}
