package com.ljh.annotation;

import com.ljh.annotation.init.destroy.TestBean;
import com.ljh.annotation.init.destroy.TestConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * InitDestroyTest
 *
 * @author ljh
 * created on 2019/10/31 14:41
 */
public class InitDestroyTest {

    @Test
    public void test() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println("testBean = " + testBean);
        context.close();
    }
}
