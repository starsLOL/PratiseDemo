package com.stars.pratise.demo;

import com.stars.pratise.demo.config.ConfigDemoBean;
import com.stars.pratise.demo.config.ConfigTestBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ConfigTestBean.class, ConfigDemoBean.class})
//要让Spring Boot扫描到Mapper接口，需要在Spring Boot入口类中加入@MapperScan("com.stars.pratise.demo.mapper")注解。
//@MapperScan("com.stars.pratise.demo.mapper")
public class PratiseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PratiseDemoApplication.class, args);
    }

}
