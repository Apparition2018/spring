package com.ljh;

import com.ljh.entity.Person;
import com.ljh.repositories.PersonRepository;
import com.ljh.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * SpringDataTest
 *
 * @author ljh
 * created on 2019/11/13 14:04
 */
public class SpringDataTest {

    private final ApplicationContext ctx;
    private final PersonRepository personRepository;
    private final PersonService personService;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        personRepository = ctx.getBean(PersonRepository.class);
        personService = ctx.getBean(PersonService.class);
    }

    /**
     * 测试数据源
     */
    @Test
    public void testDataSource() {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource);
    }

    /**
     * 测试 EntityManagerFactory
     */
    @Test
    public void testJPA() {
        // 执行测试，查看数据库是否生成表
    }

    @Test
    public void testHelloWordSpringData() {
        System.out.println("Proxy: " + personRepository.getClass().getName());

        Person person = personRepository.getByLastName("AA");
        System.out.println("person = " + person);
    }

    /**
     * 测试关键字
     */
    @Test
    public void testKeyWord() {
        List<Person> personList = personRepository.getByLastNameStartingWithAndIdLessThan("X", 10);
        System.out.println("personList = " + personList);

        personList = personRepository.getByLastNameEndingWithAndIdLessThan("X", 10);
        System.out.println("personList = " + personList);

        personList = personRepository.getByEmailInAndBirthLessThan(Arrays.asList("AA@ljh.com", "FF@ljh.com", "SS@ljh.com"), new Date());
        System.out.println("personList = " + personList);
    }

    /**
     * 测试级联查询
     */
    @Test
    public void testKeyWord2() {
        List<Person> personList = personRepository.getByAddress_IdGreaterThan(1);
        System.out.println("personList = " + personList);
    }

    /**
     * 测试 @Query
     */
    @Test
    public void testQueryAnnotation() {
        // 无参
        Person person = personRepository.getMaxIdPerson();
        System.out.println("person = " + person);

        // 传参：占位符
        List<Person> personList = personRepository.testQueryAnnotationParams1("AA", "aa@ljh.com");
        System.out.println("personList = " + personList);

        // 传参：命名参数
        personList = personRepository.testQueryAnnotationParams2("aa@ljh.com", "AA");
        System.out.println("personList = " + personList);

        // 传参：like，SpringData 允许在 JPQL 语句上添加 %
        personList = personRepository.testQueryAnnotationLikeParam("A", "%bb%");
        System.out.println("personList = " + personList);

        // 原生 SQL
        long count = personRepository.getTotalCount();
        System.out.println("count = " + count);
    }

    /**
     * 测试 @Modifying
     */
    @Test
    public void testModifying() {
        personService.updatePersonEmail("mmmm@ljh.com", 1);
    }

    /**
     * 测试 CurdRepository
     */
    @Test
    public void testCurdRepository() {
        List<Person> personList = new ArrayList<>();

        for (int i = 'a'; i <= 'z'; i++) {
            Person person = new Person();
            person.setAddressId(i + 1);
            person.setBirth(new Date());
            person.setEmail((char) i + "" + (char) i + "@ljh.com");
            person.setLastName((char) i + "" + (char) i);

            personList.add(person);
        }

        personService.savePerson(personList);
    }

    /**
     * 测试 PagingAndSortingRepository
     */
    @Test
    public void testPagingAndSortingRepository() {
        // pageNo 从 0 开始
        int pageNo = 3 - 1, pageSize = 5;
        // 排序
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "Id");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "email");
        Sort sort = Sort.by(order1, order2);
        // Pageable 接口通常使用其实现类 PageRequest，其中封装了需要分页的信息
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Person> page = personRepository.findAll(pageable);
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的 List：" + page.getContent());
        System.out.println("当前页面的 记录数：" + page.getNumberOfElements());
    }

    /**
     * 测试 JpaRepository
     */
    @Test
    public void testJpaRepository() {
        Person person = new Person();
        person.setBirth(new Date());
        person.setEmail("XYZ@ljh.com");
//        person.setEmail("xyz@ljh.com");
        person.setLastName("xyz");
//        person.setId(27);

        // saveAndFlush 不传 id 则创建，否则为更新
        Person person2 = personRepository.saveAndFlush(person);
        System.out.println(person == person2);
    }

    /**
     * 测试 JpsSpecificationExecutor
     * <p>
     * 实现带查询条件的分页
     * 调用 JpsSpecificationExecutor 的 Page<T> findAll(Specification<T> spec, Pageable pageable);
     * Specification: 封装了 JPA Criteria 查询的查询条件
     * Pageable: 封装了请求分页的信息：pageNo, pgeSize, Sort
     */
    @Test
    public void testJpsSpecificationExecutor() {
        int pageNo = 3 - 1, pageSize = 5;
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // 通常使用 Specification 的匿名内部类
        Specification<Person> specification = new Specification<Person>() {

            /**
             * @param root  代表查询的实体类
             * @param query 1.可以从中得到 Root 对象，即告知 JPA Criteria 查询要查询哪一个实体类
             *              2.可以用来添加查询条件
             *              3.结合 EntityManager 对象得到最终查询的 TypedQuery 对象
             * @param criteriaBuilder   用于创建 Criteria 相关对象的工厂
             * @return Predicate 代表一个查询条件
             */
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get("id"), 5);
            }
        };

        Page<Person> page = personRepository.findAll(specification, pageable);
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的 List：" + page.getContent());
        System.out.println("当前页面的 记录数：" + page.getNumberOfElements());
    }

    /**
     * 测试 为一个 Repository 添加自定义方法
     */
    @Test
    public void testCustomRepositoryMethod() {
        personRepository.custom();
    }
}
