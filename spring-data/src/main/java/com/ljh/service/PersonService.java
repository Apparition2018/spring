package com.ljh.service;

import com.ljh.entity.Person;
import com.ljh.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PersonService
 *
 * @author ljh
 * created on 2019/11/15 15:05
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void updatePersonEmail(String email, Integer id) {
        personRepository.updatePersonEmail(email, id);
    }

    @Transactional
    public void savePerson(List<Person> personList) {
        personRepository.saveAll(personList);
    }
}
