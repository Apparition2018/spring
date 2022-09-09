package com.ljh.annotation;

import com.ljh.annotation.scope.MethodInjectionBean;
import com.ljh.annotation.scope.TestBean;
import com.ljh.annotation.scope.TestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 作用域
 *
 * @author ljh
 * created on 2019/10/31 14:09
 */
public class ScopeTest {

    private ApplicationContext context;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(TestConfiguration.class);
    }

    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            TestBean testBean1 = context.getBean("testBean1", TestBean.class);
            System.out.println("testBean1 = " + testBean1);
        }
        System.out.println("==================");
        for (int i = 0; i < 5; i++) {
            TestBean testBean2 = context.getBean("testBean2", TestBean.class);
            System.out.println("testBean2 = " + testBean2);
        }

    }

    @Test
    public void testMethodInjection() {
        MethodInjectionBean testBean3 = context.getBean("testBean3", MethodInjectionBean.class);
        for (int i = 0; i < 5; i++) {
            testBean3.printAnotherBean();
        }
    }
}
