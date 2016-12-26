package madx.dao;

import madx.entity.EatTypePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by A-mdx on 2016/12/26.
 */
public interface EatTypeDao extends JpaRepository<EatTypePO,Integer> {
    
}
