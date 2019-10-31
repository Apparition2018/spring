package com.ljh.xml.init.destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Bean
 *
 * @author ljh
 * created on 2019/10/31 11:04
 */
public class Bean implements InitializingBean, DisposableBean {

    public void onInit() {
        System.out.println("Bean.onInit");
    }

    public void onDestroy() {
        System.out.println("Bean.onDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean.afterPropertiesSet");
    }
}
