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

import com.bc.model.vo.SubjectVO;
import com.bc.mybatis.Paging;

public class Sub_InformCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Paging p = new Paging();
		p.setTotalRecord(DAO.Sub_Count());
		p.setTotalPage();
		System.out.println(">>>>>>>> : " + p.getTotalRecord());
		System.out.println("> >>>>>>> : " + p.getTotalPage());
		
		String cPage = request.getParameter("cPage");
		if (cPage != null) {
			p.setNowPage(Integer.parseInt(cPage));
		}
		
		p.setEnd(p.getNowPage() * p.getNumPerPage()); 
		p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
		
		if (p.getEnd() > p.getTotalRecord()) {
			p.setEnd(p.getTotalRecord());
		}
		System.out.println("-----------");
		System.out.println(">>현페 : " + p.getNowPage());
		System.out.println(">>시작 : " + p.getBegin());
		System.out.println(">>끝(end) : " + p.getEnd());
		
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
		List<SubjectVO> list = DAO.Sub_List(map);
		
		System.out.println("list>>>>> " + list);
		
		HttpSession ss = request.getSession(true);	
		ss.setAttribute("list", list);
		ss.setAttribute("pvo",p);
		ss.setAttribute("cPage", cPage);
		
		return "sub_Inform.jsp";
	}	
}










