package com.ljh.xml;

import com.ljh.xml.injection.Bean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注入 Bean
 *
 * @author ljh
 * created on 2019/10/30 9:39
 */
public class InjectionTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_injection.xml");
        Bean bean = context.getBean("bean", Bean.class);

        System.out.println("bean.getAnotherBean() = " + bean.getAnotherBean());
        System.out.println("bean.getString() = " + bean.getString());
        System.out.println("bean.getAnotherBean2() = " + bean.getAnotherBean2());
        System.out.println("bean.getString2() = " + bean.getString2());
        System.out.println("------------------------------------");
        System.out.println("bean.getStringList() = " + bean.getStringList());
        System.out.println("bean.getStringSet() = " + bean.getStringSet());
        System.out.println("bean.getStringMap() = " + bean.getStringMap());
        System.out.println("bean.getAnotherBeanList() = " + bean.getAnotherBeanList());
        System.out.println("bean.getAnotherBeanSet() = " + bean.getAnotherBeanSet());
        System.out.println("bean.getAnotherBeanMap() = " + bean.getAnotherBeanMap());
        System.out.println("bean.getProperties() = " + bean.getProperties());
        System.out.println("bean.getAnotherBean3() = " + bean.getAnotherBean3());
    }
}
