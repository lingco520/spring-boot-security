package com.daqsoft.controller;

import com.daqsoft.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 测试controller
 * @author tanggm
 *
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model){
		Msg msg = new Msg("测试权限", "测试内容", "欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
		model.addAttribute("msg", msg);
		return "home";
	}
	@RequestMapping("/admin")
	public Object hello(){


	    return "hello admin";
	}
}
