package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * 策略2
 *
 * @author wangzhuang
 * @date 2020/03/05
 */
@Component("two")
public class StrategyTwo implements IStrategy {

    @Override
    public void work() {
        System.out.println("我是策略2");
    }
}
