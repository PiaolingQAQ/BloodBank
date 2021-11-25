package com.example.BloodBank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.BloodBank.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends BaseMapper<User> {

}