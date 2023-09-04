package kr.giri.example.common;

import kr.giri.example.notice.service.ReplyService;
import kr.giri.example.notice.service.ReplyVO;
import kr.giri.example.notice.serviceImpl.ReplyServiceImpl;

public class MainExe {

	public static void main(String[] args) {
		ReplyService service = new ReplyServiceImpl();
		ReplyVO reply = new ReplyVO();
		reply.setNoticeId(6);
		reply.setReply("니똥굵다");
		reply.setReplyer("user1");
		service.addReply(reply);
		
		service.replyList(6).forEach((vo) -> {

			
		});

	}

}
