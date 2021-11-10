package com.qabujiaban.benjamin.message.util;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/8 20:01
 */


public class SetHtmlString {


    public static String setHtmlString(String str){

        if(str.contains(">")){
            str = str.replace(">","&gt;");
        }

        if(str.contains("<")){
           str = str.replace("<","&lt;");
        }

        return str;

    }


}
