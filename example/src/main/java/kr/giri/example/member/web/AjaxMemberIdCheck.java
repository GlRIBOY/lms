package kr.giri.example.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.giri.example.member.service.MemberService;
import kr.giri.example.member.service.MemberVO;
import kr.giri.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/ajaxmemberidcheck.do")
public class AjaxMemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxMemberIdCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));

		vo = dao.memberSelect(vo);
		String txt = "yes"; //사용가능한아이디
		if (vo != null) {
			txt = "no";//사용불가한아이디
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(txt);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
