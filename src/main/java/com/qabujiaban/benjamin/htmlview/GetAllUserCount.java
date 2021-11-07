package com.qabujiaban.benjamin.htmlview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 19:26
 */


@Controller
public class GetAllUserCount {

    /**
     * 模板渲染与resources/templates/xxx.html文件对应
     * @return resources/templates/xxx.html
     */
    @RequestMapping("/GetAllUSerCount")
    public String GetAllUSerCount(){
        return "backGetAllUSerCount";
    }

}
