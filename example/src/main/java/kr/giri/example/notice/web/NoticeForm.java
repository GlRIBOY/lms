package kr.giri.example.notice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.giri.example.common.ViewResolve;

@WebServlet("/noticeform.do")
public class NoticeForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vireName = "notice/noticeinsert";
		ViewResolve.forward(request, response, vireName);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
