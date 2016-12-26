package madx.service;

import madx.entity.Result;

import java.util.Map;

/**
 * Created by A-mdx on 2016/12/26.
 */
public interface EatService {
    Result queryEatTypeList(Map<String, Object> param);
    
}
