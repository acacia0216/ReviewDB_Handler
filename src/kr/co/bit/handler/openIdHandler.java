package kr.co.bit.handler;

import javax.servlet.http.HttpServletRequest;

public class openIdHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String url = "./mvc/id_check.jsp";
		return url;
		
	}
	

}
