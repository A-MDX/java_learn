package madx.dao;

import madx.entity.FixCodePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by A-mdx on 2016/12/1.
 */
public interface FixCodeDao extends JpaRepository<FixCodePO,Integer> {
    
}
