package com.ljh.xml;

import com.ljh.xml.attr.inherit.Son1;
import com.ljh.xml.attr.inherit.Son2;
import com.ljh.xml.attr.inherit.Son3;
import com.ljh.xml.attr.inherit.Son4;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AttrInheritTest
 * 属性继承
 *
 * @author ljh
 * created on 2019/10/31 11:23
 */
public class AttrInheritTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_attr_inherit.xml");
        Son1 son1 = context.getBean("son1", Son1.class);
        System.out.println("son1 = " + son1);
        Son2 son2 = context.getBean("son2", Son2.class);
        System.out.println("son2 = " + son2);

        Son3 son3 = context.getBean("son3", Son3.class);
        System.out.println("son3 = " + son3);
        Son4 son4 = context.getBean("son4", Son4.class);
        System.out.println("son4 = " + son4);
    }
}
