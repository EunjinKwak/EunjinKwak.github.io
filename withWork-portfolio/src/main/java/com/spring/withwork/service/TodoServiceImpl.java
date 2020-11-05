package com.spring.withwork.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.withwork.dao.TodoDaoMybatis;
import com.spring.withwork.vo.DepartmentVO;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.ProjectVO;
import com.spring.withwork.vo.TodoVO;

@Service("TodoService")
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoDaoMybatis TodoDaoMybatis;

	@Override
	public void insertTodo(TodoVO todo) {
		TodoDaoMybatis.insertTodo(todo);
	}

	@Override
	public void updateTodo(TodoVO todo) {
		TodoDaoMybatis.updateTodo(todo);
	}

	@Override
	public void getOneTodo(TodoVO todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TodoVO> getAllTodo(TodoVO todo) {
		return TodoDaoMybatis.getAllTodo(todo);
	}

	@Override
	public List<DepartmentVO> getAllDepart(DepartmentVO depart) {
		return TodoDaoMybatis.getAllDepart(depart);
	}

	@Override
	public GuestVO getGuestCompany(GuestVO guest) {
		return TodoDaoMybatis.getGuestCompany(guest);
	}

	@Override
	public List<TodoVO> getTodoDetail() {
		return TodoDaoMybatis.getTodoDetail();
	}

	@Override
	public List<ProjectVO> getAllProject(int m_num) {
		return TodoDaoMybatis.getAllProject(m_num);
	}

	@Override
	public void insertConfirm(TodoVO todo) {
		TodoDaoMybatis.insertConfirm(todo);
	}

	@Override
	public int dragTodoUpdate(TodoVO todo) {
		return TodoDaoMybatis.dragTodoUpdate(todo);
	}

	@Override
	public ProjectVO getOneProject(int p_num) {
		return TodoDaoMybatis.getOneProject(p_num);
	}

	@Override
	public List<GuestVO> getProjectJoiner(int p_num) {
		return TodoDaoMybatis.getProjectJoiner(p_num);
	}

	@Override
	public List<TodoVO> getProjectTodo(TodoVO todo) {
		return TodoDaoMybatis.getProjectTodo(todo);
	}

	@Override
	public List<GuestVO> getProjectNotJoiner(GuestVO guest) {
		return TodoDaoMybatis.getProjectNotJoiner(guest);
	}

	@Override
	public int inviteProject(GuestVO guest) {
		return TodoDaoMybatis.inviteProject(guest);
		
	}

	@Override
	public List<ProjectVO> getProjectIn(int m_num) {
		return TodoDaoMybatis.getProjectIn(m_num);
	}

	@Override
	public void finalDateUpdate(TodoVO todo) {
		TodoDaoMybatis.finalDateUpdate(todo);
	}

}
