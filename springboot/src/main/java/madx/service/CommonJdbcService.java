package madx.service;

import madx.common.JdbcCommonEnum;
import madx.dao.LineJdbcDao;
import madx.entity.PageQueryPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by A-mdx on 2016/12/1.
 */
@Service
public class CommonJdbcService {
    
    @Autowired
    private LineJdbcDao lineJdbcDao;

    private List<Map<String,Object>> selectMethod(JdbcCommonEnum jdbcEnum, Map<String,Object> param,
                                                  boolean isPage){
        switch (jdbcEnum){
            case JAVA_LINE_LIST:
                return lineJdbcDao.queryLineList(param,isPage);
            case JAVA_FILE_LIST:
                return lineJdbcDao.queryPathList(param,isPage);
        }
        return null;
    }
    
    public PageQueryPO query(JdbcCommonEnum jdbcEnum, Map<String,Object> param){
        
        List<Map<String,Object>> list = selectMethod(jdbcEnum,param,false);
        
        Long size = (Long) list.get(0).get("count");
        int totleSize = size == null ? 0 : Integer.valueOf(size+"");
        PageQueryPO pageQueryPO = new PageQueryPO((Integer) param.get("pageSize"),totleSize);
        int pageNumber = (int) param.get("pageNumber");
        if (pageNumber -1 < 0){
            pageNumber = 0;
        }else{
            pageNumber--;
        }
        pageQueryPO.setPageNumber(pageNumber+1);

        param.put("pageNumber",pageNumber);

        list = selectMethod(jdbcEnum,param,true);
        
        pageQueryPO.setContent(list);
        
        return pageQueryPO;
        
    }
    
}
