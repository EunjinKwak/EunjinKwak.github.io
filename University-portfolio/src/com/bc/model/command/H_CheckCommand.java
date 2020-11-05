package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.StudentVO;

public class H_CheckCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hakbun = request.getParameter("hakbun");
		System.out.println("학번" + hakbun);
		String pwdCheck="";
		StudentVO vo = new StudentVO();
		vo = DAO.pwdCheck(hakbun);
		
		System.out.println(vo);
		if(vo == null) {
			pwdCheck = "우리학교 사람이 아닙니다. 썩나가거라";
			request.setAttribute("pwdCheck", pwdCheck);
			return "Sign_Up_For.jsp";
		}
		
		if(vo.getPassword() == null) {
			pwdCheck = "회원가입이 가능한 학번입니다.!";
			System.out.println("20200806" + pwdCheck);
			request.setAttribute("hakbun", hakbun);
			request.setAttribute("pwdCheck", pwdCheck);
		}else {
			
			pwdCheck = "이미 가입된 학번입니다.학번 및 비밀번호 찾기 메뉴로 이동안해줘^^ 알아서 찾아";
			System.out.println("20200806" + pwdCheck);
			request.setAttribute("pwdCheck", pwdCheck);
		}
		
		return "Sign_Up_For.jsp";
	}

}
