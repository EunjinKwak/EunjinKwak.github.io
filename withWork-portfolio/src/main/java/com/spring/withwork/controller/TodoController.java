package com.spring.withwork.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.withwork.service.TodoService;
import com.spring.withwork.vo.DepartmentVO;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.ProjectVO;
import com.spring.withwork.vo.TodoVO;

@Controller
@SessionAttributes({"guest", "project"})
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/projectTodo.do")
	public String getProjectList(int p_num, Model model) {
		
		ProjectVO project = todoService.getOneProject(p_num);
		model.addAttribute("project", project);
		
		return "redirect:projectTodo.jsp";
	}
	
	@RequestMapping("/groupLogin.do") 
	public String getGuestCompany(@ModelAttribute("guest") GuestVO loginGuest, Model model, int c_num) {
		 
		 loginGuest.setC_num(c_num);
		 GuestVO guest = todoService.getGuestCompany(loginGuest);
		 model.addAttribute("guest", guest); 
		 
		 return "redirect:todo.jsp"; 
	}
	 
	@RequestMapping("/insertTodo.do")
	public String insertTodo(HttpSession session, TodoVO todo) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		guest.setM_num(todo.getOrder_m());
		todo.setD_num(guest.getD_num()); // 임시 
		
		todoService.insertTodo(todo);
		
		return "redirect:groupLogin.do?c_num=" + guest.getC_num();
	}
	
	@RequestMapping("/pjInsertTodo.do")
	public String pjInsertTodo(HttpSession session, TodoVO todo) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		guest.setM_num(todo.getOrder_m());
		todo.setD_num(guest.getD_num()); // 임시 
		
		todoService.insertTodo(todo);
		
		return "redirect:projectTodo.do?p_num=" + todo.getP_num();
	}
	
	@RequestMapping("/updateTodo.do")
	public String updateTodo(HttpSession session, TodoVO todo) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		todoService.updateTodo(todo);
		if("완료".equals(todo.getProgress())) {
			todoService.insertConfirm(todo);
		}
		return "redirect:groupLogin.do?c_num=" + guest.getC_num();
	}
	
	@RequestMapping("/pjupdateTodo.do")
	public String pjupdateTodo(HttpSession session, TodoVO todo) {
		
		todoService.updateTodo(todo);
		
		if("완료".equals(todo.getProgress())) {
			todoService.insertConfirm(todo);
		}
		
		return "redirect:projectTodo.do?p_num=" + todo.getP_num();
	}
	
	@RequestMapping("/dragTodoUpdate.do")
	@ResponseBody
	public int dragTodoUpdate(HttpSession session, TodoVO todo) {
		
		int result = todoService.dragTodoUpdate(todo);
		
		return result;
	}
	
	
	@RequestMapping("/getAllTodo.do")
	@ResponseBody
	public List<TodoVO> getAllTodo(HttpSession session, TodoVO todo) {
		
		List<TodoVO> todoList = todoService.getAllTodo(todo);
		
		return todoList;
	}
	
	@RequestMapping("/getTodoDetail.do")
	@ResponseBody
	public List<TodoVO> getTeamTodo(HttpSession session) {
		
		List<TodoVO> todoDetail = todoService.getTodoDetail();
		
		return todoDetail;
	}
	
	@RequestMapping("/getAllDepart.do")
	@ResponseBody
	public List<DepartmentVO> getAllDepart(HttpSession session, DepartmentVO depart) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		depart.setD_num(guest.getD_num()); // 임시 
		List<DepartmentVO> departList = todoService.getAllDepart(depart);
		
		return departList;
	}
	
	@RequestMapping("/getAllProject.do")
	@ResponseBody
	public List<ProjectVO> getAllProject(HttpSession session, int m_num) {
		
		List<ProjectVO> projectList = todoService.getAllProject(m_num);
		
		return projectList;
	}
	
	@RequestMapping("/getProjectIn.do")
	@ResponseBody
	public List<ProjectVO> getProjectIn(HttpSession session, int m_num) {
		
		List<ProjectVO> projectInList = todoService.getProjectIn(m_num);
		
		return projectInList;
	}
	
	@RequestMapping("/getProjectJoiner.do")
	@ResponseBody
	public List<GuestVO> getProjectJoiner(int p_num) {
		
		List<GuestVO> pjList = todoService.getProjectJoiner(p_num);
		
		return pjList;
	}
	
	@RequestMapping("/getProjectTodo.do")
	@ResponseBody
	public List<TodoVO> getProjectTodo(TodoVO todo) {
		
		List<TodoVO> proejctTodoList = todoService.getProjectTodo(todo);
		
		return proejctTodoList;
	}
	
	@RequestMapping("/getProjectNotJoiner.do")
	@ResponseBody
	public List<GuestVO> getProjectNotJoiner(HttpSession session, GuestVO vo) {
		GuestVO guest = (GuestVO) session.getAttribute("guest");
		vo.setC_num(guest.getC_num());
		List<GuestVO> projectNotJoiner = todoService.getProjectNotJoiner(vo);
		
		return projectNotJoiner;
	}
	
	@RequestMapping("/inviteProject.do")
	@ResponseBody
	public int inviteProject(GuestVO vo) {
		
		int result = todoService.inviteProject(vo);
		return result;
	}
	
}
