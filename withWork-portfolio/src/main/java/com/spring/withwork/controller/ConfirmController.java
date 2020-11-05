package com.spring.withwork.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.withwork.service.BoardService;
import com.spring.withwork.service.ConfirmService;
import com.spring.withwork.vo.ConfirmVO;
import com.spring.withwork.vo.Criteria;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.PageMaker;

@Controller
public class ConfirmController {
	
	private static final Logger logger = LoggerFactory.getLogger(ConfirmController.class);

	@Inject
	BoardService service;
	
	@Autowired
	private ConfirmService confirmService;
	
	@RequestMapping("/getPopupConfirm.do")
	@ResponseBody
	public List<ConfirmVO> getPopupConfirm(ConfirmVO confirm, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		confirm.setWorker_m(guest.getM_num());
		
		List<ConfirmVO> confirmList = confirmService.getAllConfirm(confirm);
		return confirmList;
	}
	
	@RequestMapping(value="/selectConfirm.do")
	@ResponseBody
	public ConfirmVO selectConfirm(ConfirmVO confirm) throws Exception {
		return confirmService.selectConfirm(confirm);
	}
	
	
	@RequestMapping(value="/updateConfirm.do")
	public String updateAll(ConfirmVO confirm) throws Exception {
		
		if(confirm.getState().equals("완료")) {
			confirmService.updateAll(confirm);
			confirmService.finishTodo(confirm);
		} else {
			if(confirm.getFeedback() != "") {
				confirm.setState("보류");
				confirmService.updateConfirm(confirm);
			}
		}
		
		return "redirect:getAllConfirm.do?page=1&perPageNum=3&tab=1";
	}
	
	
	@RequestMapping(value = "/getAllConfirm.do")
	public String list(Model model, Criteria cri, HttpSession session) throws Exception {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		System.out.println("cri : " + cri);
		cri.setM_num(guest.getM_num());
		List<ConfirmVO> list = service.list(cri);
		model.addAttribute("list", list);
		System.out.println("list : " + list);
      
		PageMaker pageMaker = new PageMaker();
		   
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		      
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list2", service.list2(cri));
			  
		PageMaker pageMaker2 = new PageMaker();

		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(service.listCount());
			  
		model.addAttribute("pageMaker2", pageMaker2);
			  
			  
		model.addAttribute("list3", service.list3(cri));
			        
		PageMaker pageMaker3 = new PageMaker();
			  
		pageMaker3.setCri(cri);
		pageMaker3.setTotalCount(service.listCount());
			  
		model.addAttribute("pageMaker3", pageMaker3);
			      
		return "confirm.jsp";
	}
}

	

	


