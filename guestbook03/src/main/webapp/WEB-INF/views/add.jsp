<%@page import="com.poscodx.guestbook.vo.GuestBookVo"%>
<%@page import="com.poscodx.guestbook.repository.GuestBookRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String contents = request.getParameter("message");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(contents);
	
	new GuestBookRepository().insert(vo);
	
	response.sendRedirect("/guestbook02");
%>