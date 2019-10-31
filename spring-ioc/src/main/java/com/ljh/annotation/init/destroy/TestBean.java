package com.ljh.annotation.init.destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * TestBean
 * Bean 初始化之前执行代码和 销毁之后执行代码
 * 1. 实现 InitializingBean, DisposableBean
 * 2. @PostConstruct, @PreDestroy
 * 3. @Configuration 文件中 @Bean(initMethod = "xxx", destroyMethod = "xxx")
 *
 * @author ljh
 * created on 2019/10/31 14:41
 */
@Component
public class TestBean implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("TestBean.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestBean.afterPropertiesSet");
    }

    @PostConstruct
    public void onInit() {
        System.out.println("TestBean.onInit");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("TestBean.onDestroy");
    }

    public void onInit2() {
        System.out.println("TestBean.onInit2");
    }

    public void onDestroy2() {
        System.out.println("TestBean.onDestroy2");
    }

}
