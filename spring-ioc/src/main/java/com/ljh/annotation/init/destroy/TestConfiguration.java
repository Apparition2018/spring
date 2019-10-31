package com.ljh.annotation.init.destroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * TestConfiguration
 *
 * @author ljh
 * created on 2019/10/31 14:41
 */
@Configuration
@ComponentScan("com.ljh.annotation.init.destroy")
public class TestConfiguration {

    @Bean(initMethod = "onInit2", destroyMethod = "onDestroy2")
    public TestBean testBean() {
        return new TestBean();
    }
}
