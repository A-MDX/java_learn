package madx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by A-mdx on 2016/11/8.
 */
@Controller
public class PageController {
    
    @Value("${application.hello:E,No found}")
    private String hello;

    /**
     * - @RequestMapping("/") 和 @RequestMapping 是有区别的
     * 如果不写参数，则为全局默认页，假如输入404页面，也会自动访问到这个页面。
     * 如果加了参数“/”，则只认为是根页面。
     */
    @RequestMapping(value = "/")
    public String index(Map<String,Object> model){

        System.out.println("come here?");
        
        model.put("time", new Date());
        model.put("message", this.hello);
        System.out.println(model);
        return "redirect:index.html";
    }
    
    @RequestMapping(value = "/test",method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody String test(ServletRequest request){
        System.out.println("request --> "+request.getParameterMap());
        
        System.out.println(request.getParameterNames());
        System.out.println("request.getContentType(); -> " +request.getContentType());
        System.out.println("requ  "+request);
        System.out.println(request.getParameter("startPhone"));
        return "123456";
    }

    
}
