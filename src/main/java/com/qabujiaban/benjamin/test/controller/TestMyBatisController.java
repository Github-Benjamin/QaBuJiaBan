package com.qabujiaban.benjamin.test.controller;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 11:37
 */

import com.qabujiaban.benjamin.test.entity.User;
import com.qabujiaban.benjamin.test.service.TestMyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
流程
 1、controller 控制层，url定义的逻辑定义
 2、maaper 原始sql语句
 3、service 参数处理及分页原理
 4、entity 对象属性
 */



@RestController
public class TestMyBatisController {

    @Autowired
    private TestMyBatisService testMyBatisService;

    @RequestMapping("/getUserId")
    public User getUserId(Integer id){
        return testMyBatisService.getUserInfo(id);
    }

    @RequestMapping("/getAllUser")
    public List<Map<String, Object>> getAllUser(){
        return testMyBatisService.getAllUser();
    }

    @RequestMapping("/getAllUserPro")
    public Map<String,Object> getAllUserPro(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("errorCode",0);
        result.put("errorMeg","成功");
        result.put("AllUserInfo",testMyBatisService.getAllUser());
        return result;
    }

    @RequestMapping("/getUserIdMap")
    public Map<String,Object> getUserIdMap(Integer id){
        return testMyBatisService.getUserIdMap(id);
    }


}
