package com.bc.model.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.NoticeVO;

public class NoticeViewCommand implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공지사항 페이지의 상세 페이지로 전환 
		//전달받은 파라미터값 추출
		String n_idx = request.getParameter("n_idx");
		
		//DB에서 n_idx의 데이터 조회 (DAO 사용)
		NoticeVO noticeView = DAO.getViewNotice(n_idx);
		System.out.println(">>>> 현재 게시글 NoticeVO : " + noticeView);
		
		//조회된 페이지를 응답페이지(noticeView.jsp)에서 사용토록 속성에 저장
		request.setAttribute("noticeView", noticeView);
		
		//응답페이지(noticeView.jsp)로 포워딩(전환)
		return "noticeView.jsp";
	}

}
