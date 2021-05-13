package com.kejw.mybatisdemo.mapper;

import com.kejw.mybatisdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> findAll();

    int deleteById(Integer id);
}

