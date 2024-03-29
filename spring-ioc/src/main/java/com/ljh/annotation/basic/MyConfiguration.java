package com.ljh.annotation.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyConfiguration
 *
 * @author ljh
 * created on 2019/10/31 11:41
 */
// 创建一个 class 配置文件
@Configuration
@ComponentScan(value = "com.ljh.annotation.basic")
public class MyConfiguration {

    // 将一个 Bean 交由 Spring 创建并管理
    @org.springframework.context.annotation.Bean(value = {"myBean", "customBean"})
    public Bean bean() {
        return new Bean();
    }
}
