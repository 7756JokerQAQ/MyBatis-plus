package com.atguigu.mybaitsplus.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data //lombok注解
public class User {
    @TableId
    private Long id;
    @TableField("username")
    private String name;
    private Integer age;
    private String email;
}

//c>通过全局配置解决问题