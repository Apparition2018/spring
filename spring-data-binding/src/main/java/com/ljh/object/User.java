package com.ljh.object;

import lombok.Data;

/**
 * User
 *
 * @author ljh
 * created on 2019/10/28 16:57
 */
@Data
public class User {
    private String name;
    private String password;
    private Integer age;
    private ContactInfo contactInfo;
}
