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

import kr.giri.example.notice.service.ReplyService;
import kr.giri.example.notice.service.ReplyVO;
import kr.giri.example.notice.serviceImpl.ReplyServiceImpl;

/**
 * Servlet implementation class AjaxReplyAdd
 */
@WebServlet("/AjaxReplyAdd.do")
public class AjaxReplyAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeId = request.getParameter("noticeId");
		String reply = request.getParameter("reply");
		String replyer = request.getParameter("replyer");
		
		ReplyVO vo = new ReplyVO();
		vo.setNoticeId(Integer.parseInt(noticeId));
		vo.setReply(reply);
		vo.setReplyer(replyer);
		
		ReplyService service = new ReplyServiceImpl();
		
		Map<String, Object> map = new HashMap<>();
		if(service.addReply(vo)) {
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
