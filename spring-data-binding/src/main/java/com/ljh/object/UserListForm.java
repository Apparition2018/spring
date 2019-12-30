package com.ljh.object;

import java.util.List;

/**
 * UserListForm
 *
 * @author ljh
 * created on 2019/10/28 17:09
 */
public class UserListForm {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListForm{" +
                "users=" + users +
                '}';
    }
}
