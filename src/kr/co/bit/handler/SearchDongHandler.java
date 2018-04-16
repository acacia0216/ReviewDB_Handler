package kr.co.bit.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.co.bit.dao.ZipcodeDAO;
import kr.co.bit.vo.ZipcodeVO;

public class SearchDongHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub
			
			String dong = request.getParameter("dong");
	//		dong = new String(dong.getBytes("ISO-8859-1"),"UTF-8");  // 한글 처리하는 방법 2
			System.out.println(dong);
			ZipcodeDAO dao = new ZipcodeDAO();
			ArrayList<ZipcodeVO> list = null;
			list = dao.getSearchList(dong);
			request.setAttribute("list", list);
			String url= "./mvc/make_zipcode.jsp";
			
			return url;
	}

}
