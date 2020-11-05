package com.spring.withwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.withwork.dao.CalendarDaoMybatis;
import com.spring.withwork.vo.CalendarVO;


@Service("calendarService")
public class CalendarServiceimpl implements CalendarService{
	@Autowired
	private CalendarDaoMybatis calendarDAO;
	
	public CalendarServiceimpl() {
		
	}

	@Override
	public List<CalendarVO> getAllProject(CalendarVO vo) {
		return calendarDAO.getAllProject(vo);
	}
}
