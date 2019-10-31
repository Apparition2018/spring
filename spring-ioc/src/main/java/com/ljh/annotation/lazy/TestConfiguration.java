package com.ljh.annotation.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * TestConfiguration
 *
 * @author ljh
 * created on 2019/10/31 14:32
 */
@Configuration
@ComponentScan("com.ljh.annotation.lazy")
// 全局懒加载
@Lazy
public class TestConfiguration {

    @Bean("testBean2")
    // @Lazy
    public TestBean testBean() {
        return new TestBean();
    }
}
