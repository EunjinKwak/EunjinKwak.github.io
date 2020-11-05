package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;


public class NoticeDeleteCommand implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//전달받은 파라미터값 추출
		String n_idx = request.getParameter("n_idx");
		System.out.println("> 삭제할 n_idx :" + n_idx);
		
		//DB에서 데이터 입력 (DAO 사용)
		DAO.deleteNotice(n_idx);
		
		return "notice.jsp";
	}

}