package com.example.demo.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.dubbo.service.DemoService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * demo 服务实现
 *
 * @author wangzhuang
 * @date 2020/05/13
 */
@Service(group = "demo", version = "0.0.1")
@Component
public class DemoServiceImpl implements DemoService {

    @Override
    public String saySomething(String name) {
        Assert.notNull(name, "参数不能为空");
        return "你好," + name;
    }

}
