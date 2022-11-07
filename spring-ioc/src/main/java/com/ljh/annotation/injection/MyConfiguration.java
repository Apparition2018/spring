package com.ljh.annotation.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyConfiguration
 *
 * @author ljh
 * created on 2019/10/31 12:47
 */
@Configuration
@ComponentScan("com.ljh.annotation.injection")
public class MyConfiguration {

    /**
     * 注入 list
     * 优先级较低，除非指定 Bean 的 Id
     */
    @Bean("stringList")
    public List<String> stringList() {
        return Arrays.asList("111", "222");
    }

    /**
     * 注入 list
     * 优先级较高
     */
    @Bean
    @Order(56)
    public String string1() {
        return "333";
    }

    @Bean
    @Order(28)
    public String string2() {
        return "444";
    }

    /**
     * 注入 map
     * 优先级较低
     */
    @Bean
    public Map<String, Integer> integerMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        return map;
    }

    /**
     * 注入 map
     * 优先级较高
     */
    @Bean("int1")
    public Integer integer1() {
        return 333;
    }

    @Bean("int2")
    public Integer integer2() {
        return 444;
    }
}
