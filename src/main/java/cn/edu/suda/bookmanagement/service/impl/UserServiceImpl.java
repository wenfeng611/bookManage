package cn.edu.suda.bookmanagement.service.impl;

import cn.edu.suda.bookmanagement.entity.User;
import cn.edu.suda.bookmanagement.repository.UserRepository;
import cn.edu.suda.bookmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByNameAndPassword(String name, String password) {
        return userRepository.findByUsernameAndPassword(name,password);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
