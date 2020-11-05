package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.CR_BBSVO;
import com.bc.mybatis.Paging;


public class CB_SearchCommand implements Command{
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
		
		String idx = request.getParameter("idx");
		String keyword = request.getParameter("keyword");
		
		String path = null;
		if (keyword == null || keyword.equals("")) {
			path = "list.jsp";
		} else {
			List<CR_BBSVO> list = DAO.CB_Search(idx, keyword);
			System.out.println(">> list : " + list);
			
			String title = "";
			switch (idx) {
				case "0" : title = "제목"; break;
				case "1" : title = "글쓴이"; break;
			}
			
			
			request.setAttribute("list", list);
			request.setAttribute("title", title);
			
			path = "searchList.jsp";
		}
		return path;
	}
}
