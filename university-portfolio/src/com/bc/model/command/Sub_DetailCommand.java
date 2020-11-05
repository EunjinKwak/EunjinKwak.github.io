package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.dao.DAO;
import com.bc.model.vo.SubjectVO;

public class Sub_DetailCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subjectnum = request.getParameter("subjectnum");
		String subject = request.getParameter("subject");
		String name = request.getParameter("name");
		
		String cPage = request.getParameter("cPage");
		
		
		System.out.println("> subjectnum : -" + subjectnum + "-");
		System.out.println("> subject : -" + subject + "-");
		System.out.println("> cPage : -" + cPage + "-");
		
		
		SubjectVO bvo = DAO.Sub_selectOne(subjectnum);
		System.out.println("> bvo : " + bvo);
		
		HttpSession ss = request.getSession(true);
		ss.setAttribute("bvo", bvo);
		SubjectVO bvo1 = (SubjectVO)ss.getAttribute("bvo");
		ss.setAttribute("bvo",bvo);
		ss.getAttribute("p");
		ss.getAttribute("list");
		ss.getAttribute("bvo");
		ss.setAttribute("cPage", cPage);		
		
		return "Subjects\\"+ bvo.getSubjectnum() + ".jsp";
	}
}
