package com.qabujiaban.benjamin.message.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/5 22:15
 */



@RestController
public class AdminLoginController {

    private static String[] usernameList = {"benjamin","QAbujiaban"};
    private static String[] passwordList = {"benjamin123","QAbujiaban123"};


    // 编辑
    @RequestMapping("/LoginAuth")
    public Map<String, String> LoginAuth(HttpServletRequest request, String username, String password){

        HttpSession session = request.getSession();
        Map<String, String> m = new HashMap<>();

        Integer numKey = -1;

        for( String key : usernameList ) {
            numKey += 1;
            if (key.contains(username)) {
                if(password.equals(passwordList[numKey])){
                    session.setAttribute("name",username);
                    m.put("message", "成功");
                    return m;
                }
            }
        }

        m.put("message", "失败");
        return m;
    }



}
