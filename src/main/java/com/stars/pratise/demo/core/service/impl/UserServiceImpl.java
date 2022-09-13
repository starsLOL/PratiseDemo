package com.stars.pratise.demo.core.service.impl;

import com.stars.pratise.demo.common.restResult.ResponseData;
import com.stars.pratise.demo.core.service.UserService;
import com.stars.pratise.demo.entity.User;
import com.stars.pratise.demo.core.mapper.UserMapper;
import com.stars.pratise.demo.util.ResponseDataUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public <T> ResponseData findAllUser() {

        List<User> list = userMapper.findAllUser();
        if (list == null) {
            return ResponseDataUtil.failure();
        } else {
            return ResponseDataUtil.success(list);
        }
    }

}