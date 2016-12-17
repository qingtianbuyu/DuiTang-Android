package com.duitang.entity;

import java.io.Serializable;
import java.util.List;

public class LoginResultEntity implements Serializable {
    public List<String> bind_sites;
    public User user;
}
