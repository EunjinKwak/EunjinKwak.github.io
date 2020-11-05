package com.bc.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.RegistrationVO;
import com.bc.model.vo.SearchListVO;
import com.bc.mybatis.DBService;

public class RegistrationDAO {
		//과목정보 조회
		public static List<RegistrationVO> getList(Map<String, Integer> map) {
			SqlSession ss = DBService.getFactory().openSession();
			List<RegistrationVO> list = ss.selectList("BIT_UNV.list", map);
			System.out.println("list : " + list);
			ss.close();
			return list;
		}
		// 과목의 전체 건수 조회
		public static int getTotalCount() {
			SqlSession ss = DBService.getFactory().openSession();
			int totalCount = ss.selectOne("BIT_UNV.totalCount");
			ss.close();
			return totalCount;
		}
		
		//과목정보 검색 조회
		public static List<RegistrationVO> getListAll(String search, String keyword) {
			SqlSession ss = DBService.getFactory().openSession();
			Map <String, String> map = new HashMap<>();
			map.put("search", search);
			map.put("keyword", keyword);
			
			List<RegistrationVO> list = ss.selectList("BIT_UNV.search", map);
			System.out.println("list : " + list);
			ss.close();
			return list;
		}
		public static List<RegistrationVO> getsearchListAll(SearchListVO slvo) {
			SqlSession ss = DBService.getFactory().openSession();
			List<RegistrationVO> list = ss.selectList("BIT_UNV.searchlistall", slvo);
			System.out.println("list : " + list);
			ss.close();
			return list;
		}
		
		//수강정원 카운트다운
		public static void personnel_down(String subjectnum) {
			SqlSession ss = DBService.getFactory().openSession(true);
			ss.update("BIT_UNV.personnel_down", subjectnum);
			ss.close();
			
		}
		//수강정원 카운트 업
		public static void personnel_up(String subjectnum) {
			SqlSession ss = DBService.getFactory().openSession(true);
			ss.update("BIT_UNV.personnel_up", subjectnum);
			ss.close();
			
		}
	
}
