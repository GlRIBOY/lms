package kr.giri.example.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.giri.example.notice.service.NoticeService;
import kr.giri.example.notice.service.NoticeVO;
import kr.giri.example.notice.serviceImpl.NoticeServiceImp;

@WebServlet("/ajaxnoticesearch.do")
public class AjaxNoticeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxNoticeSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax를 이용해서 검색결과를 json으로 보내준다
		NoticeService dao = new NoticeServiceImp();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		notices = dao.noticeSelectList(key, val);
		
		ObjectMapper objectMapper = new ObjectMapper(); //json객체를 만들기위해 필요한 객체
		objectMapper.registerModule(new JavaTimeModule());//localdate처리
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);//localdate처리
		String data = objectMapper.writeValueAsString(notices);//json형태로 결과를 만들어줌
		
		response.setContentType("text/html; charset-UTF-8");
		response.getWriter().append(data);
		return;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
