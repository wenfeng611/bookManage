package cn.edu.suda.bookmanagement.service;

import cn.edu.suda.bookmanagement.entity.User;

public interface UserService {
    User findUserByNameAndPassword(String name, String password);
    User findUserByName(String name);
}
