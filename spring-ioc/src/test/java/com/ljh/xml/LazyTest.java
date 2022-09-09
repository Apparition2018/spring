package com.ljh.xml;

import com.ljh.xml.lazy.Bean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LazyTest
 *
 * @author ljh
 * created on 2019/10/31 10:45
 */
public class LazyTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_lazy.xml");
        System.out.println("context 已经被创建");
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);
    }
}
