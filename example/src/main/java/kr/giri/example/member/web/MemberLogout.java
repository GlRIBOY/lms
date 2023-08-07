package kr.giri.example.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.giri.example.common.ViewResolve;

@WebServlet("/memberlogout.do")
public class MemberLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		session.invalidate();//서버에 있는 세션객체를 완전히 삭제
		request.setAttribute("message", name + "님 로그아웃");
		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
