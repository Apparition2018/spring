package com.ljh.xml.scope;

/**
 * Bean1
 *
 * @author ljh
 * created on 2019/10/31 8:55
 */
public abstract class Bean1 {

    protected abstract Bean2 createBean2();

    public void printBean2() {
        System.out.println("bean2 = " + createBean2());
    }
}
