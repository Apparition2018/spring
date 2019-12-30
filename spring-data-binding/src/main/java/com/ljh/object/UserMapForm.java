package com.ljh.object;

import java.util.Map;

/**
 * UserMapForm
 *
 * @author ljh
 * created on 2019/10/28 18:14
 */
public class UserMapForm {

    private Map<String, User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserMapForm{" +
                "users=" + users +
                '}';
    }
}
