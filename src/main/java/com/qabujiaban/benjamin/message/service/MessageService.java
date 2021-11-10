package com.qabujiaban.benjamin.message.service;

import com.qabujiaban.benjamin.message.entity.TestVo;
import com.qabujiaban.benjamin.message.entity.Message;
import com.qabujiaban.benjamin.message.entity.PageInfo;
import com.qabujiaban.benjamin.message.maaper.MessageMapper;
import com.qabujiaban.benjamin.message.util.SetHtmlString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/4 14:32
 */


@Service
public class MessageService {


    @Autowired
    private MessageMapper messageMapper;

    // 添加事务回滚
    @Transactional
    public Message MessageInsert(TestVo testVo){
        String user = testVo.getMessage_user();
        String content = testVo.getMessage_content();

        user = SetHtmlString.setHtmlString(user);
        content = SetHtmlString.setHtmlString(content);

        if (user.length() <= 255){
            messageMapper.MessageInsert(user,
                                        content,
                                        testVo.getMessage_ip(),
                                        testVo.getMessage_city());

        }
        return null;



    }

    /*
        前台
     */
    private int getAllMessageStatus(){
        if(messageMapper.getMessageManageStatus().equals("True")){
            int count =messageMapper.getAllMessageStatus();
        }
        int count =messageMapper.getAllMessage();
        return count;
    }

    private List<Message> getMessageStatus(Integer begin, Integer end){
        if(messageMapper.getMessageManageStatus().equals("True")){
            return messageMapper.getMessageStatus(begin,end);
        }
        return  messageMapper.getMessage(begin,end);

    }

    public PageInfo getMessageStatusPageInfo(Integer pageNum){

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setTotalSize(getAllMessageStatus());
        pageInfo.setPageSize(20);
        pageInfo.setTotalPages((int) Math.ceil(Double.valueOf(pageInfo.getTotalSize()) / Double.valueOf(pageInfo.getPageSize())));
        Integer begin = (pageInfo.getPageNum()-1) * 20;
        Integer end = 20;
        pageInfo.setMessage(getMessageStatus(begin,end));
        return pageInfo;

    }



    /*
        后台
     */
    private int getAllMessage(){
        int count =messageMapper.getAllMessage();
        return count;
    }

    private List<Message> getMessage(Integer begin, Integer end){
        return messageMapper.getMessage(begin,end);
    }

    public PageInfo getMessagePageInfo(Integer pageNum){

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setTotalSize(getAllMessage());
        pageInfo.setPageSize(20);
        pageInfo.setTotalPages((int) Math.ceil(Double.valueOf(pageInfo.getTotalSize()) / Double.valueOf(pageInfo.getPageSize())));
        Integer begin = (pageInfo.getPageNum()-1) * 20;
        Integer end = 20;
        pageInfo.setMessage(getMessage(begin,end));

        return pageInfo;

    }


    /*
        Springboot 事务管理，防止程序报错后 错误数据插入数据库
     */

    // 单个删除
    @Transactional
    public void deleteMessageId(Integer id){
        messageMapper.deleteMessageId(id);
    }


    // 批量删除
    @Transactional
    public void deleteManyMessageId(String idList){
        List idLists = Arrays.asList(idList.split(","));
        idLists.forEach(id ->{
            Integer message_id = Integer.parseInt((String) id);
            messageMapper.deleteMessageId(message_id);
        });
    }


    // 编辑 单个留言审核状态
    @Transactional
    public void updateMessage(Integer message_status,Integer  id){
        messageMapper.updateMessage(message_status,id);
    }

    // 编辑 整个留言审核状态
    @Transactional
    public void updateMessageManageStatus(String message_manage){
        messageMapper.updateMessageManageStatus(message_manage);
    }


}
