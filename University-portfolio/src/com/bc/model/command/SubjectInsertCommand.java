 package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.SubjectVO;


public class SubjectInsertCommand implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//전달받은 파라미터값 추출
		SubjectVO svo = new SubjectVO();
		svo.setSubjectnum(request.getParameter("subjectnum"));
		svo.setSubject(request.getParameter("subject"));
		svo.setTime(request.getParameter("time"));
		svo.setClassroom(request.getParameter("classroom"));
		svo.setGrade(Integer.parseInt(request.getParameter("grade")));
		svo.setD_num(request.getParameter("d_num"));
		svo.setF_num(request.getParameter("f_num"));
		svo.setPersonnel(Integer.parseInt(request.getParameter("personnel")));
		
		System.out.println("> 추가할 강의 : " + svo.toString());
		
		//DB에서 데이터 입력 (DAO 사용)
		DAO.insertSubject(svo);
		
		//화면전환
		return "managerSubject.jsp";
	}

}
