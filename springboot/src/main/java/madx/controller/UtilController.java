package madx.controller;

import madx.entity.Result;
import madx.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by A-mdx on 2016/12/11.
 */
@RestController
@RequestMapping("/util")
public class UtilController {
    
    @Autowired
    private UtilService utilService;
    
    @RequestMapping(value = "/fixCode",method = RequestMethod.GET)
    public Result queryFixCode(int codeType){
        return utilService.queryFixCode(codeType);
    }
    
}
