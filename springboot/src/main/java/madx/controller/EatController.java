package madx.controller;

import madx.common.Common;
import madx.entity.Result;
import madx.service.EatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * Created by A-mdx on 2016/12/26.
 */
@RestController
@RequestMapping("/eat")
public class EatController {
    @Autowired
    private EatService eatService;
    
    @RequestMapping(value = "/menu/list",method = RequestMethod.POST)
    public Result queryMemuList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                @RequestParam(value = "page.size", defaultValue = "20") int pageSize,
                                ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"search_");
        param.put("pageNumber",pageNumber);
        param.put("pageSize",pageSize);
        return eatService.queryMenuList(param);
    }

    @RequestMapping(value = "/menu/modify",method = RequestMethod.POST)
    public Result modifyMemu(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"modify_");
        return eatService.modifyMemu(param);
    }

    @RequestMapping(value = "/menu/add",method = RequestMethod.POST)
    public Result addMemu(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"search_");
        return eatService.addMemu(param);
    }
    
    @RequestMapping(value = "/menu/one",method = RequestMethod.POST)
    public Result findOneMenu(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"");
        return eatService.findOneMenu(param);
    }

    @RequestMapping(value = "/menu/reset",method = RequestMethod.POST)
    public Result resetMenu(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"");
        return eatService.resetMenu(param);
    }
    
    @RequestMapping(value = "/menu/type",method = RequestMethod.POST)
    public Result menuType(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"search_");
        return eatService.menuType(param);
    }

    @RequestMapping(value = "/type/list",method = RequestMethod.POST)
    public Result queryTypeList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                @RequestParam(value = "page.size", defaultValue = "20") int pageSize,
                                ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"search_");
        param.put("pageNumber",pageNumber);
        param.put("pageSize",pageSize);
        return eatService.queryEatTypeList(param);
    }
    
    @RequestMapping(value = "/type/modify",method = RequestMethod.POST)
    public Result modifyType(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"modify_");
        return eatService.modifyType(param);
    }

    @RequestMapping(value = "/type/add",method = RequestMethod.POST)
    public Result addType(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"add_");
        return eatService.addType(param);
    }

    @RequestMapping(value = "/type/reset",method = RequestMethod.POST)
    public Result resetType(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"");
        return eatService.resetType(param);
    }

    @RequestMapping(value = "/type/one",method = RequestMethod.POST)
    public Result findOneType(ServletRequest request){
        Map<String,Object> param = Common.getParametersStartingWith(request,"");
        return eatService.findOneType(param);
    }
    
}
