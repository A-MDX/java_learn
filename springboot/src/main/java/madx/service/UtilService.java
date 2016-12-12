package madx.service;

import madx.entity.Result;

/**
 * Created by A-mdx on 2016/12/11.
 */
public interface UtilService {
    Result queryFixCode(Integer codeType);

    Result queryUser();
}
