package com.spring.withwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.withwork.service.RoadmapService;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.ProjectVO;
import com.spring.withwork.vo.SearchProject;

@Controller
@SessionAttributes("guest")
public class RoadmapController {

	@Autowired
	private RoadmapService service;
	
	@GetMapping("/")
	public String main() {
		return "index.jsp";
	}
	
	
	/*1010 수정(최은서)*/
	@GetMapping("/roadmap.do")
	public String roadmap(@ModelAttribute("guest") GuestVO guest, Model model) {
		/*
		 * 임시 로그인 처리
		 */
		
		String auth = guest.getAuthority();
		
		if(auth.equals("관리자")) {
			model.addAttribute("auth", "관리자");
		} else if(auth.equals("멤버")) {
			model.addAttribute("auth", "멤버");
		}
		
		/* 
		model.addAttribute("id", "gos@test.com");
		model.addAttribute("g_name", "고수");
		model.addAttribute("c_num", 2);
		*/
		return "roadmap.jsp";
	}
	
	//1013수정 (박실)
	@ResponseBody
	@GetMapping("/prjList.do")
	public List<ProjectVO> prjList(String c_num) {
		List<ProjectVO> prjList = service.prjList(c_num);
		return prjList;
	}
	
	@ResponseBody
	@GetMapping("/searchProject.do")
	public List<ProjectVO> prjListSearch(SearchProject sp) {
		List<ProjectVO> searchProject = service.searchProject(sp);
		return searchProject;
	}
	
	@ResponseBody
	@GetMapping("/getPrj.do")
	public ProjectVO getPrj(String p_num) {
		ProjectVO getPrj = service.getPrj(p_num);
		return getPrj;
	}
	
	@ResponseBody
	@PostMapping("/insertProject.do")
	public String insertProject(ProjectVO prj) {
		String result;
		int insertResult = service.insertProject(prj);

		if(insertResult == 1) {
			result = "success";
		} else {
			result = "fail";
		}
		return result;
	}
	
	@ResponseBody
	@GetMapping("/managerList.do")
	public List<ProjectVO> managerList(int c_num) {
		List<ProjectVO> managerList = service.managerList(c_num);
		return managerList;
	}
	
	@ResponseBody
	@PostMapping("/updatePrjoect.do")
	public String updatePrjoect(ProjectVO prj) {
		String result;
		int updateResult = service.updateProject(prj);
		
		if(updateResult == 1) {
			result = "success";
		} else {
			result = "fail";
		}
		return result;
	}
}
