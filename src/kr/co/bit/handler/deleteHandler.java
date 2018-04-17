package kr.co.bit.handler;

import javax.servlet.http.HttpServletRequest;

import kr.co.bit.dao.MemberDAO;

public class deleteHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		boolean flag = dao.delete(id);
		String url;
		if(flag) {
			url="./controller?cmd=searchAll.jsp";  
		}	else {
			url="./mvc/error.jsp";
		}
		return url;
	}

}
