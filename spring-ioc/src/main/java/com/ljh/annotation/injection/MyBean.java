package com.ljh.annotation.injection;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * MyBean
 *
 * @author ljh
 * created on 2019/10/31 12:46
 */
@ToString
@Component
public class MyBean {

    private AnotherBean anotherBean1;
    private AnotherBean anotherBean2;
    // 属性注入
    @Autowired
    private AnotherBean anotherBean3;
    private List<String> stringList;
    private Map<String, Integer> integerMap;
    // 注入 String / Integer
    @Value("555")
    private String string;
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    // 注入 ApplicationContext / BeanFactory / Environment / ResourceLoader / ApplicationEventPublisher / MessageSource 及其实现类
    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public Map<String, Integer> getIntegerMap() {
        return integerMap;
    }

    // 注入 Map
    // @see com.ljh.annotation.injection.MyConfiguration
    @Autowired
    public void setIntegerMap(Map<String, Integer> integerMap) {
        this.integerMap = integerMap;
    }

    public List<String> getStringList() {
        return stringList;
    }

    // 注入 List
    // @see com.ljh.annotation.injection.MyConfiguration
    @Autowired
    @Qualifier("stringList")
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    // setter 方法注入
    @Autowired
    public void setAnotherBean2(AnotherBean anotherBean2) {
        this.anotherBean2 = anotherBean2;
    }

    // 构造方法注入
    @Autowired
    public MyBean(AnotherBean anotherBean1) {
        this.anotherBean1 = anotherBean1;
    }
}
