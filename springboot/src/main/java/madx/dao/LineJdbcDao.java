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
    
}
