package com.spring.withwork.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.withwork.service.MemberService;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.MemberVO;


@Controller
@SessionAttributes({"member", "guest"})
public class MemberController {
	@Autowired
	private MemberService memberService;

	public MemberController() {
	}
	
	

	// 전체보기
	@RequestMapping("/getAllMember.do")
	@ResponseBody
	public List<MemberVO> getAllMember(MemberVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		List<MemberVO> memberAll = memberService.getAllMember(vo);
		return memberAll;

	}
	
	// 한명보기
	@RequestMapping("/getOneMember.do")
	@ResponseBody
	public MemberVO getOneMember(MemberVO vo) {
		MemberVO memberOne = memberService.getOneMember(vo);
		return memberOne;
		
	}
	
	// 수정, 삭제 멤버 불러오기
	@RequestMapping("/getMember.do")
	@ResponseBody
	public List<MemberVO> getMember(MemberVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		List<MemberVO> getMember = memberService.getMember(vo);
		return getMember;
		
	}

	// 부서 보기
	@RequestMapping("/getDepart.do")
	@ResponseBody
	public List<MemberVO> getDepart(MemberVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		
		List<MemberVO> Depart = memberService.getDepart(vo);
		return Depart;

	}
	
	// 직책 보기
	@RequestMapping("/getMemberRoles.do")
	@ResponseBody
	public List<MemberVO> getRoles(MemberVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		
		List<MemberVO> Role = memberService.getRoles(vo);
		return Role;
		
	}
	 

	// 전체보기 -> 검색하기
	@RequestMapping("/searchAllMember.do")
	@ResponseBody
	public List<MemberVO> searchAllMember(MemberVO vo, HttpSession session) {
		
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		
		List<MemberVO> searchAll = memberService.searchAllMember(vo);
		return searchAll;
	}
	
	// 멤버추가 -> 검색하기
	@RequestMapping("/searchAddMember.do")
	@ResponseBody
	public List<MemberVO> searchAddMember(MemberVO vo) {
		List<MemberVO> searchAdd = memberService.searchAddMember(vo);
		return searchAdd;
	}
	
	// 멤버추가 -> 불러오기
	@RequestMapping("/selectMember.do")
	@ResponseBody
	public List<MemberVO> selectMember(MemberVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		List<MemberVO> selectM = memberService.selectMember(vo);
		return selectM;
	}
	
	// 멤버수정 -> 검색하기
	@RequestMapping("/searchUpMember.do")
	@ResponseBody
	public List<MemberVO> searchUpMember(MemberVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		List<MemberVO> searchUp = memberService.searchUpMember(vo);
		return searchUp;
	}
	
	// 멤버삭제 -> 검색하기
	@RequestMapping("/searchDelMember.do")
	@ResponseBody
	public List<MemberVO> searchDelMember(MemberVO vo, HttpSession session) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		List<MemberVO> searchDel = memberService.searchDelMember(vo);
		return searchDel;
	}
	
	
	
	//삭제하기
	 @RequestMapping("/deleteMember.do")
	 @ResponseBody 
	 public int deleteMember(MemberVO vo) {
		 int result = memberService.deleteMember(vo);
		 return result;
	  }
	 
	 
	 //수정하기
	 @RequestMapping("/updateMember2.do")
	 @ResponseBody 
	 public int updateMember(MemberVO vo, HttpSession session) {
		 GuestVO guest = (GuestVO) session.getAttribute("guest");
		 vo.setC_num(guest.getC_num());
		 
		 int result = memberService.updateMember(vo);
		 return result;
		 
	 }
	 
	 //추가하기
	 @RequestMapping("/insertMember.do")
	 @ResponseBody 
	 public int insertMember(MemberVO vo, HttpSession session) {
		 GuestVO guest = (GuestVO) session.getAttribute("guest");
		 vo.setC_num(guest.getC_num());
		 int result = memberService.insertMember(vo);
		 return result;
		 
	 }
	 

}
