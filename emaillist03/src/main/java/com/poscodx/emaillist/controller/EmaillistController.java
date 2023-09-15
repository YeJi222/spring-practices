package com.poscodx.emaillist.controller;

import com.poscodx.emaillist.vo.EmaillistVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.poscodx.emaillist.repository.EmaillistRepository;

@Controller
public class EmaillistController {
	@Autowired
	private EmaillistRepository emaillistRepository;

	@ResponseBody
	@RequestMapping("/")
	public String main() {
		System.out.println("test");
		return "ok!";
	}

	/*
	@RequestMapping("/")
	public String main(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);

		return "main";
	}
	 */

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(){
		System.out.println("test");
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmaillistVo vo){
		emaillistRepository.insert(vo);
		return "redirect:/";
	}

}
