package com.ljh.object;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 *
 * @author ljh
 * created on 2019/10/28 16:57
 */
@Getter
@Setter
@EqualsAndHashCode
public class User {

    private String name;
    private Integer age;
    private ContactInfo contactInfo;
}
