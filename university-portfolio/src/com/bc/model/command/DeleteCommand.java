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

public class DeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CartVO cvo = new CartVO();
		String subjectnum = request.getParameter("subjectnum");
		CartDAO.delete(subjectnum);
		
		/*삭제해서 정원수 올리기*/
		RegistrationDAO.personnel_up(subjectnum);
		
		cvo.setSubject(request.getParameter("subject"));
		cvo.setSubjectnum(request.getParameter("subjectnum"));
		cvo.setName(request.getParameter("name"));
		cvo.setTime(request.getParameter("time"));
		cvo.setClassroom(request.getParameter("classroom"));
		cvo.setGrade(Integer.parseInt(request.getParameter("grade")));
		cvo.setHakbun(request.getParameter("hakbun"));
		
		List<CartVO> list = CartDAO.cart_sel(cvo.getHakbun());
		/*총 신청 학점 계산*/
		int sum_grade = 0;
		for(CartVO vo : list) {
			sum_grade += vo.getGrade();
		
		}
		
		/*수강가능학점 업*/
		DAO.upGrade(cvo.getHakbun(), request.getParameter("grade"));

		/*수강가능 학점 불러오기*/
		int s_grade = DAO.getSGrade(cvo.getHakbun());
		
		
		HttpSession httpSession = request.getSession(true);
	    httpSession.setAttribute("cart", list);
	    request.setAttribute("sum_grade", sum_grade);
	    request.setAttribute("s_grade", s_grade);
	    
		return "Registration_list.jsp";
	}

}
