package madx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = {"/","/index"})
    public String index(Map<String,Object> model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp

        System.out.println("come here?");
        
        model.put("time", new Date());
        model.put("message", this.hello);
        System.out.println(model);
        return "redirect:index.html";
    }

    @RequestMapping("/page0")
    public String page0(){
        return "redirect:https://www.baidu.com/";
    }
    
    @RequestMapping("/page1")
    public ModelAndView page1(){
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        ModelAndView view = new ModelAndView("page/page1");
        view.addObject("content",this.hello);
        return view;
    }

    @RequestMapping("/page2")
    public String page2(Model model){
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        model.addAttribute("content", hello + "（第二种）");
        return "page/page1";
    }
    
}
