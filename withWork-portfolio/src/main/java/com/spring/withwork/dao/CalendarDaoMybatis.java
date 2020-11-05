package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.CalendarVO;

@Repository("CalendarDaoMybatis")
public class CalendarDaoMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public CalendarDaoMybatis() {
	}
	
	//진행중 프로젝트 불러오기
	public List<CalendarVO> getAllProject(CalendarVO vo) {
		return mybatis.selectList("CalendarDAO.getAllProject", vo);
	}
}
