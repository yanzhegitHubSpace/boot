package com.kejw.mybatisdemo.controller;

import com.kejw.mybatisdemo.entity.UserEntity;
import com.kejw.mybatisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/info/{id}")
    public boolean deleteById(@PathVariable("id") Integer id){
        logger.info("删除请求，收到的参数 = ", id);
        int byId = userService.deleteById(id);
        return byId > 0 ? true : false;
    }


}
