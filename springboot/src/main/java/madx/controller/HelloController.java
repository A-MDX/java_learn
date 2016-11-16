package madx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by A-mdx on 2016/11/6.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @RequestMapping
    public String hello(HttpServletRequest request){
        Map<String,String[]> map = request.getParameterMap();
        
        return "Hello,String boot!";
    }
    
    @RequestMapping("/info")
    public Map<String,String> getInfo(String name){
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        return map;
    }

    @RequestMapping("/list")
    public List<Map<String, String>> getList() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 1; i <= 5; i++) {
            map = new HashMap<>();
            map.put("name", "Shanhy-" + i);
            list.add(map);
        }
        return list;
    }
    
}
