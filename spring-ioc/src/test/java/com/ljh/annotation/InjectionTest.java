package com.ljh.annotation;

import com.ljh.annotation.injection.AnotherBean;
import com.ljh.annotation.injection.MyBean;
import com.ljh.annotation.injection.MyConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 注入 Bean
 *
 * @author ljh
 * created on 2019/10/31 12:48
 */
public class InjectionTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
        for (String s : myBean.getStringList()) {
            System.out.println("s = " + s);
        }
        for (Map.Entry<String, Integer> entry : myBean.getIntegerMap().entrySet()) {
            System.out.println("entry = " + entry);
        }
        AnotherBean anotherBean = myBean.getContext().getBean("anotherBean", AnotherBean.class);
        System.out.println("anotherBean = " + anotherBean);
    }
}
