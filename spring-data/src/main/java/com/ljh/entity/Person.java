package com.ljh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Person
 *
 * @author ljh
 * created on 2019/11/13 14:49
 */
//@Getter
//@Setter
//@ToString
@Table(name="JPA_PERSONS")
@Entity
public class Person {

    @GeneratedValue
    @Id
    private Integer id;
    private String lastName;
    private String email;
    private Date birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
