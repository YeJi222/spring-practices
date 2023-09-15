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


	/* http://localhost:8080/emaillist03/
	@ResponseBody
	@RequestMapping("/")
	public String main() {
		System.out.println("test");
		return "ok!";
	}
	 */

	// http://localhost:8080/emaillist03/
	@RequestMapping("/")
	public String main(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);

		return "main"; // main.jsp
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(){
		return "add"; // add.jsp
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmaillistVo vo){
		emaillistRepository.insert(vo);
		return "redirect:/"; // go to main.jsp
	}

}
