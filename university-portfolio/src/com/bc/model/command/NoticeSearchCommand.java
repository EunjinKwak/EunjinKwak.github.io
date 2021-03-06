package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.NoticeVO;

public class NoticeSearchCommand implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("> 노티스서치컨트롤러 도착");
		
		request.setCharacterEncoding("UTF-8");
		
		//파라미터 값 받아오기
		String idx = request.getParameter("idx");
		String keyword = request.getParameter("keyword");
		System.out.println("> idx : " + idx + ", keyword : " + keyword);
		if(idx.equals("whole")) {
			return "notice.jsp";
		}
		//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("keyword", keyword);
		System.out.println("> map : " + map);
		
		//DB에서 데이터 조회(DAO 사용)
		List<NoticeVO> list = DAO.getSearchNotice(map); 
		System.out.println("> 검색 결과(list): " + list);
		
		request.setAttribute("list", list);
		
		return "noticeSearchList.jsp";
	}

}
