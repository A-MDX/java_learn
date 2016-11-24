package madx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by A-mdx on 2016/11/6.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @RequestMapping
    public String hello(ServletRequest request){
        request.getParameterMap();
        return "Hello,String boot!";
    }
    
    @RequestMapping("/info")
    public Map<String,String> getInfo(String name){
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        return map;
    }
    
}
