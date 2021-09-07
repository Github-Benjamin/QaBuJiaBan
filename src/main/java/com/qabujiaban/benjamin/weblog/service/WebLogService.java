package com.qabujiaban.benjamin.weblog.service;

import com.qabujiaban.benjamin.weblog.maaper.WebLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 17:05
 */



@Service
public class WebLogService {

    @Autowired
    private WebLogMapper webLogMapper;

    public Map<String,Object> getAllCountIp(){
        return webLogMapper.getAllCountIp();
    }

    public List<Map<String,Object>>  getAllCountLogName(){
        return webLogMapper.getAllCountLogName();
    }

    public List<Map<String,Object>> getAllCountLogContent(){
        return webLogMapper.getAllCountLogContent();
    }



    public Map<String,Object> getDayCountIP(String begin,String end){
        return webLogMapper.getDayCountIP(begin,end);
    }

    public List<Map<String,Object>> getDayCountLogName(String begin,String end){
        return webLogMapper.getDayCountLogName(begin,end);
    }

    public List<Map<String,Object>> getDayCountLogContent(String begin,String end){
        return webLogMapper.getDayCountLogContent(begin,end);
    }


    public List<Map<String,Object>> getEveryDayCountIP(String begin,String end){
        return webLogMapper.getEveryDayCountIP(begin,end);
    }

    public List<Map<String,Object>> getEveryDayAloneCountIP(String begin,String end){
        return webLogMapper.getEveryDayAloneCountIP(begin,end);
    }




}

