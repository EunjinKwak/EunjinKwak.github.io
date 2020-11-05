package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;

public class PwdSearchCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hakbun = request.getParameter("hakbun");
		String phone = request.getParameter("phone");
		
		
		
		
		//2. DB에서 해당부서(deptno)에 있는 직원 조회(DAO 사용)
		String pwd = DAO.getPwd(hakbun, phone);
		
		if(pwd == null) {
			String fail = "학번 or 핸드폰 번호를 확인해주세요";
			request.setAttribute("fail", fail);
			return "Search.jsp";
		}else {
			String fail = "비밀번호는 : '" +pwd+ "' 입니다." ;
			request.setAttribute("fail", fail);
			return "main.jsp";
			
		}
		
	}

}
