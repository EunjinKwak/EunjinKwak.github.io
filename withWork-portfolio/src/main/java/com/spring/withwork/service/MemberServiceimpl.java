package com.spring.withwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.withwork.dao.MemberDaoMybatis;
import com.spring.withwork.vo.MemberVO;

@Service("memberService")
public class MemberServiceimpl implements MemberService {

	@Autowired
	private MemberDaoMybatis memberDAO;
	
	public MemberServiceimpl() {
	}

	@Override
	public int insertMember(MemberVO vo) {
		return memberDAO.insertMember(vo);
		
	}

	@Override
	public int updateMember(MemberVO vo) {
		return memberDAO.updateMember(vo);
		
	}

	@Override
	public int deleteMember(MemberVO vo) {
		return memberDAO.deleteMember(vo);
	}
	
	@Override
	public List<MemberVO> getAllMember(MemberVO vo) {
		return  memberDAO.getAllMember(vo);
	}
	
	@Override
	public MemberVO getOneMember(MemberVO vo) {
		return  memberDAO.getOneMember(vo);
	}
	
	@Override
	public List<MemberVO> getMember(MemberVO vo) {
		return  memberDAO.getMember(vo);
	}
	
	@Override
	public List<MemberVO> getDepart(MemberVO vo) {
		return  memberDAO.getDepart(vo);
	}

	@Override
	public List<MemberVO> searchAddMember(MemberVO vo) {
		return  memberDAO.searchAddMember(vo);
	}

	@Override
	public List<MemberVO> searchUpMember(MemberVO vo) {
		return  memberDAO.searchUpMember(vo);
	}
	
	@Override
	public List<MemberVO> searchDelMember(MemberVO vo) {
		return  memberDAO.searchDelMember(vo);
	}

	@Override
	public List<MemberVO> searchAllMember(MemberVO vo) {
		return  memberDAO.searchAllMember(vo);
	}

	@Override
	public List<MemberVO> selectMember(MemberVO vo) {
		return  memberDAO.selectMember(vo);
		
	}

	@Override
	public List<MemberVO> getRoles(MemberVO vo) {
		return  memberDAO.getRoles(vo);
	}


	
}
