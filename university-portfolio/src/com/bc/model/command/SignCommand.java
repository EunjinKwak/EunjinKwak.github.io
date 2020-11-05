package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.StudentVO;

public class SignCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hakbun = request.getParameter("hakbun");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String d_num = request.getParameter("d_num");
		
		StudentVO signVo = new StudentVO(hakbun, name, password, email, phone, d_num);
		
		System.out.println("signVo"+ signVo);
		
		
		
		//2. Student DB에 회원가입 정보를 통한 회원 가입 (업데이트)
			DAO.setSign(signVo);
			return "main.jsp";

	}

}
