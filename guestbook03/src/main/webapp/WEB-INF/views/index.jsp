<%@page import="com.poscodx.guestbook.vo.GuestBookVo"%>
<%@page import="com.poscodx.guestbook.repository.GuestBookRepository"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<html>
<head>
<title>방명록</title>
</head>
<body>
	<form action="/guestbook03/add" method="post">
		<input type="hidden" name="a" value="add">
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>

	<%
		int idx = 1;
		for(GuestBookVo vo : list){
	%>
		<br>
		<table width=510 border=1>
			<tr>
				<td>[<%=idx++ %>]</td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getReg_date() %></td>
				<td><a href="/guestbook02/gb?a=deleteform&no=<%=vo.getNo() %>">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4><%=vo.getContents() %></td>
			</tr>
		</table>
	<%
		}
	%>
	
	
</body>
</html>