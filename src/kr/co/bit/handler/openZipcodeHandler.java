package kr.co.bit.handler;

import javax.servlet.http.HttpServletRequest;

public class openZipcodeHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String url = "./mvc/make_zipcode.jsp";
		return url;
		
	}
	

}
