package com.stars.pratise.demo.system.controller;

import com.stars.pratise.demo.base.Result;
import com.stars.pratise.demo.constants.BaseEnums;
import com.stars.pratise.demo.system.dto.SysUser;
import com.stars.pratise.demo.system.service.SysUserService;
import com.stars.pratise.demo.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 用户Controller
 *
 * @author stars
 * @version 1.0
 */
@RequestMapping
@RestController
public class SysUserController {

    @Resource
    private SysUserService sysUserService;


    @PostMapping("/sys/user/queryAll")
    public Result queryAll() {
        List<SysUser> list = sysUserService.selectAll();
        return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @RequestMapping("/sys/user/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId) {
        SysUser user = sysUserService.get(userId);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/save")
    public Result save(@Valid @RequestBody SysUser user) {
        user = sysUserService.insertSelective(user);
        return Results.successWithData(user);
    }

    @PostMapping("/sys/user/update")
    public Result update(@Valid @RequestBody List<SysUser> user) {
        user = sysUserService.persistSelective(user);
        return Results.successWithData(user);
    }

    @RequestMapping("/sys/user/delete")
    public Result delete(SysUser user) {
        sysUserService.delete(user);
        return Results.success();
    }

    @RequestMapping("/sys/user/delete/{userId}")
    public Result delete(@PathVariable Long userId) {
        sysUserService.delete(userId);
        return Results.success();
    }

}
