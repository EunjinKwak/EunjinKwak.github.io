package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.SubjectVO;


public class Sub_searchCommand implements Command {
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String idx = request.getParameter("idx");
	String keyword = request.getParameter("keyword");
	
	String path = null;
	if (keyword == null || keyword.equals("")) {
		path = "sub_Inform.jsp";
	} else {
		List<SubjectVO> list = DAO.Sub_Search(idx, keyword);
		System.out.println(">> list : " + list);
		
		String title = "";
		switch (idx) {
			case "0" : title = "과목"; break;
			case "1" : title = "담당교수"; break;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("title", title);
		
		path = "sub_searchList.jsp";
	}
	return path;
}
}
