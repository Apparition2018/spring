package com.ljh.xml.scope.custom;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MyScope
 * 自定义作用域
 *
 * 本例为双例模式
 *
 * @author ljh
 * created on 2019/10/31 10:17
 */
public class MyScope implements Scope {

    private Map<String, Object> map1 = new ConcurrentHashMap<>();
    private Map<String, Object> map2 = new ConcurrentHashMap<>();


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!map1.containsKey(name)) {
            Object o = objectFactory.getObject();
            map1.put(name, o);
            return o;
        }
        if (!map2.containsKey(name)) {
            Object o = objectFactory.getObject();
            map2.put(name, o);
            return o;
        }
        int i = new Random().nextInt(2);
        return i == 0 ? map1.get(name) : map2.get(name);
    }

    @Override
    public Object remove(String name) {
        if (map2.containsKey(name)) {
            Object o = map2.get(name);
            map2.remove(name);
            return o;
        }
        if (map1.containsKey(name)) {
            Object o = map2.get(name);
            map2.remove(name);
            return o;
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
