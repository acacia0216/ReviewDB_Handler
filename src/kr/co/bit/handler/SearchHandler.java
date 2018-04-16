package kr.co.bit.handler;


import javax.servlet.http.HttpServletRequest;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.vo.MemberVO;

public class SearchHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		MemberVO vo = dao.selectCondition(id);
		request.setAttribute("vo",vo);
		String url="./mvc/regist_member.jsp";
		return url;
	}

}
