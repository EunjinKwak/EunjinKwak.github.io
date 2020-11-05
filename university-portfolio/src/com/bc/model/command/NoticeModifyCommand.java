package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.NoticeVO;


public class NoticeModifyCommand implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//전달받은 파라미터값 추출
		NoticeVO nvo = new NoticeVO();
		nvo.setN_idx(request.getParameter("n_idx"));
		nvo.setName(request.getParameter("name"));
		nvo.setTitle(request.getParameter("title"));
		nvo.setContent(request.getParameter("content"));
		nvo.setEmail(request.getParameter("email"));
		nvo.setRegdate(request.getParameter("regdate"));
		nvo.setHakbun(request.getParameter("hakbun"));
		
		System.out.println(nvo.toString());

		//DB에서 데이터 입력 (DAO 사용)
		DAO.updateNotice(nvo);
		
		return "notice.jsp";
	}

}
