package com.spring.withwork.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.DepartmentVO;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.ProjectVO;
import com.spring.withwork.vo.TodoVO;

@Repository("TodoDaoMybatis")
public class TodoDaoMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public TodoDaoMybatis() {
	}
	
	public ProjectVO getOneProject(int p_num) {
		return mybatis.selectOne("TodoDao.getOneProject", p_num);
	}
	
	public void insertTodo(TodoVO todo) {
		mybatis.insert("TodoDao.insertTodo", todo);
	}
	
	public void insertConfirm(TodoVO todo) {
		mybatis.insert("TodoDao.insertConfirm", todo);
	}
	
	public void finalDateUpdate(TodoVO todo) {
		mybatis.update("TodoDao.finalDateUpdate", todo);
	}
	
	public void updateTodo(TodoVO todo) {
		mybatis.update("TodoDao.updateTodo", todo);
	}
	
	public int dragTodoUpdate(TodoVO todo) {
		return mybatis.update("TodoDao.dragTodoUpdate", todo);
	}

	public void getOneTodo(TodoVO todo) {
		// TODO Auto-generated method stub
		
	}
	
	public List<TodoVO> getTodoDetail() {
		return mybatis.selectList("TodoDao.getTodoDetail");
	}
	

	public List<TodoVO> getAllTodo(TodoVO todo) {
		return mybatis.selectList("TodoDao.getAllTodo", todo);
	}
	
	public List<DepartmentVO> getAllDepart(DepartmentVO depart) {
		return mybatis.selectList("TodoDao.getAllDepart", depart);
	}
	
	public GuestVO getGuestCompany(GuestVO guest) {
		return mybatis.selectOne("TodoDao.getGuestCompany", guest);
	}
	
	public List<ProjectVO> getAllProject(int m_num) {
		return mybatis.selectList("TodoDao.getAllProject", m_num);
	}
	
	public List<ProjectVO> getProjectIn(int m_num) {
		return mybatis.selectList("TodoDao.getProjectIn", m_num);
	}
	
	public List<GuestVO> getProjectJoiner(int p_num) {
		return mybatis.selectList("TodoDao.getProjectJoiner", p_num);
	}
	
	public List<TodoVO> getProjectTodo(TodoVO todo) {
		return mybatis.selectList("TodoDao.getProjectTodo", todo);
	}
	
	public List<GuestVO> getProjectNotJoiner(GuestVO guest) {
		return mybatis.selectList("TodoDao.getProjectNotJoiner", guest);
	}
	
	public int inviteProject(GuestVO guest) {
		return mybatis.insert("TodoDao.inviteProject", guest);
	}
}








