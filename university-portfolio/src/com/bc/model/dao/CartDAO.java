package com.bc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bc.model.vo.CartVO;
import com.bc.mybatis.DBService;

public class CartDAO {

		// 데이터 조회
		public static int insert(CartVO cvo) {
			SqlSession ss = DBService.getFactory().openSession(true);
			int result = ss.insert("BIT_UNV.cart_insert", cvo);
			ss.close();
			return result;
		}
		//관리자 계정으로 과목 선택시 해당 과목을 신청한 학번조회
		public static List<String> selHakbun(String subjectnum) {
			SqlSession ss = DBService.getFactory().openSession(true);
			System.out.println("과목번호" + subjectnum);
			List<String> list = ss.selectList("BIT_UNV.selHakbun", subjectnum);
			System.out.println(list.toString());
			ss.close();
			return list;
		}
		
		// 수강신청 데이터 카트 담기
		public static List<CartVO> cart_sel(String hakbun) {
			System.out.println("hakbun 나와라얍: " + hakbun);
			SqlSession ss = DBService.getFactory().openSession(true);
			List<CartVO> list = ss.selectList("BIT_UNV.cart_sel", hakbun);
			System.out.println("cartlist3 : " + list);
			ss.close();
			return list;
		}
		
		//수강신청 삭제 처리
		public static int delete(String subjectnum) {
			SqlSession ss = DBService.getFactory().openSession(true);
			int result = ss.delete("BIT_UNV.cart_del", subjectnum);
			ss.close();
			return result;
		}
	
}
