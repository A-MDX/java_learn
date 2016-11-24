package madx.dao;

import madx.entity.JavaFilePathPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by A-mdx on 2016/11/24.
 */
public interface JavaFilePathDao extends JpaRepository<JavaFilePathPO,Integer> {
    List<JavaFilePathPO> findByuserId(Integer userId);
}
