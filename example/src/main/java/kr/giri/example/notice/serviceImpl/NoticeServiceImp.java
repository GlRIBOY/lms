package kr.giri.example.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.giri.example.common.DataSources;
import kr.giri.example.notice.mapper.NoticeMapper;
import kr.giri.example.notice.service.NoticeService;
import kr.giri.example.notice.service.NoticeVO;

public class NoticeServiceImp implements NoticeService {
private SqlSession sqlSession = DataSources.getInstance().openSession(true);//마이바티스 연결해줘
private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);//노티스매퍼 쓸꺼야.
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}
	@Override
	public List<NoticeVO> noticeSelectList(String key, String val) {
		return map.noticeSelectList(key, val);
	}


	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		noticeUpdateHit(vo.getNoticeId());
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}
	@Override
	public void noticeUpdateHit(int id) {
		map.noticeUpdateHit(id);
	}

}
