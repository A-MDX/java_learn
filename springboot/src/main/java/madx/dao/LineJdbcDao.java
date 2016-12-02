package madx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
                "WHERE l.`creator` = "+param.get("userid")+"\n");
        
        if (isPage){
            sql.append("ORDER BY l.`creation_time` DESC \n" +
                    "LIMIT "+param.get("pageNumber")+", "+param.get("pageSize"));
        }
        System.out.println("LineJdbcDao -> queryLineList -> \n"+sql);
        return jdbcTemplate.queryForList(sql.toString());
        
    }
    
    public List<Map<String,Object>> queryPathList(Map<String,Object> param,boolean isPage){
        StringBuilder sql = new StringBuilder("SELECT\n");
        if (isPage){
            sql.append("f.`path`,\n" +
                    "  f.`id`,\n" +
                    "  fc.`code_name` is_big_path,\n" +
                    "  f.`modify_time`,\n" +
                    "  f.`now_line`,\n" +
                    "  f.`now_num`,\n" +
                    "  f.`modifier`,\n" +
                    "  f.`modify_time`,\n" +
                    "  u.`name` user,\n" +
                    "  DATE_FORMAT(\n" +
                    "    f.`creation_time`,\n" +
                    "    '%Y-%m-%d %H:%i:%s'\n" +
                    "  ) creation_time,\n" +
                    "  u1.`name` creator,\n" +
                    "  f.remark \n ");
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
                "WHERE f.`user_id` = "+param.get("userid")+"\n");
        
        if (isPage){
            sql.append("ORDER BY f.`id` DESC \n" +
                    "LIMIT "+param.get("pageNumber")+", "+param.get("pageSize"));
        }

        System.out.println("queryPathList sql -> \n"+sql);
        
        return jdbcTemplate.queryForList(sql.toString());
    }
    
}
