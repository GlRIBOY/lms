package kr.giri.example.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

import kr.giri.example.common.ViewResolve;
import kr.giri.example.member.service.MemberService;
import kr.giri.example.member.service.MemberVO;
import kr.giri.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberlogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();//세션객체사용
		String message = null;

		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));

		vo = dao.memberSelect(vo);

		if (vo != null) {
			session.setAttribute("id", vo.getMemberId());//세션에 아이디 이름 권한을 담음
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("author", vo.getMemberAuthor());
			request.setAttribute("message", vo.getMemberName()+"님 로그인");
		}else {
			request.setAttribute("message", "입력정보가 틀림");
		}
		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
