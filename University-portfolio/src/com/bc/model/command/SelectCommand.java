package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bc.model.dao.CartDAO;
import com.bc.model.dao.DAO;
import com.bc.model.dao.RegistrationDAO;
import com.bc.model.vo.CartVO;
import com.bc.model.vo.RegistrationVO;
import com.bc.model.vo.StudentVO;

public class SelectCommand implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartVO cvo = new CartVO();

		cvo.setSubject(request.getParameter("subject"));
		cvo.setSubjectnum(request.getParameter("subjectnum"));
		cvo.setName(request.getParameter("name"));
		cvo.setTime(request.getParameter("time"));
		cvo.setClassroom(request.getParameter("classroom"));
		cvo.setGrade(Integer.parseInt(request.getParameter("grade")));
		cvo.setHakbun(request.getParameter("hakbun"));
		
		StudentVO svo = new StudentVO();
		svo.setHakbun(request.getParameter("hakbun"));
		/*svo.setS_grade(Integer.parseInt(request.getParameter("s_grade")));*/
		
		/*출력확인*/
		System.out.println("subjectnum :" + request.getParameter("subjectnum"));
		System.out.println("subject :" + request.getParameter("subject"));
		System.out.println("name :" + request.getParameter("name"));
		System.out.println("time :" + request.getParameter("time"));
		System.out.println("classroom :" + request.getParameter("classroom"));
		System.out.println("grade :" + request.getParameter("grade"));
		System.out.println("cvo hakbun :" + cvo.getHakbun());
		System.out.println("svo hakbun :" + svo.getHakbun());
		
		
		
		System.out.println("select cvo: " + cvo);
		
		//관리자가 수강신청 클릭시 해당 과목 신청한 학생 리스트
		if(svo.getHakbun().equals("admin")) {
			int sum = 5;
			int sum_people = 0;
			System.out.println("확인 조건문");
			System.out.println(cvo.getSubjectnum());
			List<String> list = CartDAO.selHakbun(cvo.getSubjectnum());
			List<StudentVO> slist = DAO.getStudent(list);
			System.out.println("slist" + slist.toString());
			sum_people = slist.size();
			request.setAttribute("shlist", slist);
			request.setAttribute("sum_people", sum_people);
			request.setAttribute("sum", sum);
			
			return "Registration_list.jsp";
		}
		
		/*Cart 데이터 가져와서 요일 비교*/
		List<CartVO> list = CartDAO.cart_sel(cvo.getHakbun());
		String [] array_newTime;
		array_newTime = cvo.getTime().split("");
		
		/*겹치는 강의시간 비교*/
		int  sw = 0;
		for (CartVO vo : list) {
			String [] array_oldTime;
			array_oldTime = vo.getTime().split("");
			if(array_oldTime[0].equals(array_newTime[0])) {
				if (array_oldTime[2].equals(array_newTime[2])) {
					sw = 1;
				} else if (array_oldTime[2].equals(array_newTime[4])) {
					sw = 1;
				} else if (array_oldTime[4].equals(array_newTime[2])) {
					sw = 1;
				}
			}
		}
		
		
		/*정원수 확인하기*/
		String subjectnum = request.getParameter("subjectnum");
		int personnel = Integer.parseInt(request.getParameter("personnel"));
		
		/*수강가능 학점 불러오기*/
		int s_grade = DAO.getSGrade(svo.getHakbun());
		if (s_grade < cvo.getGrade() ) {
			String warning = "수강 가능한 학점이 부족합니다.";
			request.setAttribute("warning", warning);
			
		} else if (sw == 0) {
			
			if(personnel > 0) {
				CartDAO.insert(cvo);
				list = CartDAO.cart_sel(cvo.getHakbun());
				RegistrationDAO.personnel_down(subjectnum);
				/*수강가능학점 다운*/
				DAO.downGrade(svo.getHakbun(), request.getParameter("grade"));
			} else {
				String warning = "수강 인원이 초과되었습니다.";
				request.setAttribute("warning", warning);
			}
		} else {
			String warning = "강의 시간이 겹칩니다.";
			request.setAttribute("warning", warning);
		}
		
		
		
		
		/*총 신청 학점 계산*/
		int sum_grade = 0;
		for(CartVO vo : list) {
			sum_grade += vo.getGrade();
		}
		
		
		HttpSession httpSession = request.getSession(true);
	    httpSession.setAttribute("cart", list);
	    
	    String search = request.getParameter("search");
		String keyword = request.getParameter("keyword");
	    request.setAttribute("search", search);
		request.setAttribute("keyword", keyword);
		request.setAttribute("sum_grade", sum_grade);
		request.setAttribute("s_grade", s_grade);
		//2. 응답페이지(Registration_index.jsp)에 전달(request 객체에 속성값으로 전달)
		return "Registration_list.jsp";
	}

}