package com.ljh.xml.injection;

/**
 * AnotherBean
 *
 * @author ljh
 * created on 2019/10/30 9:32
 */
public class AnotherBean {

    private Integer num;

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "AnotherBean{" +
                "num=" + num +
                '}';
    }
}
