package kr.co.bit.handler;

import javax.servlet.http.HttpServletRequest;

public class viewRegistHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String url = "./mvc/regist_member.jsp";
		return url;
	
	}

}
