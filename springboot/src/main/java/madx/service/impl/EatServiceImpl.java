package madx.service.impl;

import madx.dao.EatJdbcDao;
import madx.dao.EatMemuDao;
import madx.dao.EatTypeDao;
import madx.entity.Result;
import madx.service.EatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by A-mdx on 2016/12/26.
 */
@Service
public class EatServiceImpl implements EatService{
    
    @Autowired
    private EatJdbcDao eatJdbcDao;
    
    @Autowired
    private EatMemuDao eatMemuDao;
    
    @Autowired
    private EatTypeDao eatTypeDao;
    
    
    @Override
    public Result queryEatTypeList(Map<String, Object> param) {
        Result result = Result.getInstance();
        
        
        return result;
    }
}
