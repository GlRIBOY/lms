package kr.giri.example.notice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * Servlet implementation class AjaxReplyEdit
 */
@WebServlet("/AjaxReplyEdit.do")
public class AjaxReplyEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeId = request.getParameter("noticeId");
		String replyId = request.getParameter("replyId");
		String reply = request.getParameter("reply");
		String replyer = request.getParameter("replyer");
		Map<String, Object> map = new HashMap<>();
		
		ReplyVO vo = new ReplyVO();
		ReplyService service = new ReplyServiceImpl();
		vo.setNoticeId(Integer.parseInt(noticeId));
		vo.setNoticeId(Integer.parseInt(replyId));
		vo.setReply(reply);
		vo.setReplyer(replyer);
		
				
		if(service.editReply(vo)) {
			map.put("retCode", "Success");
			map.put("data", vo);
			
		} else {
			map.put("retCode", "Fail");
			map.put("data", "처리중 에러.");
			
		}
		
		Gson gson = new GsonBuilder().create();
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(map));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
