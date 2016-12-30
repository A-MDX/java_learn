package madx.dao;

import madx.entity.EatTypePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by A-mdx on 2016/12/26.
 */
public interface EatTypeDao extends JpaRepository<EatTypePO,Integer> {

    @Query("select t.id,t.name from EatTypePO t")
    List<Object[]> findIdAndName();
}
