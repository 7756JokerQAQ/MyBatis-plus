package com.atguigu.mybaitsplus;

import com.atguigu.mybaitsplus.mapper.UserMapper;
import com.atguigu.mybaitsplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusWapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectTest() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "a").between("age", 18, 30).isNotNull("email");

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testSort() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //年龄大于20且包含a 或者邮箱为null的修改
        queryWrapper
                .gt("age", 20)
                .like("name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("LYC");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    //将用户名包含B并且（年龄大于20或者邮箱为空的）用户信息修改
    @Test
    public void testUpdate2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "B")
                .and(i -> i
                        .gt("age", 20)
                        .or()
                        .isNull("email")
                );
        User user = new User();
        user.setName("王五");
        int update = userMapper.update(user, queryWrapper);
        System.out.println("result=" + update);
    }

    //查询用户的年龄邮箱和姓名
    @Test
    public void selectTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }



}
