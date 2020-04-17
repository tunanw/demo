package com.example.demo.controller;

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

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String test() {
        System.out.println();
        return "success";
    }

}
