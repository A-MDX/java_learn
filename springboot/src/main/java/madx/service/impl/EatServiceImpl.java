package madx.service.impl;

import madx.common.Common;
import madx.dao.EatMemuDao;
import madx.dao.EatTypeDao;
import madx.entity.EatMemuPO;
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

        Object id = param.get("id");
        if (id == null || StringUtils.isBlank(id.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 id 这个参数");
            return result;
        }
        
        EatTypePO eatTypePO = eatTypeDao.findOne(Integer.valueOf(id.toString()));
        
        Object max_dian = param.get("max_dian");
        if (max_dian != null && StringUtils.isNotBlank(max_dian.toString())){
            Integer max_dian1 = Integer.valueOf(max_dian.toString());
            eatTypePO.setMaxDian(max_dian1);
            eatTypePO.setNowDian(max_dian1);
        }
        
        Object name = param.get("name");
        if (name != null && StringUtils.isNotBlank(name.toString())){
            eatTypePO.setName(name.toString());
        }
        
        Object now_dian = param.get("now_dian");
        if (now_dian != null && StringUtils.isNotBlank(now_dian.toString())){
            int now_dian1 = Integer.valueOf(now_dian.toString());
            if (now_dian1 > eatTypePO.getMaxDian()){
                result.setCode(Result.RESULT_PARAME_ERRROR);
                result.setMsg("传入的 now_dian:"+ now_dian+" 这个参数大于当前最大点数 ："+eatTypePO.getMaxDian());
                return result;
            }
            eatTypePO.setNowDian(now_dian1);
        }
        
        Object picture = param.get("picture");
        if (picture != null && StringUtils.isNotBlank(picture.toString())){
            eatTypePO.setPicture(picture.toString());
        }
        
        Object remark = param.get("remark");
        if (remark != null && StringUtils.isNotBlank(remark.toString())){
            eatTypePO.setRemark(remark.toString());
        }
        
        Object status = param.get("status");
        if (status != null && StringUtils.isNotBlank(status.toString())){
            eatTypePO.setStatus(Integer.valueOf(status.toString()));
        }
        
        eatTypePO.setModifyTime(new Date());
        eatTypePO.setModifier(1);
        
        eatTypePO = eatTypeDao.save(eatTypePO);
        
        result.setData(eatTypePO);
        
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

        eatTypePO.setModifyTime(new Date());
        eatTypePO.setModifier(1);
        
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
    public Result menuType(Map<String, Object> param) {
        Result result = Result.getInstance();

        try {
            result.setData(eatTypeDao.findIdAndName());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询 eatTypeDao.findIdAndName() 失败",e);
            result.setCode(Result.RESULT_ERROR);
            result.setMsg("系统异常了。");
            return result;
        }

        return result;
    }

    @Override
    public Result queryMenuList(Map<String, Object> param) {
        Result result = Result.getInstance();

        try {
            result.setData(commonJdbcService.query(JdbcCommonEnum.EAT_MEMU_LIST,param));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("jdbc查询报错。",e);
            result.setMsg("查询服务器报错");
            result.setCode(Result.RESULT_ERROR);
        }

        return result;
    }

    @Override
    public Result resetMenu(Map<String, Object> param) {
        Result result = Result.getInstance();

        Object id = param.get("id");
        if (id == null || StringUtils.isBlank(id.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 id 这个参数");
            return result;
        }

        EatMemuPO memuPO = eatMemuDao.findOne(Integer.valueOf(id+""));
        
        memuPO.setNowDian(memuPO.getMaxDian());
        memuPO.setModifier(1);
        memuPO.setModifyTime(new Date());
        
        eatMemuDao.save(memuPO);
        
        return result;
    }

    @Override
    public Result findOneMenu(Map<String, Object> param) {
        Result result = Result.getInstance();

        Object id = param.get("id");
        if (id == null || StringUtils.isBlank(id.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 id 这个参数");
            return result;
        }
        
        EatMemuPO memuPO = eatMemuDao.findOne(Integer.valueOf(id+""));
        if (memuPO == null){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("根据 id 这个参数"+id+" 没有找到实体。");
            return result;
        }
        
        result.setData(memuPO);
        
        return result;
    }


    @Override
    public Result modifyMemu(Map<String, Object> param) {
        Result result = Result.getInstance();
        
        Object id = param.get("id");
        if (id == null || StringUtils.isBlank(id.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 id 这个参数");
            return result;
        }

        EatMemuPO eatMemuPO = eatMemuDao.findOne(Integer.valueOf(id+""));
        if (eatMemuPO == null){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("根据 id 这个参数"+id+" 没有找到实体。");
            return result;
        }
        
        Object max_dian = param.get("max_dian");
        if (max_dian != null && StringUtils.isNotBlank(max_dian.toString())){
            Integer max_dian1 = Integer.valueOf(max_dian.toString());
            eatMemuPO.setMaxDian(max_dian1);
            eatMemuPO.setNowDian(max_dian1);
        }

        Object name = param.get("name");
        if (name != null && StringUtils.isNotBlank(name.toString())){
            eatMemuPO.setName(name.toString());
        }

        Object now_dian = param.get("now_dian");
        if (now_dian != null && StringUtils.isNotBlank(now_dian.toString())){
            int now_dian1 = Integer.valueOf(now_dian.toString());
            if (now_dian1 > eatMemuPO.getMaxDian()){
                result.setCode(Result.RESULT_PARAME_ERRROR);
                result.setMsg("传入的 now_dian:"+ now_dian+" 这个参数大于当前最大点数："+eatMemuPO.getMaxDian());
                return result;
            }
            eatMemuPO.setNowDian(now_dian1);
        }

        Object picture = param.get("picture");
        if (picture != null && StringUtils.isNotBlank(picture.toString())){
            eatMemuPO.setPicture(picture.toString());
        }

        Object remark = param.get("remark");
        if (remark != null && StringUtils.isNotBlank(remark.toString())){
            eatMemuPO.setRemark(remark.toString());
        }
        
        Object address = param.get("address");
        if (address != null && StringUtils.isNotBlank(address.toString())){
            eatMemuPO.setAddress(address.toString());
        }
        
        Object type = param.get("type");
        if (type != null && StringUtils.isNotBlank(type.toString())){

            int type_ = 0;
            try {
                type_ = Integer.valueOf(type.toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                logger.error("传入的 type:"+ type+" 这个参数格式异常。",e);
                result.setCode(Result.RESULT_PARAME_ERRROR);
                result.setMsg("传入的 type:"+ type+" 这个参数格式异常。");
                return result;
            }

            EatTypePO typePO = eatTypeDao.findOne(type_);
            if (typePO == null){
                result.setCode(Result.RESULT_PARAME_ERRROR);
                result.setMsg("传入的 type:"+ type+" 这个参数没有找到对应类型。");
                return result;
            }
            eatMemuPO.setType(type_);
        }

        Object status = param.get("status");
        if (status != null && StringUtils.isNotBlank(status.toString())){
            eatMemuPO.setStatus(Integer.valueOf(status.toString()));
        }

        eatMemuPO.setModifyTime(new Date());
        eatMemuPO.setModifier(1);
        
        eatMemuPO = eatMemuDao.save(eatMemuPO);
        result.setData(eatMemuPO);
        
        return result;
    }

    @Override
    public Result addMemu(Map<String, Object> param) {
        Result result = Result.getInstance();
        System.out.println("param --> "+param);
        
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
        Object type = param.get("type");
        if (type == null || StringUtils.isBlank(type.toString())){
            result.setCode(Result.RESULT_PARAME_ERRROR);
            result.setMsg("没传 type 这个参数");
            return result;
        }
        
        EatMemuPO eatMemuPO = new EatMemuPO();
        
        eatMemuPO.setType(Integer.valueOf(type.toString()));
        eatMemuPO.setName(name.toString());
        eatMemuPO.setMaxDian(Integer.valueOf(max_dian.toString()));
        eatMemuPO.setNowDian(eatMemuPO.getMaxDian());
        eatMemuPO.setStatus(Common.STATUS_YES);
        eatMemuPO.setCreator(1);
        eatMemuPO.setCreationTime(new Date());
       
        Object picture = param.get("picture");
        if (picture != null && StringUtils.isNotBlank(picture.toString())){
            eatMemuPO.setPicture(picture.toString());
        }

        Object remark = param.get("remark");
        if (remark != null && StringUtils.isNotBlank(remark.toString())){
            eatMemuPO.setRemark(remark.toString());
        }

        Object address = param.get("address");
        if (address != null && StringUtils.isNotBlank(address.toString())){
            eatMemuPO.setAddress(address.toString());
        }
        
        eatMemuPO = eatMemuDao.save(eatMemuPO);
        
        result.setData(eatMemuPO);
        
        return result;
    }
    
}
