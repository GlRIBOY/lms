package kr.giri.example.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.giri.example.common.DataSources;
import kr.giri.example.member.mapper.MemberMapper;
import kr.giri.example.member.service.MemberService;
import kr.giri.example.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
private SqlSession sqlSession = DataSources.getInstance().openSession(true);//마이바티스 연결해도
private MemberMapper map = sqlSession.getMapper(MemberMapper.class); //멤버매퍼스 쓸거임
	@Override
	public List<MemberVO> memberSelectList() {
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		
		return map.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		
		return map.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		
		return map.memberDelete(vo);
	}

}
