package com.atguigu.mybaitsplus;

import com.atguigu.mybaitsplus.mapper.ProductMapper;
import com.atguigu.mybaitsplus.mapper.UserMapper;
import com.atguigu.mybaitsplus.pojo.Product;
import com.atguigu.mybaitsplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPlugingsTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void testPages(){
        Page<User> uSerPage = new Page<User>(1,3);
        userMapper.selectPage(uSerPage,null);
        System.out.println(uSerPage.getRecords());
        System.out.println(uSerPage.getPages());
    }
    @Test
    public void testProduct01(){

        //小李来查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格:"+productLi.getPrice());
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格:"+productLi.getPrice());
        //小李+50
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        productWang.setPrice(productWang.getPrice()-30);
        int i = productMapper.updateById(productWang);
        if(i==0){
            //操作失败重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice()-30);
            productMapper.updateById(productNew);
        }
        Product productLaoBan = productMapper.selectById(1);
        System.out.println("老板查询的商品价格:"+productLaoBan.getPrice());


    }


}
