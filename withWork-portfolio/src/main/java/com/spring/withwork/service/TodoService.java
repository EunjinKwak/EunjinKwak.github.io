package com.spring.withwork.service;

import java.util.List;
import java.util.Map;

import com.spring.withwork.vo.DepartmentVO;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.ProjectVO;
import com.spring.withwork.vo.TodoVO;

public interface TodoService {
	
	public ProjectVO getOneProject(int p_num);
	void insertTodo(TodoVO todo);
	void insertConfirm(TodoVO todo);
	void updateTodo(TodoVO todo);
	int dragTodoUpdate(TodoVO todo);
	void getOneTodo(TodoVO todo);
	List<TodoVO> getAllTodo(TodoVO todo);
	List<TodoVO> getTodoDetail();
	List<DepartmentVO> getAllDepart(DepartmentVO depart);
	GuestVO getGuestCompany(GuestVO guest);
	List<ProjectVO> getAllProject(int m_num);
	public List<GuestVO> getProjectJoiner(int p_num);
	public List<TodoVO> getProjectTodo(TodoVO todo);
	public List<GuestVO> getProjectNotJoiner(GuestVO guest);
	public int inviteProject(GuestVO guest);
	public List<ProjectVO> getProjectIn(int m_num);
	public void finalDateUpdate(TodoVO todo);
	
	
}





