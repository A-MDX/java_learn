package madx.controller;

import madx.common.Common;
import madx.entity.Result;
import madx.service.EatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * Created by A-mdx on 2016/12/26.
 */
@RestController
@RequestMapping("/eat")
public class EatController {
    @Autowired
    private EatService eatService;
    
    @RequestMapping(value = "/memu/list",method = RequestMethod.POST)
    public Result queryMemuList(ServletRequest request){
        return eatService.queryEatTypeList(Common.getParametersStartingWith(request,"search_"));
    }

    @RequestMapping(value = "/type/list",method = RequestMethod.POST)
    public Result queryTypeList(ServletRequest request){
        return eatService.queryEatTypeList(Common.getParametersStartingWith(request,"search_"));
    }
    
}
