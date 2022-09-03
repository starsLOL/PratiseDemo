package com.stars.pratise.demo.controller;

import com.stars.pratise.demo.common.ResponseData;
import com.stars.pratise.demo.log.annotation.OperLog;
import com.stars.pratise.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping()
    @OperLog(operateModul = "user manage", operateType = "select", operatesDesc = "this is a user controller on user")
    public <T> ResponseData getAllUser() {
        return this.userService.findAllUser();
    }
}
