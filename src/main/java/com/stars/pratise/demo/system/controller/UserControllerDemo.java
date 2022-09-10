package com.stars.pratise.demo.system.controller;

import com.stars.pratise.demo.base.Result;
import com.stars.pratise.demo.constants.BaseEnums;
import com.stars.pratise.demo.constants.Constants;
import com.stars.pratise.demo.system.dto.UserDemo;
import com.stars.pratise.demo.util.Results;
import com.stars.pratise.demo.util.time.Dates;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 *
 * @author stars
 * @version 1.0
 */
//@RequestMapping("/sys/user")
//@RestController
//public class UserController extends BaseController {
public class UserControllerDemo {

//    private static List<UserDemo> userList = new ArrayList<UserDemo>();
//
//    // 先静态模拟数据
//    static {
//        UserDemo user1 = new UserDemo();
//        user1.setUserId(1L);
//        user1.setUsername("lufei");
//        user1.setNickname("蒙奇D路飞");
//        user1.setBirthday(Dates.parseDate("2000-05-05"));
//        user1.setSex(Constants.Sex.MALE);
//        user1.setEnabled(Constants.Flag.YES);
//        userList.add(user1);
//
//        UserDemo user2 = new UserDemo();
//        user2.setUserId(2L);
//        user2.setUsername("namis");
//        user2.setNickname("娜美");
//        user2.setBirthday(Dates.parseDate("2000/7/3"));
//        user2.setSex(Constants.Sex.FEMALE);
//        user2.setEnabled(Constants.Flag.YES);
//        userList.add(user2);
//    }
//
//    @RequestMapping("/queryAll")
//    public Result queryAll() {
//        return Results.successWithData(userList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
//    }
//
//    @RequestMapping("/queryOne/{userId}")
//    public Result queryOne(@PathVariable Long userId) {
//        UserDemo userDemo = null;
//        for (UserDemo u : userList) {
//            if (u.getUserId().longValue() == userId) {
//                userDemo = u;
//            }
//        }
//        return Results.successWithData(userDemo);
//    }
}
