package kr.giri.example.notice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.giri.example.member.serviceImpl.ReplyServiceImpl;
import kr.giri.example.notice.service.ReplyService;
import kr.giri.example.notice.service.ReplyVO;

/**
 * Servlet implementation class AjaxReplyList
 */
@WebServlet("/AjaxReplyList.do")
public class AjaxReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("noticeId");
		ReplyService service = new ReplyServiceImpl();
		List<ReplyVO> list=service.replyList(Integer.parseInt(nid));
		
		Gson gson = new GsonBuilder().create();
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(gson.toJson(list));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
