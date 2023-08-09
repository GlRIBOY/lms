package kr.giri.example.notice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.giri.example.common.ViewResolve;
import kr.giri.example.notice.service.NoticeService;
import kr.giri.example.notice.service.NoticeVO;
import kr.giri.example.notice.serviceImpl.NoticeServiceImp;

@WebServlet("/noticeeditform.do")
public class NoticeEditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeEditForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImp();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));//폼에서 넘어오는건 다 스트링이나 배열
		vo = dao.noticeSelect(vo);
		request.setAttribute("n", vo);
		String viewName = "notice/noticeeditform";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
