package com.ljh.xml;

import com.ljh.xml.instantiate.Bean1;
import com.ljh.xml.instantiate.Bean21;
import com.ljh.xml.instantiate.Bean22;
import com.ljh.xml.instantiate.Bean3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 实例化 Bean
 *
 * @author ljh
 * created on 2019/10/30 9:08
 */
public class InstantiateTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_instantiate.xml");

        // 1 无参构造方法
        Bean1 bean1 = context.getBean("bean1", Bean1.class);
        System.out.println("bean1 = " + bean1);

        // 别名
        Bean1 bean1_1 = context.getBean("bean1_1", Bean1.class);
        Bean1 bean1_2 = context.getBean("bean1_2", Bean1.class);
        Bean1 bean1_3 = context.getBean("bean1_3", Bean1.class);
        System.out.println("bean1_1 = " + bean1_1);
        System.out.println("bean1_2 = " + bean1_2);
        System.out.println("bean1_3 = " + bean1_3);

        // 2 工厂方法
        // 2.1 静态工厂方法
        Bean21 bean21 = context.getBean("bean21", Bean21.class);
        System.out.println("bean21 = " + bean21);
        // 2.2 实例工厂方法
        Bean22 bean22 = context.getBean("bean22", Bean22.class);
        System.out.println("bean22 = " + bean22);

        // 3 FactoryBean
        Bean3 bean3 = context.getBean("bean3", Bean3.class);
        System.out.println("bean3 = " + bean3);
    }
}
