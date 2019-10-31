package com.ljh.annotation.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * TestBean
 *
 * @author ljh
 * created on 2019/10/31 14:32
 */
@Component("testBean1")
@Lazy
public class TestBean {

    public TestBean() {
        System.out.println("TestBean init");
    }
}
