package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;

public class IdSearchCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		
		//2. DB에서 해당부서(deptno)에 있는 직원 조회(DAO 사용)
		String hakbun = DAO.getEmail(email);
		
		if(hakbun == null) {
			String fail = "해당 E-mail에 맞는 학번이 존재하지 않습니다.";
			request.setAttribute("fail", fail);
			return "Search.jsp";
		}else {
			String fail = "학번은 : '" +hakbun+ "' 입니다." ;
			request.setAttribute("fail", fail);
			return "main.jsp";
			
		}
		
	}

}
