package com.bc.model.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bc.model.dao.DAO;
import com.bc.model.vo.StudentVO;

public class LoginCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hakbun = request.getParameter("hakbun");
		String password = request.getParameter("password");
		
		//2. DB에서 해당부서(deptno)에 있는 직원 조회(DAO 사용)
		StudentVO vo = DAO.getLogin(hakbun, password);
		
		if(vo == null) {
			String fail = "아이디, 패스워드를 확인하세요";
			request.setAttribute("fail", fail);
			return "main.jsp";
		}else {
			String success = vo.getName() + "님 환영합니다. 사랑해요";
			request.setAttribute("success", success);
			request.setAttribute("vo", vo);
			
			return "main.jsp";
		}
		
		
	}

}
