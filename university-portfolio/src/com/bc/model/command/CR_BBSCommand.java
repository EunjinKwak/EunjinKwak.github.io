package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bc.model.dao.DAO;
import com.bc.model.vo.CR_BBSVO;
import com.bc.mybatis.Paging;


public class CR_BBSCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Paging p = new Paging();

		p.setTotalRecord(DAO.CB_Count());
		p.setTotalPage();
		System.out.println(">전체 게시글 수  : " + p.getTotalRecord());
		System.out.println("> 전체 페이지 수 " + p.getTotalPage());
		
		String cPage = request.getParameter("cPage");
		if (cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		p.setEnd(p.getNowPage() * p.getNumPerPage()); 
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		if (p.getEnd() > p.getTotalRecord()) {
			p.setEnd(p.getTotalRecord());
		}
		
		int nowPage = p.getNowPage();
		int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
		p.setBeginPage(beginPage);
		p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
		
		if (p.getEndPage() > p.getTotalPage()) {
			p.setEndPage(p.getTotalPage());
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("begin", p.getBegin());
		map.put("end", p.getEnd());
		List<CR_BBSVO> list = DAO.CB_List(map);
		System.out.println("list : " + list);
		
		HttpSession ss = request.getSession(true);	
		ss.setAttribute("list", list);
		ss.setAttribute("pvo",p);
		ss.setAttribute("cPage", cPage);
		
		return "list.jsp";
	}	
}










