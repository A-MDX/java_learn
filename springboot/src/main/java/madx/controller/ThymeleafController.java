package madx.controller;

import madx.entity.Result;
import madx.service.CountJavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 练习百里香 themy leaf
 * Created by A-mdx on 2017/3/24.
 */
@Controller
@RequestMapping("/thyme")
public class ThymeleafController {

	@Autowired
	private CountJavaService countJavaService;
	
	@RequestMapping("hello")
	public String hello(Model model){
		model.addAttribute("name","Mr.ma");
		return "hello";
	}
	
	@RequestMapping("line")
	public String line(Model model){
		
		Map<String,Object> param = new HashMap<>();
		param.put("pageNumber", 1);
		param.put("pageSize",20);
		Result result = countJavaService.queryCountList(param);
		model.addAttribute("name", "Madx");
		model.addAttribute("result", result);
		return "line";
	}
	
}
