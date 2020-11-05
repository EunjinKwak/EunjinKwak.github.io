package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.dao.DAO;
import com.bc.model.vo.CR_BBSVO;
import com.bc.model.vo.CommVO;

public class CB_ViewCommand implements Command{
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String b_idx = request.getParameter("b_idx");
		String cPage = request.getParameter("cPage");
		
		
		System.out.println("> b_idx : -" + b_idx + "-");
		System.out.println("> cPage : -" + cPage + "-");
		
		
		CR_BBSVO bvo = DAO.CB_selectOne(b_idx);
		System.out.println("> bvo : " + bvo);
		DAO.hit(Integer.parseInt(b_idx));
		
		List<CommVO> list = DAO.Comm_list(b_idx);
		System.out.println("> list : " + list);
		
		HttpSession ss = request.getSession(true);
//		CR_BBSVO bvo1 = (CR_BBSVO)ss.getAttribute("bvo");
		ss.setAttribute("bvo",bvo);
		ss.setAttribute("c_list", list);
		ss.getAttribute("c_list");
		ss.getAttribute("p");
		ss.getAttribute("list");
		ss.getAttribute("bvo");
		ss.setAttribute("cPage", cPage);		
		
		return "view.jsp";
	}
}
