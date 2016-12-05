package com.duitang.entity;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/5 下午8:33
 */
public class User {
    /**
     * id : 4340303
     * username : BalalaPure
     * avatar : https://a-ssl.duitang.com/uploads/people/201409/09/20140909232152_aBZzA.jpeg
     * identity : ["personal_certify"]
     * is_certify_user : true
     */

    private int id;
    private String username;
    private String avatar;
    private boolean is_certify_user;
    private List<String> identity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isIs_certify_user() {
        return is_certify_user;
    }

    public void setIs_certify_user(boolean is_certify_user) {
        this.is_certify_user = is_certify_user;
    }

    public List<String> getIdentity() {
        return identity;
    }

    public void setIdentity(List<String> identity) {
        this.identity = identity;
    }
}
