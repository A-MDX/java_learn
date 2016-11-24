package madx.dao;

import madx.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by A-mdx on 2016/11/24.
 */
public interface UserDao extends JpaRepository<UserPO,Integer> {
    
}
