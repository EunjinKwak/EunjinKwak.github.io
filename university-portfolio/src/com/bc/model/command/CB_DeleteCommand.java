package com.bc.model.command;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.CR_BBSVO;

public class CB_DeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CR_BBSVO bvo = new CR_BBSVO();
		String b_idx = request.getParameter("b_idx");
//		String b_idx = bvo.getB_idx();
		System.out.println(">>>>" + b_idx);
		DAO.CB_delete(b_idx);
		
		return "controller?type=CR_BBS";
	}

}










