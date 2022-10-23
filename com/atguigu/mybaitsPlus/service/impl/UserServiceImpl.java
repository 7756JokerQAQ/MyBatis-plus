package com.atguigu.mybaitsPlus.service.impl;

import com.atguigu.mybaitsPlus.entity.User;
import com.atguigu.mybaitsPlus.mapper.UserMapper;
import com.atguigu.mybaitsPlus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-10-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
