package com.ljh.object;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * UserMapForm
 *
 * @author ljh
 * created on 2019/10/28 18:14
 */
@Getter
@Setter
public class UserMapForm {

    private Map<String, User> users;
}
