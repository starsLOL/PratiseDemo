package com.stars.pratise.demo;

import com.stars.pratise.demo.config.ConfigDemoBean;
import com.stars.pratise.demo.config.ConfigTestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ConfigTestBean.class,ConfigDemoBean.class})
public class PratiseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PratiseDemoApplication.class, args);
    }

}
