package com.spring.withwork.service;

import java.util.List;

import com.spring.withwork.vo.CalendarVO;
import com.spring.withwork.vo.ConfirmVO;

public interface CalendarService {
	List<CalendarVO> getAllProject(CalendarVO vo);
}
