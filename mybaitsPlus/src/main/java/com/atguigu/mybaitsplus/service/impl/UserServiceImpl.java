package com.atguigu.mybaitsplus.service.impl;

import com.atguigu.mybaitsplus.mapper.UserMapper;
import com.atguigu.mybaitsplus.pojo.User;
import com.atguigu.mybaitsplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
