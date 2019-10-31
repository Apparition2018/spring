package com.ljh.annotation.scope;

import com.ljh.annotation.scope.custom.MyScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * TestConfiguration
 *
 * @author ljh
 * created on 2019/10/31 14:07
 */
@Configuration
@ComponentScan("com.ljh.annotation.scope")
public class TestConfiguration {

    @Bean("testBean1")
    @Scope("myScope")
    public TestBean testBean() {
        return new TestBean();
    }

    /* 自定义作用域 */
    @Bean
    public MyScope myScope() {
        return new MyScope();
    }
    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("myScope", myScope());
        return configurer;
    }
}
