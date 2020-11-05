package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.CommVO;

public class C_DeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		CommVO cvo = new CommVO();
		String b_idx = request.getParameter("b_idx");
		String c_idx = request.getParameter("c_idx");
		String hakbun = request.getParameter("hakbun");
		System.out.println(">>>>b" + b_idx);
		System.out.println(">>>>c : " + c_idx);
		DAO.Comm_delete(c_idx);
		
		String cPage = request.getParameter("cPage");
		
		

		request.setAttribute("c_idx", c_idx);
		request.setAttribute("hakbun", hakbun);
		request.setAttribute("b_idx", b_idx);
		request.getParameter(c_idx);
		request.getParameter(hakbun);
		request.getParameter(b_idx);
		System.out.println(">>>>" + b_idx);
		return "Controller?type=CB_View&${bvo.b_idx }&cPage=${pvo.nowPage}";
		
		
	}
}










