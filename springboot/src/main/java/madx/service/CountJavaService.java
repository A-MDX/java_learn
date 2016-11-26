package madx.service;

import madx.entity.Result;

import java.util.Map;

/**
 * Created by A-mdx on 2016/11/24.
 */
public interface CountJavaService {
    
    Result count(Integer userid);
    Result addPath(String path);
    Result removePath(Integer id);
    Result queryCountList(Map<String,Object> param);
    Result queryPathList(Map<String,Object> param);
    
}
