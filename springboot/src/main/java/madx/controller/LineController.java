package madx.controller;

import madx.entity.Result;
import madx.service.CountJavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by A-mdx on 2016/11/26.
 */
@RestController
@RequestMapping("line")
public class LineController {
    
    @Autowired
    private CountJavaService countJavaService;
    
    @RequestMapping(value = "/line/list",method = RequestMethod.POST)
    public Result getLineList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                              @RequestParam(value = "page.size", defaultValue = "20") int pageSize,
                              ServletRequest request){

        Map<String,Object> param = new HashMap<>();
        param.put("userid",request.getParameter("userid"));
        param.put("pageNumber",pageNumber);
        param.put("pageSize",pageSize);
        
        return countJavaService.queryCountList(param);
    }
    
    
}
