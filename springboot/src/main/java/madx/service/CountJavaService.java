package madx.service;

import madx.entity.Result;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * Created by A-mdx on 2016/11/24.
 */
public interface CountJavaService {
    
    Result count(ServletRequest request);
    Result addPath(ServletRequest request);
    Result removePath(Integer id);
    Result queryCountList(Map<String,Object> param);
    Result queryPathList(Map<String,Object> param);
    
}
