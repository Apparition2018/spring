package com.ljh.annotation;

import com.ljh.annotation.lazy.TestBean;
import com.ljh.annotation.lazy.TestConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * LazyTest
 *
 * @author ljh
 * created on 2019/10/31 14:35
 */
public class LazyTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        System.out.println("context init");
        TestBean testBean1 = context.getBean("testBean1", TestBean.class);
        System.out.println("testBean1 = " + testBean1);
        TestBean testBean2 = context.getBean("testBean2", TestBean.class);
        System.out.println("testBean2 = " + testBean2);
    }
}
