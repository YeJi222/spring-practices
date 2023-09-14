package com.poscodx.hellospring.controller;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	@RequestMapping("/hello2")
	public String hello2(String name) {
		// 경로 : http://localhost:8080/hellospring/hello2?name=yeji
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello3")
	public ModelAndView hello3(String n) {
		// 경로 : http://localhost:8080/hellospring/hello3?n=yeji

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		mav.addObject("name", n);

		return mav;
	}

	@RequestMapping("/hello4")
	public String hello4(String n, Model model) {
		// 경로 : http://localhost:8080/hellospring/hello4?n=yeji

		model.addAttribute("name", n);
		return "/WEB-INF/views/hello3.jsp";
	}

	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>Hello Spring</h1>";
	}

	@RequestMapping("/hello6")
	public String hello6() {
		return "redirect:/hello";
	}

	// 스프링에선 이러지말기 ..!
	@ResponseBody
	@RequestMapping("/hello7")
	public void hello7(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
		String name = request.getParameter("n");
		out.write("hello " + name);
	}
}
/*
	경로 : http://localhost:8080/hellospring/hello
*/