package com.ljh.annotation;

import com.ljh.annotation.configuration.Bean1;
import com.ljh.annotation.configuration.MyConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ConfigurationTest
 *
 * @author ljh
 * created on 2019/10/31 11:41
 */
public class ConfigurationTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Bean1 bean1 = context.getBean("customBean", Bean1.class);
        System.out.println("bean1 = " + bean1);
    }
}
