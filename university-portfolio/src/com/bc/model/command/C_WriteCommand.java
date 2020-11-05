package com.bc.model.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.CommVO;

public class C_WriteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommVO cvo = new CommVO();
		String b_idx = request.getParameter("b_idx");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String hakbun = request.getParameter("hakbun");
		
		
		cvo.setContent(request.getParameter("content"));
		cvo.setHakbun(request.getParameter("hakbun"));
		cvo.setWriter(request.getParameter("writer"));
		cvo.setB_idx(b_idx);
		request.setAttribute("cvo", cvo);
		System.out.println(">>>>>>>>" + cvo);
		int result = DAO.Comm_write(cvo);
		
		return "Controller?type=CB_View&${bvo.b_idx }&cPage=${pvo.nowPage}";
	}

}










