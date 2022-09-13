package com.ljh.xml.instantiate;

import org.springframework.beans.factory.FactoryBean;

/**
 * Bean3FactoryBean
 *
 * @author ljh
 * created on 2022/9/13 10:00
 */
public class Bean3FactoryBean implements FactoryBean<Bean3> {
    @Override
    public Bean3 getObject() throws Exception {
        return new Bean3();
    }

    @Override
    public Class<?> getObjectType() {
        return Bean3.class;
    }
}
