package com.ljh.xml;

import com.ljh.xml.init.destroy.Bean;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * InitDestroyTest
 *
 * @author ljh
 * created on 2019/10/31 11:06
 */
public class InitDestroyTest {
    
    @Test
    public void test() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring_init_destroy.xml");
        Bean bean = context.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);
        context.close();
    }
}
