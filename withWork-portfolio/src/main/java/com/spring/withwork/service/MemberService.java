package com.spring.withwork.service;


import java.util.List;

import com.spring.withwork.vo.MemberVO;

public interface MemberService {
	int insertMember(MemberVO vo);
	int updateMember(MemberVO vo);
	int deleteMember(MemberVO vo);
	List<MemberVO> getAllMember(MemberVO vo);
	MemberVO getOneMember(MemberVO vo);
	List<MemberVO> getMember(MemberVO vo);
	List<MemberVO> getDepart(MemberVO vo);
	List<MemberVO> getRoles(MemberVO vo);
	List<MemberVO> searchAllMember(MemberVO vo);
	List<MemberVO> searchAddMember(MemberVO vo);
	List<MemberVO> selectMember(MemberVO vo);
	List<MemberVO> searchUpMember(MemberVO vo);
	List<MemberVO> searchDelMember(MemberVO vo);
	
	
}
