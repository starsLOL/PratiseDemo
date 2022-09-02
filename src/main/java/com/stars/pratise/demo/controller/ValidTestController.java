package com.stars.pratise.demo.controller;

import com.stars.pratise.demo.entity.TestEntityVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

/**
 * @author: Linwei
 * @date 2021/8/12
 * @Description:
 */

@Slf4j
@Validated
@RequestMapping("/valid")
@RestController
public class ValidTestController {
    @PostMapping("/test1")
    public String test1(@Validated @RequestBody TestEntityVO validVO){
        log.info("validEntity is {}", validVO);
        return "test1 valid success";
    }

    @PostMapping(value = "/test2")
    public String test2(@Validated TestEntityVO validVO){
        log.info("validEntity is {}", validVO);
        return "test2 valid success";
    }

    @PostMapping(value = "/test3")
    public String test3(@Validated @RequestParam("email") @Email String email){
        System.out.println("email is---(" + email + ")---");
        log.info("email is {}", email);
        return "email valid success";
    }
}
