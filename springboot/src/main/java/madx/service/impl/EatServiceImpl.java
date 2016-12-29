package madx.service.impl;

import madx.common.Common;
import madx.dao.EatJdbcDao;
import madx.dao.EatMemuDao;
import madx.dao.EatTypeDao;
import madx.entity.EatTypePO;
import madx.entity.Result;
import madx.service.CommonJdbcService;
import madx.service.EatService;
import madx.service.JdbcCommonEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        
        Object name = param.get("name");
        if (name == null || StringUtils.isBlank(name.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 name 这个参数");
            return result;
        }
        Object max_dian = param.get("max_dian");
        if (max_dian == null || StringUtils.isBlank(max_dian.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 max_dian 这个参数");
            return result;
        }

        EatTypePO eatTypePO = new EatTypePO();
        eatTypePO.setStatus(Common.STATUS_YES);
        eatTypePO.setName(name.toString());
        Integer dian = Integer.valueOf(max_dian.toString());
        eatTypePO.setMaxDian(dian);
        eatTypePO.setNowDian(dian);
        eatTypePO.setCreator(1);
        eatTypePO.setCreationTime(new Date());
        Object remark = param.get("remark");
        if (remark != null && StringUtils.isNotBlank(remark.toString())){
            eatTypePO.setRemark(remark.toString());
        }
        Object picture = param.get("picture");
        if (picture != null && StringUtils.isNotBlank(picture.toString())){
            eatTypePO.setPicture(picture.toString());
        }
        eatTypePO = eatTypeDao.save(eatTypePO);
        result.setData(eatTypePO);
        return result;
    }

    @Override
    public Result resetType(Map<String, Object> param) {
        Result result = Result.getInstance();
        Object id = param.get("id");
        if (id == null || StringUtils.isBlank(id.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 id 这个参数");
            return result;
        }
        
        EatTypePO eatTypePO = eatTypeDao.findOne(Integer.valueOf(id.toString()));
        eatTypePO.setNowDian(eatTypePO.getMaxDian());
        
        eatTypeDao.save(eatTypePO);
        return result;
    }

    @Override
    public Result findOneType(Map<String, Object> param) {
        Result result = Result.getInstance();
        
        Object id = param.get("id");
        if (id == null || StringUtils.isBlank(id.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 id 这个参数");
            return result;
        }

        EatTypePO eatTypePO = eatTypeDao.findOne(Integer.valueOf(id.toString()));
        
        if (eatTypePO == null){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没有根据当前 id :"+id+" ,找到对应的数据。");
            return result;
        }
        
        result.setData(eatTypePO);
        
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
