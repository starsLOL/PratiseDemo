package com.stars.pratise.demo.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.stars.pratise.demo.config.ConfigDemoBean;
import com.stars.pratise.demo.config.ConfigTestBean;
import com.stars.pratise.demo.domain.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private ConfigTestBean configTestBean;

    @Autowired
    private ConfigDemoBean configDemoBean;

    @GetMapping("/wrong")
    public int error(){
        int i = 9/0;
        return i;
    }


    /**
     * 测试方法
     *
     * @param who 测试参数
     * @return {@link Dict}
     */
    @GetMapping("/test")
    public Dict test(String who) {
        return Dict.create().set("who", StrUtil.isBlank(who) ? "stars" : who);
    }

    @RequestMapping("/checkMessages")
    public String checkMessages(){
        return configDemoBean.getName() + " -configDemoBean- " +configDemoBean.getAge();
    }

    @RequestMapping("/findMessages")
    public String findMessages(){
        return configTestBean.getName() + " -configTestBean- " +configTestBean.getTitle();
    }

    @RequestMapping("/selectMessages")
    public String selectMessages(){
        return blogProperties.getName() + " -blogProperties- " +blogProperties.getTitle();
    }

    @RequestMapping("/hello")
    public String hello(String name){
        return "hello dogs is you " + name;
    }
}