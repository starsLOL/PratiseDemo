package com.stars.pratise.demo.config.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * MyBatis相关配置.
 *
 * @author stars
 * @version 1.0
 * @desc 注意这里的 MapperScannerConfigurer 是tk.mybatis.spring.mapper.MapperScannerConfigurer，
 * 而不是org.mybatis，否则使用通用Mapper的方法时会报类似下面的这种错误
 */

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class MyBatisConfig {

    /**
     * Mapper扫描配置. 自动扫描将Mapper接口生成代理注入到Spring.
     */
    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 注意这里的扫描路径: 1.不要扫描到自定义的Mapper; 2.定义的路径不要扫描到tk.mybatis.mapper(如定义**.mapper).
        // 两个做法都会导致扫描到tk.mybatis的Mapper，就会产生重复定义的报错.
        mapperScannerConfigurer.setBasePackage("**.stars.**.mapper");
        return mapperScannerConfigurer;
    }

}