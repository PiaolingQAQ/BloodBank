package com.example.BloodBank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("user")
@Data

public class User{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer blood_num;
    private String nick_name;
    private String blood_type;
    private String date;
}