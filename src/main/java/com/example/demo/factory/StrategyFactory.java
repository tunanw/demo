package com.example.demo.factory;

import com.example.demo.strategy.IStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 策略工厂
 *
 * @author wangzhuang
 * @date 2020/03/05
 */
@Component
public class StrategyFactory {

    @Resource
    private Map<String, IStrategy> strategyMap;

    public IStrategy getStrategy(String name) {
        return strategyMap.get(name);
    }

}
