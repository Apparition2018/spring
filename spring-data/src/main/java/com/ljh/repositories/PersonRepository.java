package com.ljh.repositories;

import com.ljh.entity.Person;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * PersonRepository
 *
 * @author ljh
 * created on 2019/11/14 10:07
 */
// @RepositoryDefinition 可替代继承 Repository 接口
// @RepositoryDefinition(domainClass = Person.class, idClass = Integer.class)
public interface PersonRepository extends Repository<Person, Integer> {

    // 根据 lastName 获取对应的 Person
    Person getByLastName(String lastName);
}
