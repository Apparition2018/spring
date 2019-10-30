package com.ljh.my.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * IoCContainer
 *
 * 约定：
 * 1.所有 Bean 生命周期交由 IoC 容器管理
 * 2.所有依赖的 Bean 通过构造方法执行注入
 * 3.被依赖的 Bean 需要优先创建
 *
 * 1.实例化 Bean
 * 2.保存 Bean
 * 3.提供 Bean
 * 4.每一个 Bean 要产生一个唯一的 id 与之相对应
 *
 * @author ljh
 * created on 2019/10/29 15:30
 */
public class IoCContainer {

    private Map<String, Object> beans = new ConcurrentHashMap<>();

    /**
     * 根据 beanId 获取一个 Bean
     * @param beanId beanId
     * @return 返回 Bean
     */
    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托 IoC 容器创建一个 Bean
     * @param clazz 要创建的 Bean 的 Class
     * @param beanId beanId
     * @param paramBeanIds 要创建的 Bean 的 Class 的构造方法所需要的参数的 beanId 们
     */
    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
        // 1. 组装构造方法所需要的参数值
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }
        // 2. 调用构造方法实例化 Bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        if (bean == null) {
            throw new RuntimeException("找不到合适的构造方法实例化 Bean");
        }
        // 3. 将实例化的 Bean 放入 beans
        beans.put(beanId, bean);
    }

}
