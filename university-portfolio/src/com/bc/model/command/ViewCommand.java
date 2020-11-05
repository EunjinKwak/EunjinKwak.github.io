package com.bc.model.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.CartDAO;
import com.bc.model.dao.DAO;
import com.bc.model.vo.CartVO;

public class ViewCommand implements Command {


	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartVO cvo = new CartVO();
		cvo.setHakbun(request.getParameter("hakbun"));
		System.out.println("hakbun 11 : " + cvo.getHakbun());
		List<CartVO> list = CartDAO.cart_sel(cvo.getHakbun());
		
		/*총 신청 학점 계산*/
		int sum_grade = 0;
		for(CartVO vo : list) {
			/*if (sum_grade >= 15 || sum_grade < 0) {
				String warning = "수강 가능한 학점이 부족합니다.";
				request.setAttribute("warning", warning);
			} else {
				sum_grade += vo.getGrade();	
			}*/
			sum_grade += vo.getGrade();	
		
		}
		/*수강가능 학점 불러오기*/
		int s_grade = DAO.getSGrade(cvo.getHakbun());
		
		
		request.setAttribute("cart", list);
		request.setAttribute("sum_grade", sum_grade);
		request.setAttribute("s_grade", s_grade);
		
		return "Registration_list.jsp";
	}
}
