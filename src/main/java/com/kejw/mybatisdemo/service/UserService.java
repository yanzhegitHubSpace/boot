package com.kejw.mybatisdemo.service;

import com.kejw.mybatisdemo.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();

    int deleteById(Integer id);
}
