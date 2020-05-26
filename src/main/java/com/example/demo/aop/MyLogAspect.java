package com.example.demo.aop;

import com.example.demo.annotation.MyLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志增强注解aop
 *
 * @author wangzhuang
 * @date 2020/05/26
 */
@Component
@Aspect
public class MyLogAspect {

    @Pointcut(value = "@annotation(myLog)")
    public void callAt(MyLog myLog) {
    }

    @Around(value = "callAt(type)", argNames = "pjp,type")
    public Object around(ProceedingJoinPoint pjp, MyLog type) throws Throwable {
        System.out.println("aop 方法开始日志:" + type.value());
        Object obj = pjp.proceed();
        System.out.println("aop 方法结束日志:" + type.value());
        return obj;
    }
}
