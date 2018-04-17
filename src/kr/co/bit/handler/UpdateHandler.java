package kr.co.bit.handler;

import javax.servlet.http.HttpServletRequest;

import kr.co.bit.dao.MemberDAO;
import kr.co.bit.vo.MemberVO;

public class UpdateHandler implements Command {

	@Override
	public String process(HttpServletRequest request) {
		// TODO Auto-generated method stub	
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String zip1 = request.getParameter("zip1");
		String zip2 = request.getParameter("zip2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String tool = request.getParameter("tool");
		String project = request.getParameter("project");
		String[] langs = request.getParameterValues("lang");
		/*String[] temp = {"","","",""};
		for(String index : langs){
			int idx = Integer.parseInt(index);
			temp[idx] = index;
		}*/
		//MemberVO 데이터 클래스를 만들어서 인스턴스를 하나 생성
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setEmail(email);
		vo.setZipcode(zip1+"-"+zip2);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setTool(tool);
		vo.setProject(project);
		vo.setLangs(langs);
			
		MemberDAO dao = new MemberDAO();
		String url;
		boolean flag = dao.update(vo);
			if(flag) {
				url="./controller?cmd=searchAll.jsp";  // 리스트를 다시 불러오는 과정이 필요하므로 컨트롤러를 거쳐 함수를 한번 시행해주고 페이지 이동해야한다. 리무브도 마찬가지
			}	else {
				url="./mvc/error.jsp";
			}
		request.setAttribute("message", "success");
		//response.sendRedirect("storage.jsp");
		return url;
	}

}
