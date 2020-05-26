package com.example.demo.service;

import com.example.demo.annotation.MyLog;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * hello 服务
 *
 * @author wangzhuang
 * @date 2020/05/26
 */
@Service
public class HelloService {

    public String saySomething(String name) {
        Assert.notNull(name, "name 不能为空");
        return saySomething2(name);
    }

    @MyLog("saySomething")
    public String saySomething2(String name) {
        Assert.notNull(name, "name 不能为空");
        return "saySomething" + name;
    }
}
