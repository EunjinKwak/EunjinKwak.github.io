package com.bc.model.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.RegistrationDAO;
import com.bc.model.vo.RegistrationVO;
import com.bc.model.vo.SearchListVO;
import com.bc.mybatis.Paging;

public class C_SearchCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		String search = request.getParameter("search");
		String keyword = request.getParameter("keyword");
		
		if (keyword == null || keyword.equals("")) {
			//1. 전체 게시물의 수를 구하기
			Paging p = new Paging();
			p.setTotalRecord(RegistrationDAO.getTotalCount());
			
			int count = p.getTotalRecord();
			request.setAttribute("count", count);
			
			p.setTotalPage();
			
			//2. 현재 페이지 구하기
			String cPage = request.getParameter("cPage");
			if (cPage != null) {
				if(cPage.equals("")) {
					p.setNowPage(1);
				}else {
					p.setNowPage(Integer.parseInt(cPage));
				}
			}
			
			//3. 현재 페이지에 표시할 게시글 시작번호(begin), 끝번호(end) 구하기
			p.setEnd(p.getNowPage() * p.getNumPerPage()); //현재페이지번호 * 페이지당글수
			p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
			
			//(선택적) 3-1 끝 글번호가 데이터건수보다 많아지면 데이터 건수와 동일한 번호로 설정
			if (p.getEnd() > p.getTotalRecord()) {
				p.setEnd(p.getTotalRecord());
			}
			System.out.println("-----------");
			System.out.println(">>현재페이지 : " + p.getNowPage());
			System.out.println(">>시작번호(begin) : " + p.getBegin());
			System.out.println(">>끝번호(end) : " + p.getEnd());
			
			//---- 블록(block) 계산하기 -----------
			//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
			//시작페이지 번호 구하기
			
			int nowPage = p.getNowPage();
			int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
			p.setBeginPage(beginPage);
			p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
			
			//4-1 끝페이지(endPage)가 전체 페이지 수(totalPage) 보다 크면
			// 끝페이지를 전체페이지수로 변경처리
			if (p.getEndPage() > p.getTotalPage()) {
				p.setEndPage(p.getTotalPage());
			}
			System.out.println(">>시작페이지(beginPage) : " + p.getBeginPage());
			System.out.println(">>끝페이지(endPage) : " + p.getEndPage());
			
			//=============================================
			//현재 페이지 기준으로 DB데이터(게시글) 가져오기
			//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
			Map<String, Integer> map = new HashMap<>();
			map.put("begin", p.getBegin());
			map.put("end", p.getEnd());
			System.out.println("p.getEnd(): " +p.getBegin() + p.getEnd());
			
			List<RegistrationVO> list = RegistrationDAO.getList(map);
			
			System.out.println("list : " + list);
			
			System.out.println("p.getBeginPage() : " + p.getBeginPage());
			System.out.println("p.getEndPage() : " +p.getEndPage());
			request.setAttribute("pvo", p);
			
			//2. 응답페이지(Registration_index.jsp)에 전달(request 객체에 속성값으로 전달)
			
			/*HttpSession httpSession = request.getSession(true);
		    httpSession.setAttribute("list", list);*/
			request.setAttribute("list", list);
			if (cPage == null) {
				request.setAttribute("cPage", 1);
			} else {
				request.setAttribute("cPage", cPage);
			}
			//응답은 컨트롤러에서 해주는 것이 좋다.
			//페이징 처리 정보만 리턴
			
			
		}else {
			
			System.out.println("일로 와야해");
			System.out.println("일로 search" + search);
			System.out.println("일로 keyword" + keyword);
			List<RegistrationVO> list = RegistrationDAO.getListAll(search, keyword);
			Paging p = new Paging();
			p.setTotalRecord(list.size());
			
			int count = p.getTotalRecord();
			request.setAttribute("count", count);
			
			p.setTotalPage();
			
			//2. 현재 페이지 구하기
			String cPage = request.getParameter("cPage");
			if (cPage != null) {
				if(cPage.equals("")) {
					p.setNowPage(1);
				}else {
					p.setNowPage(Integer.parseInt(cPage));
				}
			}
			
			//3. 현재 페이지에 표시할 게시글 시작번호(begin), 끝번호(end) 구하기
			p.setEnd(p.getNowPage() * p.getNumPerPage()); //현재페이지번호 * 페이지당글수
			p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
			
			//(선택적) 3-1 끝 글번호가 데이터건수보다 많아지면 데이터 건수와 동일한 번호로 설정
			if (p.getEnd() > p.getTotalRecord()) {
				p.setEnd(p.getTotalRecord());
			}
			System.out.println("-----------");
			System.out.println(">>현재페이지 : " + p.getNowPage());
			System.out.println(">>시작번호(begin) : " + p.getBegin());
			System.out.println(">>끝번호(end) : " + p.getEnd());
			
			//---- 블록(block) 계산하기 -----------
			//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
			//시작페이지 번호 구하기
			
			int nowPage = p.getNowPage();
			int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
			p.setBeginPage(beginPage);
			p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
			
			//4-1 끝페이지(endPage)가 전체 페이지 수(totalPage) 보다 크면
			// 끝페이지를 전체페이지수로 변경처리
			if (p.getEndPage() > p.getTotalPage()) {
				p.setEndPage(p.getTotalPage());
			}
			System.out.println(">>시작페이지(beginPage) : " + p.getBeginPage());
			System.out.println(">>끝페이지(endPage) : " + p.getEndPage());
			
			//=============================================
			//현재 페이지 기준으로 DB데이터(게시글) 가져오기
			//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
			Map<String, Integer> map = new HashMap<>();
			map.put("begin", p.getBegin());
			map.put("end", p.getEnd());
			System.out.println("p.getEnd(): " +p.getBegin() + p.getEnd());
			
			SearchListVO slvo = new SearchListVO(search, keyword, p.getBegin(), p.getEnd());
			
			list = RegistrationDAO.getsearchListAll(slvo);
			
			System.out.println("list : " + list);
			
			System.out.println("p.getBeginPage() : " + p.getBeginPage());
			System.out.println("p.getEndPage() : " +p.getEndPage());
			request.setAttribute("pvo", p);
			
			//2. 응답페이지(Registration_index.jsp)에 전달(request 객체에 속성값으로 전달)
			
			/*HttpSession httpSession = request.getSession(true);
		    httpSession.setAttribute("list", list);*/
			request.setAttribute("list", list);
			if (cPage == null) {
				request.setAttribute("cPage", 1);
			} else {
				request.setAttribute("cPage", cPage);
			}
			//응답은 컨트롤러에서 해주는 것이 좋다.
			//페이징 처리 정보만 리턴
			
		}
		request.setAttribute("search", search);
		request.setAttribute("keyword", keyword);
		return "Registration_list.jsp";
	}

}
