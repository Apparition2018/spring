package com.ljh.xml;

import com.ljh.xml.instantiate.Bean1;
import com.ljh.xml.instantiate.Bean2;
import com.ljh.xml.instantiate.Bean3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * InstantiateBean
 * 实例化 Bean
 *
 * @author ljh
 * created on 2019/10/30 9:08
 */
public class InstantiateTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_instantiate.xml");
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1 = " + bean1);
        
        Bean2 bean2 = context.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);

        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        System.out.println("bean3 = " + bean3);

        Bean1 bean1_1 = context.getBean("bean1_1", Bean1.class);
        Bean1 bean1_2 = context.getBean("bean1_2", Bean1.class);
        Bean1 bean1_3 = context.getBean("bean1_3", Bean1.class);
        System.out.println("bean1_1 = " + bean1_1);
        System.out.println("bean1_2 = " + bean1_2);
        System.out.println("bean1_3 = " + bean1_3);
    }
}
