package com.example.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.dubbo.service.DemoService;
import org.springframework.web.bind.annotation.*;

/**
 * 测试
 *
 * @author wangzhuang
 * @date 2020/04/17
 */
@RequestMapping("demo")
@RestController
public class DemoController {

    @Reference(group = "demo", version = "0.0.1")
    private DemoService demoService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String test() {
        System.out.println();
        return "success";
    }

    @RequestMapping(value = "saySomething", method = RequestMethod.GET)
    @ResponseBody
    public String saySomething() {
        return demoService.saySomething("张三");
    }

}
