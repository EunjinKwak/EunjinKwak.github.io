package com.spring.withwork.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.withwork.service.NoticeService;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.NoticeVO;
import com.spring.withwork.vo.ProjectVO;

@Controller
@SessionAttributes({"notice", "room_id", "project", "guest"})
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	public NoticeController() {
	}
	
	@RequestMapping("/projectNotice.do")
	public String projectNotice(@ModelAttribute("guest") GuestVO guest, int p_num, Model model) {
		
		ProjectVO project = noticeService.projectNotice(p_num);
		model.addAttribute("project", project);
		
		return "redirect:notice.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/insertNotice.do")
	public int insertNotice(NoticeVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setM_num(guest.getM_num());
		vo.setG_num(guest.getG_num());
		
		int notice = noticeService.insertNotice(vo);
		
		
		return notice;
	}

	@ResponseBody
	@RequestMapping("/insertMessenger.do")
	public int insertMessenger(NoticeVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setM_num(guest.getM_num());
		vo.setG_num(guest.getG_num());
		
		int notice = noticeService.insertMessenger(vo);
		
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/updateNotice.do")
	public int updateNotice(NoticeVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setM_num(guest.getM_num());
		
		int notice = noticeService.updateNotice(vo);
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getNoticeList.do")
	public List<NoticeVO> getNoticeList(NoticeVO vo, Model model) {
		
		List<NoticeVO> notice = noticeService.getNoticeList(vo);
		model.addAttribute("notice", notice);
		
		return notice;
	}

	@ResponseBody
	@RequestMapping("/getMessengerList.do")
	public List<NoticeVO> getMessengerList(NoticeVO vo, Model model) {
		
		List<NoticeVO> notice = noticeService.getMessengerList(vo);
		model.addAttribute("notice", notice);
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getChatMember.do")
	public List<NoticeVO> getChatMember(NoticeVO vo, Model model, HttpSession session) {
		
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		
		vo.setC_num(guest.getC_num());
		vo.setM_num(guest.getM_num());
		List<NoticeVO> notice = noticeService.getChatMember(vo);
		model.addAttribute("notice", notice);
		
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getChatMember2.do")
	public List<NoticeVO> getChatMember2(NoticeVO vo, Model model, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		
		vo.setM_num(guest.getM_num());		
		List<NoticeVO> notice = noticeService.getChatMember2(vo);
		model.addAttribute("notice", notice);
		
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/setChatMember2.do")
	public List<NoticeVO> setChatMember2(NoticeVO vo, HttpSession session) {
		
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		
		vo.setM_num(guest.getM_num());
		List<NoticeVO> notice = noticeService.setChatMember2(vo);
		
		return notice;
	}

	@RequestMapping("/getChatMember2_In.do")
	public String getChatMember2_In(NoticeVO vo, Model model) {
		model.addAttribute("room_id", vo.getRoom_id());
		
		return "redirect:getChatMember2_In2.do";
	}
	
	@RequestMapping("/insert11Chat.do")
	public String insertRoom(NoticeVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		
		NoticeVO myMNUM = new NoticeVO();
		myMNUM.setM_num(guest.getM_num());
		
		noticeService.insertRoom(vo);
		noticeService.insertChatJoiner(vo);
		noticeService.insertChatJoiner(myMNUM);
		
		return "getInsertRoom.do?m_num=" + vo.getM_num();
	}
	
	@RequestMapping("/getInsertRoom.do")
	public String getInsertRoom(NoticeVO vo) {
		NoticeVO notice = noticeService.getInsertRoom(vo);
		
		return "getChatMember2_In.do?room_id=" + notice.getRoom_id();
	}
	
	@RequestMapping("/getChatMember2_In2.do")
	public String getChatMember2_In2() {

		return "redirect:messenger.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/getNoticeList2.do")
	public List<NoticeVO> getNoticeList2(NoticeVO vo, Model model) {
		
		List<NoticeVO> notice = noticeService.getNoticeList2(vo);
		model.addAttribute("notice", notice);
		
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getNoticeList_Search.do")
	public List<NoticeVO> getNoticeList_Search(NoticeVO vo, Model model, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		vo.setM_num(guest.getM_num());
		List<NoticeVO> notice = noticeService.getNoticeList_Search(vo);
		model.addAttribute("notice", notice);
		
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getNoticeList_Search2.do")
	public List<NoticeVO> getNoticeList_Search2(NoticeVO vo, Model model, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		vo.setM_num(guest.getM_num());
		List<NoticeVO> notice = noticeService.getNoticeList_Search2(vo);
		model.addAttribute("notice", notice);
		
		
		return notice;
	}
	
	@ResponseBody
	@RequestMapping("/getChatMember_Me.do")
	public List<NoticeVO> getChatMember_Me(NoticeVO vo, Model model, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setM_num(guest.getM_num());
      
      List<NoticeVO> notice = noticeService.getChatMember_Me(vo);
      
      System.out.println("getChatMember_Me() notice : " + notice);
      
      return notice;
   }
}
