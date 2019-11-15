package com.ljh.repositories;

import com.ljh.entity.Person;
import com.ljh.repositories.custom.dao.PersonDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * PersonRepository
 *
 * @author ljh
 * created on 2019/11/14 10:07
 */
// @RepositoryDefinition 可替代继承 Repository 接口
// @RepositoryDefinition(domainClass = Person.class, idClass = Integer.class)
public interface PersonRepository extends
        JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>, PersonDao {

    // 根据 lastName 获取对应的 Person
    Person getByLastName(String lastName);

    // WHERE lastName LIKE ?% AND id < ?
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);

    // WHERE lastName LIKE %? AND id < ?
    List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);

    // WHERE email IN (?, ?, ?) AND birth < ?
    List<Person> getByEmailInAndBirthLessThan(List<String> emailList, Date birth);

    // WHERE a.id > ?
    List<Person> getByAddress_IdGreaterThan(Integer id);

    // 查询 id 值最大的 person
    @Query("SELECT p FROM Person p WHERE p.id = (SELECT max(p2.id) FROM Person p2)")
    Person getMaxIdPerson();

    // 传参：占位符
    @Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
    List<Person> testQueryAnnotationParams1(String lastName, String email);

    // 传参：命名参数
    @Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
    List<Person> testQueryAnnotationParams2(@Param("email") String email, @Param("lastName") String lastName);

    // 传参：like，SpringData 允许在 JPQL 语句上添加 %
    @Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email Like ?2")
    List<Person> testQueryAnnotationLikeParam(String lastName, String email);

    // nativeQuery = true，使用原生 SQL 查询
    @Query(value = "SELECT count(id) FROM jpa_persons", nativeQuery = true)
    long getTotalCount();

    // 可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作，注意：JPQL 不支持使用 INSERT
    // 在 @Query 注解中编写 JPQL 语句，且使用 @Modifying 进行修饰，以通知 SpringData，这是一个 UPDATE 或 DELETE 操作
    // UPDATE 和 DELETE 需要使用事务，此时需要定义 Service 层，在 Service 层的方法上添加事务操作
    // 默认情况下，SpringData 的每个方法上都有只读事务，他们不能完成 UPDATE 和 DELETE 操作
    @Modifying
    @Query("UPDATE Person p SET p.email = :email WHERE id = :id")
    void updatePersonEmail(@Param("email") String email, @Param("id") Integer id);
}
