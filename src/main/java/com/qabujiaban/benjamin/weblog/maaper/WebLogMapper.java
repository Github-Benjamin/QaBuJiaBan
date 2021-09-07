package com.qabujiaban.benjamin.weblog.maaper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/8/12 17:05
 */



@Mapper
public interface WebLogMapper {

    // # 总 独立ip总人数，ip去重
    @Select("SELECT COUNT(*)  as all_count_ip from (SELECT log_ip FROM web_log GROUP BY log_ip)as count_ip")
    Map<String,Object> getAllCountIp();

    // # 总 热词搜索前20条 log_name
    @Select("SELECT log_name as name, COUNT(*) as value from web_log GROUP BY log_name ORDER BY COUNT(*) DESC limit 0,20")
    List<Map<String,Object>>  getAllCountLogName();

    // # 总 用户行为排序 log_content
    @Select("SELECT log_content as name, COUNT(*) as value from web_log GROUP BY log_content ORDER BY COUNT(*) DESC limit 0,11")
    List<Map<String,Object>>  getAllCountLogContent();

    //# 单 查询某时间独立用户访问用户ip总人数，ip已去重
    @Select("SELECT COUNT(*)  as day_count_ip from (SELECT log_ip FROM web_log " +
    "where " +
    "log_time > #{begin}" +
    "and " +
    "log_time < #{end}" +
    "GROUP BY log_ip)as count_ip")
    Map<String,Object> getDayCountIP(@Param("begin") String begin,@Param("end") String end);

    //# 单 查询某时间热词搜索前20条 log_name
    @Select("SELECT log_name as name, COUNT(*)  as value  from web_log " +
            "where " +
            "log_time > #{begin}" +
            "and " +
            "log_time < #{end}" +
            "GROUP BY log_name ORDER BY COUNT(*) DESC limit 0,20")
    List<Map<String,Object>> getDayCountLogName(@Param("begin") String begin,@Param("end") String end);

    //# 单 查询某时间用户行为排序log_content次数
    @Select("SELECT log_content as name, COUNT(*) as value from web_log " +
            "where " +
            "log_time > #{begin}" +
            "and " +
            "log_time < #{end}" +
            "GROUP BY log_content ORDER BY COUNT(*) DESC limit 0,11")
    List<Map<String,Object>> getDayCountLogContent(@Param("begin") String begin,@Param("end") String end);



    //# 单 查询用户某时间段每天访问ip总数，ip未去重
    @Select("select " +
                "date_format(log_time, '%Y-%m-%d') name, " +
                "count(*) value " +
            "from " +
                "web_log   " +
            "where " +
                "log_time >  #{begin} " +
                "and " +
                "log_time <  #{end}  " +
            "group by date_format(log_time, '%Y-%m-%d')")
    List<Map<String,Object>> getEveryDayCountIP(@Param("begin") String begin,@Param("end") String end);


    //# 单 查询用户某时间断每天独立访问ip总数
    @Select("SELECT " +
                "result.dat name," +
                "count(result.num) value " +
            "FROM " +
                "( " +
                "SELECT " +
                    "date_format(log_time,'%Y-%m-%d')dat," +
                    "count(log_ip)num " +
                "FROM " +
                    "web_log " +
                "WHERE " +
                    "log_time> #{begin} " +
                    "AND " +
                    "log_time< #{end} " +
                "GROUP BY " +
                    "date_format(log_time,'%Y-%m-%d')," +
                    "log_ip" +
                ")AS result " +
            "GROUP BY " +
                "result.dat")
    List<Map<String,Object>> getEveryDayAloneCountIP(@Param("begin") String begin,@Param("end") String end);

}
