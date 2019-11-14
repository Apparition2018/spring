package com.ljh;

import com.ljh.repositories.PersonRepository;
import com.ljh.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * SpringDataTest
 *
 * @author ljh
 * created on 2019/11/13 14:04
 */
public class SpringDataTest {

    private ApplicationContext ctx;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testDataSource() {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource);
    }

    @Test
    public void testJPA() {
        // 执行测试，查看数据库是否生成表
    }

    @Test
    public void testHelloWordSpringData() {
        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        System.out.println("Proxy: " + personRepository.getClass().getName());

        Person person = personRepository.getByLastName("AA");
        System.out.println("person = " + person);
    }

    @Test
    public void test() {

    }

}
