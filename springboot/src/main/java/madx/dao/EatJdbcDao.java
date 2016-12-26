package madx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by A-mdx on 2016/12/26.
 */
@Component
public class EatJdbcDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
}
