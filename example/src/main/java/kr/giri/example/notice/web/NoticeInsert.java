package kr.giri.example.notice.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.giri.example.common.ViewResolve;
import kr.giri.example.notice.service.NoticeService;
import kr.giri.example.notice.service.NoticeVO;
import kr.giri.example.notice.serviceImpl.NoticeServiceImp;

@WebServlet("/noticeinsert.do")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeInsert() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImp();
		NoticeVO vo = new NoticeVO();
		String saveDir = getServletContext().getRealPath("attech/notice/");
		int sizeLimit = 100 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, saveDir, sizeLimit, "utf-8",
				new DefaultFileRenamePolicy());
		String originalFile = multi.getOriginalFileName("file");
		if (originalFile != null) {
			String fileName = multi.getFilesystemName("file");
			vo.setNoticeAttech(originalFile);
			vo.setNoticeAttechDir(saveDir + fileName);
		}
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));
		
		int n = dao.noticeInsert(vo);
		if(n==1) {
			request.setAttribute("message", "글 입력됨");
		}else {
			request.setAttribute("message", "글 입력되지않음");
		}
		
		String viewName = "notice/noticemessage";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
