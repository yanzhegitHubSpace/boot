package com.kejw.mybatisdemo.service.impl;

import com.kejw.mybatisdemo.controller.UserController;
import com.kejw.mybatisdemo.entity.UserEntity;
import com.kejw.mybatisdemo.mapper.UserMapper;
import com.kejw.mybatisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

}
