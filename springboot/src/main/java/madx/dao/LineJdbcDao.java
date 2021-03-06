package madx.dao;

import madx.common.Common;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by A-mdx on 2016/11/26.
 */
@Component
public class LineJdbcDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Map<String,Object>> queryLineList(Map<String,Object> param,boolean isPage){
        
        List<Object> objList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder("SELECT\n");
        if (isPage){
            sql.append("  l.`creator` creator_id,\n" +
                    "  l.`id`,\n" +
                    "  l.`file_num`,\n" +
                    "  l.`line_num`,\n" +
                    "  l.`line_than_provious`,\n" +
                    "  l.`num_than_provious`,\n" +
                    "  u.`name` creator,\n" +
                    "  l.`creation_time`,\n" +
                    "  DATE_FORMAT(\n" +
                    "    l.`creation_time`,\n" +
                    "    '%Y-%m-%d %H:%i:%s'\n" +
                    "  ) creation_time_str ");
        }else{
            sql.append("  COUNT(1) count\n");
        }
        
        sql.append("FROM\n" +
                "  java_line_num l \n" +
                "  LEFT JOIN USER u \n" +
                "    ON l.`creator` = u.`id` \n" +
                "WHERE 1 = 1 \n");
        
        // user id 
        Object id = param.get("userid");
        if (id != null && StringUtils.isNotBlank(id.toString())){
            sql.append("  AND l.`creator` = ? \n");
            intList.add(Types.INTEGER);
            objList.add(id);
        }
        
        // line_than_provious >=
        Object line_than_big = param.get("line_than_big");
        if (line_than_big != null && StringUtils.isNotBlank(line_than_big.toString())){
            sql.append("  AND l.`line_than_provious` >= ? \n");
            intList.add(Types.INTEGER);
            objList.add(line_than_big);
        }
        
        // line_than_provious <=
        Object line_than_small = param.get("line_than_small");
        if (line_than_small != null && StringUtils.isNotBlank(line_than_small.toString())){
            sql.append("  AND l.`line_than_provious` <= ? \n");
            intList.add(Types.INTEGER);
            objList.add(line_than_small);
        }
        
        // creation_time >=
        Object startTime = param.get("startTime");
        if (startTime != null && StringUtils.isNotBlank(startTime.toString())){
            sql.append("  AND l.`creation_time` >= ? \n");
            intList.add(Types.VARCHAR);
            objList.add(startTime);
        }
        
        // creation_time <=
        if (Common.isNotNull(param,"endTime",objList)){
            sql.append("  AND l.`creation_time` <= ? \n");
            intList.add(Types.VARCHAR);
        }
        
        if (isPage){
            sql.append("ORDER BY l.`creation_time` DESC \n" +
                    "LIMIT ?, ?");
            intList.add(Types.INTEGER);
            objList.add(param.get("pageNumber"));
            intList.add(Types.INTEGER);
            objList.add(param.get("pageSize"));
        }
        System.out.println("LineJdbcDao -> queryLineList -> \n"+sql);
        
        return jdbcTemplate.queryForList(sql.toString(),objList.toArray(), Common.convertIntArr(intList));
        
    }
    
    
    public List<Map<String,Object>> queryPathList(Map<String,Object> param,boolean isPage){

        List<Object> objList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder("SELECT\n");
        if (isPage){
            sql.append("  f.`path`,\n" +
                    "  f.`id`,\n" +
                    "  fc.`code_name` is_big_path,\n" +
                    "  f.`modify_time`,\n" +
                    "  f.`now_line`,\n" +
                    "  f.`now_num`,\n" +
                    "  DATE_FORMAT(\n" +
                    "    f.`modify_time`,\n" +
                    "    '%Y-%m-%d %H:%i:%s'\n" +
                    "  ) modify_time,\n" +
                    "  f.`modifier`,\n" +
                    "  u.`name` user,\n" +
                    "  DATE_FORMAT(\n" +
                    "    f.`creation_time`,\n" +
                    "    '%Y-%m-%d %H:%i:%s'\n" +
                    "  ) creation_time,\n" +
                    "  u1.`name` creator,\n" +
                    "  f.remark,\n" +
                    "  f.`is_active`,\n" +
                    "  fc1.`code_name` is_active_str \n");
        }else {
            sql.append("  COUNT(1) count\n");
        }
        
        sql.append("FROM\n" +
                "  java_file_path f \n" +
                "  LEFT JOIN USER u \n" +
                "    ON f.`user_id` = u.`id` \n" +
                "  LEFT JOIN fix_code fc \n" +
                "    ON fc.`code` = f.`is_big_path` \n" +
                "  LEFT JOIN USER u1 \n" +
                "    ON f.`creator` = u1.`id` \n" +
                "  LEFT JOIN fix_code fc1 \n" +
                "    ON fc1.`code` = f.`is_active` \n" +
                "WHERE 1 = 1 \n");

        // user id 
        if (Common.isNotNull(param,"userid",objList)){
            sql.append("  AND f.`user_id` = ? \n");
            intList.add(Types.INTEGER);
        }
        
        // is_big_path
        if (Common.isNotNull(param,"is_big_path",objList)){
            sql.append("  AND f.`is_big_path` = ? \n");
            intList.add(Types.INTEGER);
        }
        
        if (isPage){
            sql.append("ORDER BY f.`id` DESC \n" +
                    "LIMIT ?, ?");
            intList.add(Types.INTEGER);
            objList.add(param.get("pageNumber"));
            intList.add(Types.INTEGER);
            objList.add(param.get("pageSize"));
        }

        System.out.println("queryPathList sql -> \n"+sql);
        
        return jdbcTemplate.queryForList(sql.toString(),objList.toArray(),Common.convertIntArr(intList));
    }
    
}
