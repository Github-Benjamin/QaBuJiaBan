package com.qabujiaban.benjamin.message.util;





import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/4 16:07
 */


public class GetIPCity {

    /*
        ip
        key
        return province city
     */
    private static String url = "http://restapi.amap.com/v3/ip";
    private static String key = "c046e5c67c97e1555532b8586173f01c";



    public static String GetRequestIP(HttpServletRequest request) {

        String ipAddress = null;
        try {
            ipAddress = request.getHeader("X-Real-IP");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    try {
                        ipAddress = InetAddress.getLocalHost().getHostAddress();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            }
            // 通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null) {
                if (ipAddress.contains(",")) {
                    return ipAddress.split(",")[0];
                } else {
                    return ipAddress;
                }
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String GetRequestCity(String requestIP){
            //1.生成HttpClient对象并设置参数
            HttpClient httpClient = new HttpClient();
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(600);

            //2.生成GetMethod对象并设置参数
            String req_url = url + "?key=" + key + "&ip=" + requestIP;
            GetMethod getMethod = new GetMethod(req_url);

            String response = "";
            //3.执行HTTP GET 请求
            try {
                int statusCode = httpClient.executeMethod(getMethod);
                //读取HTTP响应内容，这里简单打印网页内容
                byte[] responseBody = getMethod.getResponseBody();
                response = new String(responseBody);
            } catch (HttpException e) {
                //发生致命的异常，可能是协议不对或者返回的内容有问题
                System.out.println("请检查输入的URL!");
                e.printStackTrace();
            } catch (IOException e) {
                //发生网络异常
                System.out.println("发生网络异常!");
            } finally {
                //6.释放连接
                getMethod.releaseConnection();
            }
            return getCityJson(response);

    }

    private static String getCityJson(String str){
        JSONObject object = (JSONObject) JSONObject.parse(str);
        String province = String.valueOf(object.get("province"));
        String city = String.valueOf(object.get("city"));
        if(province.equals("[]") && city.equals("[]")){
            return "unknow";
        }else {
            return province + "." + city;
        }
    }

    public static void main(String[] strings){

//         https://restapi.amap.com/v3/ip?key=c046e5c67c97e1555532b8586173f01c&ip=192.168.13.215
        System.out.println(GetRequestCity("171.217.91.151"));
//        System.out.println(7.0/20.0);
//        System.out.println(Math.ceil(7/20));
    }





}
