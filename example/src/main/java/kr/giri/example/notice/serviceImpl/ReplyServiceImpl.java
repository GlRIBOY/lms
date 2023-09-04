package kr.giri.example.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.giri.example.common.DataSources;
import kr.giri.example.notice.mapper.ReplyMapper;
import kr.giri.example.notice.service.ReplyService;
import kr.giri.example.notice.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	private SqlSession sqlSession = DataSources.getInstance().openSession(true);//마이바티스 연결해도
	private ReplyMapper map = sqlSession.getMapper(ReplyMapper.class); //멤버매퍼스 쓸거임
	@Override
	public boolean addReply(ReplyVO vo) {
		return map.insert(vo)==1;
	}

	@Override
	public boolean editReply(ReplyVO vo) {
		return map.update(vo)==1;
	}

	@Override
	public boolean delReply(int replyId) {
		return map.delete(replyId)==1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		return map.select(replyId);
	}

	@Override
	public List<ReplyVO> replyList(int noticeId) {
		return map.selectList(noticeId);
	}

}
