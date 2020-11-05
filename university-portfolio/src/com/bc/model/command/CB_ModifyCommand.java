package com.bc.model.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.dao.DAO;
import com.bc.model.vo.CR_BBSVO;

public class CB_ModifyCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cPage = request.getParameter("cPage");
		HttpSession ss = request.getSession(true);
		ss.getAttribute("bvo");
		String c_idx = request.getParameter("c_idx");	
		String hakbun = request.getParameter("hakbun");
		String b_idx = request.getParameter("b_idx");
		
		CR_BBSVO bvo1 = (CR_BBSVO)ss.getAttribute("bvo");
		
		CR_BBSVO bvo = new CR_BBSVO();
		bvo.setSubjectnum(bvo1.getSubjectnum());
		bvo.setTitle(request.getParameter("title"));
		bvo.setWriter(request.getParameter("writer"));
		
		bvo.setWriter_date(bvo1.getWriter_date());
		bvo.setContent(request.getParameter("content"));
		
		bvo.setB_idx(bvo1.getB_idx());
		
		System.out.println(">>>>>" + bvo);
		
		int result = DAO.CB_modify(bvo);
		
		ss.setAttribute("bvo", bvo);
		
		ss.setAttribute("cPage", cPage);
		ss.getAttribute(cPage);
		return "Controller?type=CR_BBS";
	}

}










