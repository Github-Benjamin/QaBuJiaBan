package com.qabujiaban.benjamin.weblog.controller;

import com.qabujiaban.benjamin.weblog.service.WebLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 17:04
 */

@RestController
public class WebLogController {

    @Autowired
    private WebLogService webLogService;

    /**
     * 获取所有独立ip访问的用户数
     * @return
     */
    @RequestMapping("/getAllCountIp")
    public Map<String,Object> getAllCountIp(){
        return webLogService.getAllCountIp();
    }

    /**
     * 获取所有LogName搜索字段top20
     * @return
     */
    @RequestMapping("/getAllCountLogName")
    public List<Map<String,Object>> getAllCountLogName(){
        return webLogService.getAllCountLogName();
    }

    /**
     * 获取所有LogContent行为字段的top11
     * @return
     */
    @RequestMapping("/getAllCountLogContent")
    public List<Map<String,Object>>  getAllCountLogContent(){
        return webLogService.getAllCountLogContent();
    }

    /**
     * 获取指定日期范围的独立ip访问数
     * @param begin 开始时间 如：2021-08-12
     * @param end   结束时间 如：2021-08-13
     * @return
     */
    @RequestMapping("/getDayCountIP")
    public Map<String,Object>  getDayCountIP(String begin,String end){
        System.out.println(begin + end);
        return webLogService.getDayCountIP(begin,end);
    }

    /**
     * 获取指定日期范围的独立ip访问数LogName
     * @param begin 开始时间 如：2021-08-12
     * @param end   结束时间 如：2021-08-13
     * @return
     */
    @RequestMapping("/getDayCountLogName")
    public List<Map<String,Object>>  getDayCountLogName(String begin,String end){
        return webLogService.getDayCountLogName(begin,end);
    }

    /**
     * 获取指定日期范围的独立ip访问数LogContent
     * @param begin 开始时间 如：2021-08-12
     * @param end   结束时间 如：2021-08-13
     * @return
     */
    @RequestMapping("/getDayCountLogContent")
    public List<Map<String,Object>>  getDayCountLogContent(String begin,String end){
        return webLogService.getDayCountLogContent(begin,end);
    }




    /**
     * 获取指定日期范围每天访问ip总数
     * @param begin 开始时间 如：2021-08-12
     * @param end   结束时间 如：2021-08-13
     * @return
     */
    @RequestMapping("/getEveryDayCountIP")
    public List<Map<String,Object>>  getEveryDayCountIP(String begin,String end){
        return webLogService.getEveryDayCountIP(begin,end);
    }


    /**
     * 获取指定日期范围每天访问独立ip总数
     * @param begin 开始时间 如：2021-08-12
     * @param end   结束时间 如：2021-08-13
     * @return
     */
    @RequestMapping("/getEveryDayAloneCountIP")
    public List<Map<String,Object>>  getEveryDayAloneCountIP(String begin,String end){
        return webLogService.getEveryDayAloneCountIP(begin,end);
    }


}
