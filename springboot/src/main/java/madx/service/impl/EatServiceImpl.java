package madx.service.impl;

import madx.dao.EatJdbcDao;
import madx.dao.EatMemuDao;
import madx.dao.EatTypeDao;
import madx.entity.Result;
import madx.service.CommonJdbcService;
import madx.service.EatService;
import madx.service.JdbcCommonEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by A-mdx on 2016/12/26.
 */
@Service
public class EatServiceImpl implements EatService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private EatJdbcDao eatJdbcDao;
    
    @Autowired
    private EatMemuDao eatMemuDao;
    
    @Autowired
    private EatTypeDao eatTypeDao;
    
    @Autowired
    private CommonJdbcService commonJdbcService;
    
    
    @Override
    public Result queryEatTypeList(Map<String, Object> param) {
        Result result = Result.getInstance();
        System.out.println("param -> "+param);
        try {
            Object data = commonJdbcService.query(JdbcCommonEnum.EAT_TYPE_LIST,param);
            result.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("jdbc查询报错。",e);
            result.setMsg("查询服务器报错");
            result.setCode(Result.RESULT_ERROR);
        }

        return result;
    }

    @Override
    public Result modifyType(Map<String, Object> param) {
        Result result = Result.getInstance();
        
        return result;
    }

    @Override
    public Result addType(Map<String, Object> param) {
        Result result = Result.getInstance();

        return result;
    }

    @Override
    public Result modifyMemu(Map<String, Object> param) {
        Result result = Result.getInstance();

        return result;
    }

    @Override
    public Result addMemu(Map<String, Object> param) {
        Result result = Result.getInstance();

        return result;
    }

}
