package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.MemberVO;


@Repository("MemberDaoMybatis")
public class MemberDaoMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberDaoMybatis() {
	}
	
	//멤버 불러오기
	public List<MemberVO> getAllMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.getAllMember", vo);
	}
	
	//멤버 1명 불러오기
	public MemberVO getOneMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getOneMember", vo);
	}
	
	//수정, 삭제 멤버 불러오기
	public List<MemberVO> getMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.getMember", vo);
	}
	
	//부서 불러오기
	public List<MemberVO> getDepart(MemberVO vo) {
		return mybatis.selectList("MemberDAO.getDepart", vo);
	}
	
	//직급 불러오기
	public List<MemberVO> getRoles(MemberVO vo) {
		return mybatis.selectList("MemberDAO.getRoles", vo);
	}
	
	//전체보기 -> 검색
	public List<MemberVO> searchAllMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.searchAllMember", vo);
	}
	
	//멤버추가 -> 검색
	public List<MemberVO> searchAddMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.searchAddMember", vo);
	}
	
	//멤버추가 -> 불러오기
	public List<MemberVO> selectMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.selectMember", vo);
	}
	
	//멤버수정 -> 검색
	public List<MemberVO> searchUpMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.searchUpMember", vo);
	}
	
	//멤버삭제 -> 검색
	public List<MemberVO> searchDelMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.searchDelMember", vo);
	}
	
	//멤버삭제
	public int deleteMember(MemberVO vo) {
		return mybatis.delete("MemberDAO.deleteMember", vo);
	}
	//멤버수정
	public int updateMember(MemberVO vo) {
		return mybatis.update("MemberDAO.updateMember", vo);
	}
	//멤버추가
	public int insertMember(MemberVO vo) {
		return mybatis.insert("MemberDAO.insertMember", vo);
	}

	

	
	
	
}
