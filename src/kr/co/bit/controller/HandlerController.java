package kr.co.bit.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.handler.Command;

public class HandlerController extends HttpServlet{
	
	private HashMap<String, Command> map;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String,Command>();
		String path = getServletContext().getRealPath("WEB-INF/file/commandList.txt");
		File file = new File(path);
		String line = null;
		FileReader fr =null;
		BufferedReader br =null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while((line=br.readLine())!=null) {  // commandList에 있는 키-밸류 값을 읽어내어 맵핑 해준다.
				System.out.println(line);
				String[] temp = line.split("=");
				Object obj = Class.forName(temp[1]).newInstance();   // Class.forName(클래스 네임)
				Command cmd = (Command) obj ;
				map.put(temp[0], cmd);     // (키,밸류) key-value(class) 맵핑   
						
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		}
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		String url = request.getServletPath();   // request.getRequestURI();   //프로젝트경로부터 파일까지의 경로값을 얻어옴 (/test/index.jsp)
													/*	request.getContextPath();  //프로젝트의 경로값만 가져옴(/test)
												
														request.getRequestURL();  //전체 경로를 가져옴 (http://localhost:8080/test/index.jsp)
														request.getServletPath();  //파일명 (/index.jsp)
												*/
		System.out.println("in "+url);
		Command cmd =map.get(url);
		String toUrl ="";
		if(cmd==null) {
			toUrl = "./home.do";
		} else {
		    toUrl = cmd.process(request);
		}
	
		 //request 영역을 process 메소드로 공유해준다. process 메소드에서 작업한 set 은 controller 페이지의 request와 공유된다.(당연) , 다음 이동할 페이지의 url을 리턴 받아온다.
		RequestDispatcher rd = request.getRequestDispatcher(toUrl);
		rd.forward(request, resp);
		
		
		
	}

}
