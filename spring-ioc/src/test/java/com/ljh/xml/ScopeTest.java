package com.ljh.xml;

import com.ljh.xml.scope.Bean1;
import com.ljh.xml.scope.custom.MyScopeBean;
import com.ljh.xml.scope.custom.SimpleThreadScopeBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * scopeTest
 *
 * @author ljh
 * created on 2019/10/31 8:57
 */
public class ScopeTest {

    private ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring_scope.xml");
    }

    @Test
    public void test() {
        Bean1 bean1_1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1_1 = " + bean1_1);;
        Bean1 bean1_2 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1_2 = " + bean1_2);
        System.out.println("(bean1_1 == bean1_2) = " + (bean1_1 == bean1_2));
        bean1_1.printBean2();
        bean1_1.printBean2();
    }

    @Test
    public void testMyScope() {
        for (int i = 0; i < 10; i++) {
            MyScopeBean bean = context.getBean("myScopeBean", MyScopeBean.class);
            System.out.println("bean = " + bean);
        }
    }

    @Test
    public void testSimpleThreadScope() {
        for (int i = 0; i < 10; i++) {
            SimpleThreadScopeBean bean = context.getBean("simpleThreadScopeBean", SimpleThreadScopeBean.class);
            System.out.println("bean = " + bean);
        }
        System.out.println("=========================================================");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SimpleThreadScopeBean bean = context.getBean("simpleThreadScopeBean", SimpleThreadScopeBean.class);
                System.out.println("bean = " + bean);
            }).start();
        }
    }
}
