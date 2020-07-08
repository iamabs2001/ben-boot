package bencyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexRoute {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/add")
	public String adduser() {
		return "adduser";	
	}
	
//	@RequestMapping("/update")
//	public String updateuser() {
//		return "updateuser";	
//	}
	
	
}
