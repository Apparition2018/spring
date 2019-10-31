package com.ljh.xml.injection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Bean
 *
 * @author ljh
 * created on 2019/10/30 9:32
 */
@Getter
@Setter
@ToString
public class Bean {

    private AnotherBean anotherBean;
    private String string;

    private AnotherBean anotherBean2;
    private String string2;

    private List<String> stringList;
    private List<AnotherBean> anotherBeanList;

    private Set<String> stringSet;
    private Set<AnotherBean> anotherBeanSet;

    private Map<String, String> StringMap;
    private Map<AnotherBean, AnotherBean> anotherBeanMap;

    private Properties properties;

    private AnotherBean anotherBean3;

    public Bean(AnotherBean anotherBean, String string) {
        this.anotherBean = anotherBean;
        this.string = string;
    }

}
