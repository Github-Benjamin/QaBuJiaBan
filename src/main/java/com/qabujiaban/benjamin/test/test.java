package com.qabujiaban.benjamin.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 11:22
 */


@RestController
public class test {

    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("request url",request.getRequestURL().toString());
        result.put("method", request.getMethod());
        result.put("ipAddress", request.getRemoteAddr());
        result.put("x-client-ip",request.getHeader("x-client-ip"));
        result.put("X-Real-IP",request.getHeader("X-Real-IP"));
        return result.toJSONString();
    }



}
