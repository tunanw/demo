package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * 策略1
 *
 * @author wangzhuang
 * @date 2020/03/05
 */
@Component("one")
public class StrategyOne implements IStrategy {

    @Override
    public void work() {
        System.out.println("我是策略1");
    }
}
