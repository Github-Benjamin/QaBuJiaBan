package com.qabujiaban.benjamin.message.maaper;

import com.qabujiaban.benjamin.message.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/4 14:21
 */

@Mapper
public interface MessageMapper {

    // 增加留言
    @Insert(" INSERT INTO message(message_user,message_content,message_ip,message_city) VALUE(#{message_user},#{message_content},#{message_ip},#{message_city})")
    void MessageInsert(@Param("message_user") String message_user,
                       @Param("message_content") String message_content,
                       @Param("message_ip") String message_ip,
                       @Param("message_city") String message_city);


    // 前台 分页查询 message_status = 1 的数据
    /*
        pageSize
        totalSize
     */
    // 查询前台总页数 每页20条
    @Select("SELECT count(*) from message where message_status = 1")
    int getAllMessageStatus();

    // 前台 分页查询 Status = 1
    // select * from table LIMIT 5,10
    @Select("SELECT * from message where message_status = 1 order by id desc LIMIT #{begin},#{end}")
    List<Message> getMessageStatus(@Param("begin")Integer begin, @Param("end")Integer end);

    // 前台分页管理 不审核直接显示
    @Select("SELECT message_manage from message_manage where id = 1")
    String getMessageManageStatus();

    // 管理 前台留言是否未审核 1是开启审核，0是关闭审核
    @Select("update message_manage SET message_manage = #{message_manage} where id = 1")
    void updateMessageManageStatus(@Param("message_manage")String message_manage);



    /*
        后台
     */
    // 查询后台总页数 每页20条
    @Select("SELECT count(*) from message")
    int getAllMessage();

    // 后台 分页查询
    @Select("SELECT * from message order by id desc LIMIT #{begin},#{end}")
    List<Message> getMessage(@Param("begin")Integer begin, @Param("end")Integer end);

    // 单个删除
    @Delete("DELETE FROM message WHERE id = #{id}")
    void deleteMessageId(@Param("id")Integer id);

    // 批量删除 不支持
    // delete from table where id in (1,2,3...)
    // @Delete("DELETE FROM message WHERE id in (#{idList})")
    // void deleteManyMessageId(@Param("idList")String idList);

    // 编辑
    // update 表名 set 字段名1＝值1，... Where 关键字＝值
    @Update("UPDATE message SET message_status = #{message_status} WHERE id = #{id}")
    void updateMessage(@Param("message_status")Integer message_status,@Param("id")Integer id);


}
