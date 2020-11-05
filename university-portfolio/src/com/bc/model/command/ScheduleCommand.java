package com.bc.model.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.dao.DAO;
import com.bc.model.vo.RegistrationVO;
import com.bc.model.vo.StudentVO;

public class ScheduleCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentVO vo = (StudentVO)request.getSession().getAttribute("vo");
		String hakbun = vo.getHakbun();
		DAO dao = new DAO();
		List<RegistrationVO> list = dao.getSchedule(hakbun);
		System.out.println("list : " + list);
		
		List<RegistrationVO> list1 = new ArrayList<>();
		List<RegistrationVO> list2 = new ArrayList<>();
		List<RegistrationVO> list3 = new ArrayList<>();
		List<RegistrationVO> list4 = new ArrayList<>();
		List<RegistrationVO> list5 = new ArrayList<>();
		
		for(RegistrationVO rvo : list) {
			String[] ts = rvo.getTime().split("");
			if(ts[0].equals("월")) {
				list1.add(rvo);
				System.out.println("월 : " + rvo.toString());
			}
			if(ts[0].equals("화")) {
				list2.add(rvo);
				System.out.println("화: " + rvo.toString());
			}
			if(ts[0].equals("수")) {
				list3.add(rvo);
				System.out.println("수 : " + rvo.toString());
			}
			if(ts[0].equals("목")) {
				list4.add(rvo);
				System.out.println("목 : " + rvo.toString());
			}
			if(ts[0].equals("금")) {
				list5.add(rvo);
				System.out.println("금 : " + rvo.toString());
			}
		}
		
		String scehdule= "";
		
		for(int i = 1; i <= 8; i++) {
			scehdule += "<tr>";
			scehdule += "<td>" + i + "교시</td>";
			
			if(list1.size() == 0) {
				scehdule += "<td>" + "</td>";
			}
			for(int j = 0; j < list1.size(); j++) {
				String ing = Integer.toString(i);
				String[] time = list1.get(j).getTime().split("");
				if (ing.equals(time[2])){
					scehdule += "<td rowspan=2>" + list1.get(j).getSubject() + "</td>";
					break;
				}else if(ing.equals(time[4])){
					break;
				}else if (j == (list1.size() -1)){
					scehdule += "<td>" + "</td>";
					break;
				}
			}
			System.out.println("scehdule 월: " + scehdule);
			if(list2.size() == 0) {
				scehdule += "<td>" + "</td>";
			}
			for(int j = 0; j < list2.size(); j++) {
				String ing = Integer.toString(i);
				String[] time = list2.get(j).getTime().split("");
				if (ing.equals(time[2])){
					scehdule += "<td rowspan=2>" + list2.get(j).getSubject() + "</td>";
					break;
				}else if(ing.equals(time[4])) {
					break;
				}else if (j == (list2.size() -1)) {
					scehdule += "<td>" + "</td>";
					break;
				}		
			}
			System.out.println("scehdule 화: " + scehdule);
			if(list3.size() == 0) {
				scehdule += "<td>" + "</td>";
			}
			for(int j = 0; j < list3.size(); j++) {
				String ing = Integer.toString(i);
				String[] time = list3.get(j).getTime().split("");
				if (ing.equals(time[2])){
					scehdule += "<td rowspan=2>" + list3.get(j).getSubject() + "</td>";
					break;
				}else if(ing.equals(time[4])) {
					break;
				}else if (j == (list3.size() -1)) {
					scehdule += "<td>" + "</td>";
					break;
				}
			}
			System.out.println("scehdule 수: " + scehdule);
			if(list4.size() == 0) {
				scehdule += "<td>" + "</td>";
			}
			for(int j = 0; j < list4.size(); j++) {
				String ing = Integer.toString(i);
				String[] time = list4.get(j).getTime().split("");
				if (ing.equals(time[2])){
					scehdule += "<td rowspan=2>" + list4.get(j).getSubject() + "</td>";
					break;
				}else if(ing.equals(time[4])) {
					break;
				}else if (j == (list4.size() -1)){
					scehdule += "<td>" + "</td>";
					break;
				}
			}
			System.out.println("scehdule 목: " + scehdule);
			if(list5.size() == 0) {
				scehdule += "<td>" + "</td>";
			}
			for(int j = 0; j < list5.size(); j++) {
				String ing = Integer.toString(i);
				String[] time = list5.get(j).getTime().split("");
				if (ing.equals(time[2])){
					scehdule += "<td rowspan=2>" + list5.get(j).getSubject() + "</td>";
					break;
				}else if(ing.equals(time[4])) {
					break;
				}else if (j == (list5.size() -1)) {
					scehdule += "<td>" + "</td>";
					break;
				}
			}
			scehdule += "</tr>";
			System.out.println("scehdule 금: " + scehdule);
		}

		request.setAttribute("scehdule", scehdule);
		return "Schedule.jsp";
	}
}
