package kr.co.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.dao.ZipcodeDAO;
import kr.co.bit.vo.MemberVO;
import kr.co.bit.vo.ZipcodeVO;

public class CommandController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override					//request는 누가 넣어주는가? default값이 무엇인가? 혹시 null은 아닌가?
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		cmd= cmd==null?cmd="":cmd;
		String url = "./mvc/home.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, resp);
	}


}
