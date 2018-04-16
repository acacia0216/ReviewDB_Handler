package kr.co.bit.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.vo.MemberVO;

public class SearchAllHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = null;
		list= dao.selectAll();
		request.setAttribute("list",list);
		String url="./mvc/searchAll.jsp";
		return url;
	}

}
