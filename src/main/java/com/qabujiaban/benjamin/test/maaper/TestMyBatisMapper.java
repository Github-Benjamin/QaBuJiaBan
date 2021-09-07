package com.qabujiaban.benjamin.test.maaper;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 11:37
 */


import com.qabujiaban.benjamin.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface TestMyBatisMapper {
    @Select("select * from user where id = #{id}")
    User findUserId(@Param("id") Integer id);

    @Select("select * from user")
    List<Map<String,Object>> findAllUser();

    @Select("select * from user where id = #{id}")
    Map<String,Object> findUserIdMap(@Param("id") Integer id);

}
