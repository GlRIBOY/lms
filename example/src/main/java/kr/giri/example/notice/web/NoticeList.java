package kr.giri.example.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.giri.example.common.ViewResolve;
import kr.giri.example.notice.service.NoticeService;
import kr.giri.example.notice.service.NoticeVO;
import kr.giri.example.notice.serviceImpl.NoticeServiceImp;

@WebServlet("/noticelist.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImp();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		
		String viewName = "notice/noticelist";
		ViewResolve.forward(request, response, viewName);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
