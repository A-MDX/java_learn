package madx.service;

import madx.entity.Result;

/**
 * Created by A-mdx on 2016/11/24.
 */
public interface CountJavaService {
    
    Result count(Integer userid);
    Result addPath(String path);
    Result removePath(Integer id);
    Result queryCountList(Integer userid);
    Result queryPathList(Integer userid);
    
}
