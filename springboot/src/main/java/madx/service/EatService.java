package madx.service;

import madx.entity.Result;

import java.util.Map;

/**
 * Created by A-mdx on 2016/12/26.
 */
public interface EatService {
    Result queryEatTypeList(Map<String, Object> param);

    Result modifyType(Map<String, Object> param);

    Result addType(Map<String, Object> param);

    Result modifyMemu(Map<String, Object> param);

    Result addMemu(Map<String, Object> param);

    Result resetType(Map<String, Object> param);

    Result findOneType(Map<String, Object> param);
}
