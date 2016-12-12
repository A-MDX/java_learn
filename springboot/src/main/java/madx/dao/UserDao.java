package madx.dao;

import madx.entity.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by A-mdx on 2016/11/24.
 */
public interface UserDao extends JpaRepository<UserPO,Integer> {
    
    @Query("select u.id,u.name from UserPO u")
    List<Object[]> queryUserName();
    
}
