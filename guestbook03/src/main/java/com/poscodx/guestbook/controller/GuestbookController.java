package com.poscodx.guestbook.controller;

import com.poscodx.guestbook.repository.GuestBookRepository;
import com.poscodx.guestbook.vo.GuestBookVo;
import java.util.List;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestbookController extends HttpServlet {
	@Autowired
	private GuestBookRepository guestBookRepository;

	@RequestMapping("/")
	public String main(Model model){
		List<GuestBookVo> list = guestBookRepository.findAll();
		model.addAttribute("list", list);

		System.out.println(list);

		return "index"; // index.jsp
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(){
		System.out.println("add test");
		return "add"; // add.jsp
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GuestBookVo vo){
		System.out.println("GuestBookController.join(): GuestBookDao.insert(" + vo + ")");
		
		System.out.println("add post");
		
		guestBookRepository.insert(vo);
		return "redirect:/"; 
	}
}
