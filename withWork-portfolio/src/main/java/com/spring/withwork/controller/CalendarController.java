package com.spring.withwork.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.withwork.service.CalendarService;
import com.spring.withwork.vo.CalendarVO;
import com.spring.withwork.vo.GuestVO;

@Controller
public class CalendarController {
	@Autowired
	private CalendarService calendarService;
	
	public CalendarController() {
	}
	
	//진행중 프로젝트 불러오기
	@RequestMapping("/getAllCalendar.do")
	@ResponseBody
	public List<CalendarVO> getAllCalendar(CalendarVO vo, HttpSession session) {
		
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		
		vo.setC_num(guest.getC_num());
		List<CalendarVO> projectAll = calendarService.getAllProject(vo);
		return projectAll;
	}
	
}
