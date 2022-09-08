package com.stars.pratise.demo.mapper;

import com.stars.pratise.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    List<User> findAllUser();
}
