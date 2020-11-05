package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.CR_BBSVO;

public class CB_WriteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CR_BBSVO bvo = new CR_BBSVO();
		
		bvo.setSubjectnum(request.getParameter("subjectnum"));
		bvo.setTitle(request.getParameter("title"));
		bvo.setWriter(request.getParameter("writer"));
		bvo.setContent(request.getParameter("content"));
		bvo.setHakbun(request.getParameter("hakbun"));
		
		
		request.setAttribute("bvo", bvo);
		
		int result = DAO.CB_write(bvo);
		
		return "Controller?type=CR_BBS";
	}

}










