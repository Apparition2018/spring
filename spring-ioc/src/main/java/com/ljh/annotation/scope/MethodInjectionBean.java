package com.ljh.annotation.scope;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * MethodInjectionBean
 * 方法注入
 *
 * @author ljh
 * created on 2019/10/31 14:20
 */
@Component("testBean3")
@Scope("singleton")
public abstract class MethodInjectionBean {

    @Lookup
    public abstract AnotherBean anotherBean();

    public void printAnotherBean() {
        System.out.println("anotherBean() = " + anotherBean());
    }
}
