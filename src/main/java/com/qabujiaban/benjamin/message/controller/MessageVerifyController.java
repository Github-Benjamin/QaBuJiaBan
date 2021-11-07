package com.qabujiaban.benjamin.message.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/4 14:03
 */



@Controller
public class MessageVerifyController {

    /**
     * 验证页面
     */
    @RequestMapping("/Message")
    public String Message() {
        return "Message";
    }


}

