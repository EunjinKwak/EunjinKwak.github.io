package com.bc.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.command.Command;
import com.bc.model.command.DeleteCommand;
import com.bc.model.command.ListCommand;
import com.bc.model.command.C_SearchCommand;
import com.bc.model.command.SelectCommand;
import com.bc.model.command.ViewCommand;


@WebServlet("/controller")
public class FrontControllerCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf8");
		
		String type = request.getParameter("type");
		System.out.println("type : " + type );
		
		Command command = null;
		//수강신청 버튼 눌렀을때
		if ("all".equals(type)) {
			
			command = new C_SearchCommand();
			//command = new ListCommand();
			String path = command.exec(request, response);
			command = new ViewCommand();
			path = command.exec(request, response);
	
			String  search = "7";
			HttpSession httpSession = request.getSession(true);
		    httpSession.setAttribute("search", search);
			request.getRequestDispatcher(path).forward(request, response);
			
			//수강신청 선택 버튼 눌렀을 때
		} else if ("sel".equals(type)) {
			String  search = request.getParameter("search");
			String path;
			System.out.println("controll search2 : " + search);
			String searchAll = request.getParameter("searchAll");
			//검색안하고 수강신청 선택
			if (search.equals("7")) {
				System.out.println("controll search3 : " + search);
				if (searchAll.equals("noseek")) {
					command = new SelectCommand();	
					path = command.exec(request, response);
				}
				command = new C_SearchCommand();
				//command = new ListCommand();
				path = command.exec(request, response);	
				command = new ViewCommand();
				path = command.exec(request, response);
				
				// 검색해서 수강신청 선택
			} else {
				
				//선택 후 재검색
				if (searchAll.equals("noseek")) {
					command = new SelectCommand();	
					path = command.exec(request, response);
					command = new C_SearchCommand();
					path = command.exec(request, response);
					command = new ViewCommand();
					path = command.exec(request, response);
				
					//검색 후 전체보기 검색
				} else if (search.equals("3")){
					command = new C_SearchCommand();
					//command = new ListCommand();
					path = command.exec(request, response);
					command = new ViewCommand();
					path = command.exec(request, response);
					System.out.println("searchAll : " + searchAll);
					//학과, 교수명, 과목명 검색
				} else {
					command = new C_SearchCommand();
					path = command.exec(request, response);
					command = new ViewCommand();
					path = command.exec(request, response);
					
				}
			}
			request.getRequestDispatcher(path).forward(request, response);
		
			//수강신청 리스트에서 삭제
		} else if ("del".equals(type)) {
			String  search = request.getParameter("search");
			String  keyword = request.getParameter("keyword");
			
			command = new DeleteCommand();
			String path = command.exec(request, response);
			
			//검색하지 않고 삭제
			if (search.equals("7")) {
				command = new C_SearchCommand();
				//command = new ListCommand();
				path = command.exec(request, response);
				//전체보기 검색했을때 삭제
			} else if (search.equals("3")) {
				command = new C_SearchCommand();
				//command = new ListCommand();
				path = command.exec(request, response);	
				//학과, 교수명, 과목명 검색 후 삭제
			} else {
				command = new C_SearchCommand();
				path = command.exec(request, response);	
			}
	
			
			request.getRequestDispatcher(path).forward(request, response);	
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}










