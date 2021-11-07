package com.qabujiaban.benjamin.htmlview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/13 9:38
 */

@Controller
public class GetDayUserCount {


    @RequestMapping("/GetDayUserCount")
    public String GetDayUserCount(){
        return "backGetDayUserCount";
    }


}
