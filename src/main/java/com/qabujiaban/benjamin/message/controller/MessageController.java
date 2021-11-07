package com.qabujiaban.benjamin.message.controller;

import com.qabujiaban.benjamin.message.entity.PageInfo;
import com.qabujiaban.benjamin.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/4 19:47
 */



@RestController
public class MessageController {

    /*
        1、前台，筛选message_status为1的展示；支持分页查询
        2、后台留言管理：留言查看，编辑修改状态（显示，不显示），站长回复，删除，支持分页
     */

    @Autowired
    private MessageService messageService;


    /*
        前台
        获取Status为1的公开留言分页数据，传输pageNum
     */
    @RequestMapping("/getMessageStatusPageInfo")
    public PageInfo getMessageStatusPageInfo(Integer pageNum){
        return messageService.getMessageStatusPageInfo(pageNum);
    }


    /*
        后台
        获取所有留言数据
     */
    @RequestMapping("/getMessagePageInfo")
    public PageInfo getMessagePageInfo(Integer pageNum){
        return messageService.getMessagePageInfo(pageNum);
    }


    // 单个删除
    @RequestMapping("/deleteMessageId")
    public Map<String, String> deleteMessageId(Integer id){
        messageService.deleteMessageId(id);

        Map<String, String> m = new HashMap<>();
        m.put("message", "成功");
        return m;
    }

    // 批量删除
    @RequestMapping("/deleteManyMessageId")
    public Map<String, String> deleteManyMessageId(String idList){
        messageService.deleteManyMessageId(idList);

        Map<String, String> m = new HashMap<>();
        m.put("message", "成功");
        return m;
    }


    // 编辑
    @RequestMapping("/updateMessage")
    public Map<String, String> updateMessage(Integer message_status, Integer id){
        messageService.updateMessage(message_status,id);

        Map<String, String> m = new HashMap<>();
        m.put("message", "成功");
        return m;
    }

}
