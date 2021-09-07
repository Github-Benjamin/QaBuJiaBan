package com.qabujiaban.benjamin.test.service;

import com.qabujiaban.benjamin.test.entity.User;
import com.qabujiaban.benjamin.test.maaper.TestMyBatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 11:37
 */

@Service
public class TestMyBatisService {

    @Autowired
    private TestMyBatisMapper testMyBatisMapper;

    public User getUserInfo(Integer id){
        User  user = testMyBatisMapper.findUserId(id);
        if(user == null){
            return  new User();
        }
        return user;
    }



    public Map<String,Object> getUserIdMap(Integer id){
        Map<String,Object>  user = testMyBatisMapper.findUserIdMap(id);
        if(user == null){
            return new HashMap<>();
        }
        return user;
    }

    public <T> List<Map<String, Object>> getAllUser(){
        List<Map<String, Object>> user = testMyBatisMapper.findAllUser();
        if(user == null){
            return new ArrayList<>();
        }
        return testMyBatisMapper.findAllUser();
    }


}
