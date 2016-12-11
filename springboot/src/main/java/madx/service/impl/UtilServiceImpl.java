package madx.service.impl;

import madx.dao.FixCodeDao;
import madx.entity.FixCodePO;
import madx.entity.Result;
import madx.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by A-mdx on 2016/12/11.
 */
@Service
public class UtilServiceImpl implements UtilService {
    
    @Autowired
    private FixCodeDao fixCodeDao;
    
    @Override
    public Result queryFixCode(Integer codeType) {
        Result result  = Result.getInstance();
        
        if (codeType == null){
            result.setMsg("参数 codeType 为空");
            result.setCode(Result.RESULT_PARAME_ERRROR);
            return result;
        }

        List<FixCodePO> list = fixCodeDao.findByCodeType(codeType);
        
        if (list.size() == 0){
            result.setMsg("没有查到数据");
            result.setCode(Result.RESULT_ERROR);
            return result;
        }
        
        result.setData(list);
        return result;
    }
    
}
