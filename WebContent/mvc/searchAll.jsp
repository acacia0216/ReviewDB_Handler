<%@page import="kr.co.bit.vo.MemberVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style type="text/css">

	#del{
		font-family: 'Daum_Regular'; 
	}

</style>

<body>
<%

	ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
	StringBuffer sb = new StringBuffer();
	for(MemberVO vo : list ) {
		
		sb.append( "<form action= './controller?cmd=delete&id=" + vo.getId() + "' method = 'post'>");
		sb.append(vo.getId());
		sb.append(" <a href='./controller?cmd=updatePage&id="+vo.getId()+"'>"+vo.getName()+"</a>");
		sb.append(" "+vo.getAddr1());
		sb.append(" <input type='submit' value= '삭제' id='del'></input> </form> <br>");

	}
	out.print(sb.toString());


%>
</body>
</html>
