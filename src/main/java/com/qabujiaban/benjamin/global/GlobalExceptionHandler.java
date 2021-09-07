package com.qabujiaban.benjamin.global;
/*
 *@author Benjamin
 *@2021/4/4 7:05 下午
 */


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// 全局捕获异常
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> reslutJsonErro(Exception e){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("errorCode","500");
        result.put("errorMsg","系统错误");
        // 捕获异常并打印异常
        System.out.println(e);
        return result;
    }


}
