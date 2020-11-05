package com.spring.withwork.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.withwork.service.MainService;
import com.spring.withwork.vo.CompanyVO;
import com.spring.withwork.vo.DepartmentVO;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.RolesVO;
import com.spring.withwork.vo.SearchGroupCri;
import com.spring.withwork.vo.SearchGroupPage;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping("/join.do")
	public String join() {
		return "join.jsp";
	}
	
	@GetMapping("/register.do")
	public String register() {
		return "signup.jsp";
	}
	
	// 1014추가(박실)
	@GetMapping("/searchGroup.do")
	public String searchGroup(SearchGroupCri cri, Model model) {
		
		System.out.println("cri : " + cri);
		if(cri.getType() == null) {
			cri.setType("");
		}
		model.addAttribute("groupList", service.getGroupList(cri));
		System.out.println(service.getGroupList(cri));
		int total = service.getTotal(cri);
		System.out.println("total : " + total);
		
		model.addAttribute("sgPageMaker", new SearchGroupPage(cri, total));
		return "searchGroup.jsp";
	}
	
	// 1009수정 (최은서)
	// 1012수정 (박실)
	@ResponseBody
	@PostMapping("/login.do")
	public int login(GuestVO guest, HttpSession session) {
		int result = 0;
		String g_name = service.login(guest);
		GuestVO loginGuest = service.guestInfo(guest);
		
		if(g_name != "") {
			result = 1;
			session.setAttribute("email", guest.getEmail());
			session.setAttribute("authstatus", "withwork");
			session.setAttribute("g_name", g_name);
			session.setAttribute("guest", loginGuest);
		}
		return result;
	}
	
	// 1009수정 (최은서)
	// 1012수정 (박실)
	@ResponseBody
	@PostMapping("/otherLogin.do")
	public String otherLogin(GuestVO guest, HttpSession session) {
		String result = "";
		String g_name = service.otherLogin(guest);
		GuestVO loginGuest = service.guestInfo(guest);
		
		
		if(g_name != "") {
			session.setAttribute("email", guest.getEmail());
			session.setAttribute("authstatus", "google");
			session.setAttribute("g_name", g_name);
			session.setAttribute("guest", loginGuest);
			
			result = "success";
		} else {
			result = "fail";
		}
		return result;
	}

	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main.do";
	}
	
	@PostMapping("/register.do")
	public String register(GuestVO guest, Model model) throws Exception {
		service.register(guest);
		
		model.addAttribute("regResult", 2);
		return "main.jsp";
	}
	
	@GetMapping("/regiConfirm.do")
	public String emailConfirm(@ModelAttribute("guest")GuestVO guest, Model model) {
		guest.setAuthStatus("withwork");
		service.updateAuthStatus(guest);
		
		model.addAttribute("regResult", 1);
		return "main.jsp";
	}
	
	@GetMapping("/main.do")
	public String main() {
		return "main.jsp";
	}
	
	// 1012수정 (박실)
	@ResponseBody
	@GetMapping(value = "/checkId.do")
	public int checkId(@RequestParam("email")String email) {
		return service.checkId(email);
	}

	@ResponseBody
	@PostMapping("/findId.do")
	public String findId(GuestVO guest, Model model) {
		return service.findId(guest);
	}
	
	// 1012수정 (박실)
	@ResponseBody
	@PostMapping("/findPassword.do")
	public int findPassword(GuestVO guest, HttpSession session) {
		int result = service.chkId(guest);
		
		if(result > 0) {
			session.setAttribute("resultId", guest.getEmail());
		}
		return result;
	}
	
	@ResponseBody
	@PostMapping("/updatePassword.do")
	public int updatePassword(GuestVO guest) {
		return service.updatePwd(guest);
	}
	
	@GetMapping("/insertGroup.do")
	public String insertGroup() {
		return "group.jsp";
	}
	
	// 1012수정 (박실)
	@ResponseBody
	@PostMapping("/insertGroup.do")
	public int insertGroup(CompanyVO company) {
		return service.insertGroup(company);
	}
	
	@GetMapping("/myPage.do")
	public String myPage() {
		return "myPage.jsp";
	}
	
	@PostMapping("/updateName.do")
	public String updateName(GuestVO guest) {
		service.updateName(guest);
		return "myPage.jsp";
	}
	
	@ResponseBody
	@PostMapping("/checkPwd.do")
	public int checkPwd(GuestVO guest) {
		return service.checkPwd(guest);
	}
	
	@PostMapping("/withdrawal.do")
	public String withdrawal(GuestVO guest, HttpSession session) {
		service.withdrawal(guest);
		session.setAttribute("authstatus", "withdrawal");
		return "main.jsp";
	}
	
	@RequestMapping("/getProjectMe.do")
	@ResponseBody
	public List<GuestVO> getProjectMe(GuestVO guest) {
		return service.getProjectMe(guest);
	}
	
	//1013추가 (박실)
	@ResponseBody
	@GetMapping("/getRoles.do")
	public List<RolesVO> getRoles(String c_num) {
		List<RolesVO> roleList = service.getRoles(c_num);
		
		return roleList;
	}
	
	//1013추가 (박실)
	@ResponseBody
	@GetMapping("/getDept.do")
	public List<RolesVO> getDept(String c_num) {
		List<RolesVO> deptList = service.getDept(c_num);
		
		return deptList;
	}
	
	//1013추가 (박실)
	@ResponseBody
	@PostMapping("/updateMember.do")
	public int updateMember(DepartmentVO dept) {
		int result = service.updateMember(dept);
		return result;
	}
	
	//1014추가(박실)
	@ResponseBody
	@GetMapping("/getGroup.do")
	public CompanyVO getGroup(String c_num) {
		CompanyVO company = service.getGroup(c_num);
		return company;
	}
}
