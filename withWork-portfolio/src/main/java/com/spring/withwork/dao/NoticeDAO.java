package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.NoticeVO;
import com.spring.withwork.vo.ProjectVO;

@Repository("NoticeDAO")
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public NoticeDAO() {
	}
	
	public int insertNotice(NoticeVO vo) {
		return mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	public int insertMessenger(NoticeVO vo) {
		return mybatis.insert("NoticeDAO.insertMessenger", vo);
	}

	public int updateNotice(NoticeVO vo) {
		return mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	public void deleteNotice(NoticeVO vo) {
		mybatis.insert("NoticeDAO.deleteNotice", vo);
	}
	
	public NoticeVO getNotice(NoticeVO vo) {
		return mybatis.selectOne("NoticeDAO.getNotice", vo);
	}
	
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getNoticeList", vo);
	}
	
	public List<NoticeVO> getMessengerList(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getMessengerList", vo);
	}
	
	public void insertRoom(NoticeVO vo) {
		mybatis.insert("NoticeDAO.insertRoom", vo);
	}

	public NoticeVO getInsertRoom(NoticeVO vo) {
		return mybatis.selectOne("NoticeDAO.getInsertRoom", vo);
	}
	
	public void insertChatJoiner(NoticeVO vo) {
		mybatis.insert("NoticeDAO.insertChatJoiner", vo);
	}
	
	public List<NoticeVO> getChatMember(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getChatMember", vo);
	}
	
	public List<NoticeVO> getChatMember_Me(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getChatMember_Me", vo);
	}
	
	public List<NoticeVO> getChatMember2(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getChatMember2", vo);
	}

	public List<NoticeVO> setChatMember2(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.setChatMember2", vo);
	}

	public List<NoticeVO> getChatMember2_In(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getChatMember2_In", vo);
	}

	public List<NoticeVO> getNoticeList2(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getNoticeList2", vo);
	}

	public List<NoticeVO> getNoticeList_Search(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getNoticeList_Search", vo);
	}
	
	public List<NoticeVO> getNoticeList_Search2(NoticeVO vo) {
		
		return mybatis.selectList("NoticeDAO.getNoticeList_Search2", vo);
	}
	
	public ProjectVO projectNotice(int p_num) {
		return mybatis.selectOne("NoticeDAO.projectNotice", p_num);
	}
}
