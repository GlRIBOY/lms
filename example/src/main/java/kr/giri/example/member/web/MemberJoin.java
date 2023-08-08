package kr.giri.example.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.giri.example.common.ViewResolve;
import kr.giri.example.member.service.MemberService;
import kr.giri.example.member.service.MemberVO;
import kr.giri.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberjoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberJoin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일업로드 및 데이터 관리한다
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		String saveDir = getServletContext().getRealPath("attech/member/");// 리눅스 유닉스 / , 윈도우 ￦
		int sizeLimit = 100 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, sizeLimit, "utf-8",
				new DefaultFileRenamePolicy());
		
		String originalFileName = multi.getOriginalFileName("file");
		
		if (originalFileName != null) {
			String fileName = multi.getFilesystemName("file"); // 물리적 위치에 저장 => saveDir에
			vo.setMemberImg(fileName);
		}
		vo.setMemberId(multi.getParameter("memberId"));
		vo.setMemberPassword(multi.getParameter("memberPassword"));
		vo.setMemberName(multi.getParameter("memberName"));
		vo.setMemberTel(multi.getParameter("memberTel"));
		vo.setMemberAddress(multi.getParameter("memberAddress"));

		int n = dao.memberInsert(vo);
		if (n != 0) {
			request.setAttribute("message", "회원가입되었음");
		} else {
			request.setAttribute("message", "가입실패");
		}
		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);

	}

//파일업로드 => enctype = "multipart/form-data"
	// cos라이브러리 => 쉬움
	// common-fileupload => 가장많이쓴다
	// servlet 3.0 => part 객체를 이용하는 방법/ servlet part객체 라고 검색하면나옴
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
