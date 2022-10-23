package com.atguigu.mybaitsplus;

import com.atguigu.mybaitsplus.mapper.UserMapper;
import com.atguigu.mybaitsplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;
    private UserMapper userMapper1;

    @Test
    public void testSelectList() {
        //通过条件构造器查询list集合
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    /**
     * 实现新增用户信息
     */
    public void testInsertUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(29);
        user.setEmail("zhangsan@guigu");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testDeleteById() {
        // int result = userMapper.deleteById(1583380690149076993L);
        //System.out.println("result="+result);
        //根据map删除
       /* Map<String,Object>map=new HashMap<>();
        map.put("name","张三");
        map.put("age","23");
        int result = userMapper.deleteByMap(map);
        System.out.println("result="+result);*/
        //实现批量删除
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int i = userMapper.deleteBatchIds(list);
        System.out.println("result=" + i);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setAge(23);
        user.setEmail("lis@quda");
        int update = userMapper.updateById(user);
        System.out.println("result=" + update);
    }




}
