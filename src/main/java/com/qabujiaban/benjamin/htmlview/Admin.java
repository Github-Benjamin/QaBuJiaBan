package com.qabujiaban.benjamin.htmlview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/5 14:48
 */

@Controller
public class Admin {

    /**
     * 模板渲染与resources/templates/xxx.html文件对应
     * @return resources/templates/xxx.html
     */
    @RequestMapping("/admin")
    public String admin(){
        return "backIndex";
    }

    @RequestMapping("/backMessage")
    public String backMessage(){
        return "backMessage";
    }

    @RequestMapping("/Login")
    public String Login(){
        return "backLogin";
    }


}
