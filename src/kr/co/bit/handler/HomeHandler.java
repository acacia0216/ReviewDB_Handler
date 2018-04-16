package kr.co.bit.handler;

import javax.servlet.http.HttpServletRequest;

public class HomeHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
	
		String url = "./mvc/home.jsp";
		return url;
	}

}
