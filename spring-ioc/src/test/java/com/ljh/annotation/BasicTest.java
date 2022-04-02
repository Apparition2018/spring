package com.ljh.annotation;

import com.ljh.annotation.basic.Bean;
import com.ljh.annotation.basic.MyConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BasicTest
 *
 * @author ljh
 * created on 2019/10/31 11:41
 */
public class BasicTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Bean bean = context.getBean("customBean", Bean.class);
        System.out.println("bean = " + bean);
    }
}
