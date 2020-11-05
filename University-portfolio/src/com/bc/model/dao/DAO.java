package com.bc.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.bc.model.vo.CR_BBSVO;
import com.bc.model.vo.CommVO;
import com.bc.model.vo.NoticeVO;
import com.bc.model.vo.RegistrationVO;
import com.bc.model.vo.SelectVO;
import com.bc.model.vo.StudentVO;
import com.bc.model.vo.SubjectVO;
import com.bc.mybatis.DBService;

public class DAO {

	//로그인
	public static StudentVO getLogin(String hakbun, String password) {
		SqlSession ss = DBService.getFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("hakbun", hakbun);
		map.put("password", password);
		StudentVO vo = ss.selectOne("BIT_UNV.login",map);
		ss.close();
		return vo;
	}
	
	//학번 중복확인을 위한 패스워드 값 받아오기 있으면 중복선언!
	public static StudentVO pwdCheck(String hakbun) {
		SqlSession ss = DBService.getFactory().openSession();
		StudentVO vo = ss.selectOne("BIT_UNV.pwdCheck", hakbun);
		
		ss.close();
		return vo;
	}
	
	//회원가입
	public static void setSign(StudentVO signVo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		System.out.println("signVo" + signVo);
		ss.update("BIT_UNV.sign", signVo);
		ss.close();
	}
	//아이디 찾기
	public static String getEmail(String email) {
		SqlSession ss = DBService.getFactory().openSession();
		String hakbun = ss.selectOne("BIT_UNV.idSearch", email);
		ss.close();
		return hakbun;
	}
	
	//패스워드 찾기
	public static String getPwd(String hakbun, String phone) {
		SqlSession ss = DBService.getFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("hakbun", hakbun);
		map.put("phone", phone);
		String pwd = ss.selectOne("BIT_UNV.pwdSearch",map);
		ss.close();
		return pwd;
	}
	
	//시간표보기
	public List<RegistrationVO> getSchedule(String hakbun) {
		SqlSession ss = DBService.getFactory().openSession();
		List<RegistrationVO> list = ss.selectList("BIT_UNV.schedule",hakbun);
		ss.close();
		return list;
	}
	
	//수강가능 학점
	public static int getSGrade(String hakbun) {
		SqlSession ss = DBService.getFactory().openSession();
		int s_grade = ss.selectOne("BIT_UNV.s_grade", hakbun);
		ss.close();
		return s_grade;
	}
	
	//학점 카운트다운
	public static void downGrade(String hakbun, String grade) {
		SqlSession ss = DBService.getFactory().openSession(true);
		Map<String, String> dmap = new HashMap<>();
		dmap.put("hakbun", hakbun);
		dmap.put("grade", grade);
		ss.update("BIT_UNV.s_grade_down", dmap);
		ss.close();
	}
	
	//학점 카운트 업
	public static void upGrade(String hakbun, String grade) {
		SqlSession ss = DBService.getFactory().openSession(true);
		Map<String, String> dmap = new HashMap<>();
		dmap.put("hakbun", hakbun);
		dmap.put("grade", grade);
		ss.update("BIT_UNV.s_grade_up", dmap);
		ss.close();
	}

	// Notice테이블의 전체 글 갯수 조회
	public static int getTotalCountNotice() {
		SqlSession ss = DBService.getFactory().openSession();
		int totalCount = ss.selectOne("BIT_UNV.totalCountNotice");
		ss.close();
		return totalCount;
	}
	
	//페이지에 해당하는 공지사항 글목록 가져오기
	public static List<NoticeVO> getListNotice(Map<String, Integer> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<NoticeVO> list = ss.selectList("BIT_UNV.listNotice", map);
		ss.close();
		return list;
	}
	
	//n_idx에 해당하는 공지사항 상세보기 가져오기
	public static NoticeVO getViewNotice(String n_idx) {
		SqlSession ss = DBService.getFactory().openSession();
		NoticeVO view = ss.selectOne("BIT_UNV.viewNotice", n_idx);
		ss.close();
		return view;
	}
	
	//조회수 1 증가 처리(공지사항 게시판)
	public static int updateHitNotice(String n_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("BIT_UNV.hitNotice", n_idx);
		ss.close();
		return result;
	}
	
	//공지사항 게시글 입력처리
	public static int insertNotice(NoticeVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BIT_UNV.insertNotice", vo);
		ss.close();
		return result;
	}
	
	//공지사항 게시글 수정처리
	public static int updateNotice(NoticeVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BIT_UNV.updateNotice", vo);
		ss.close();
		return result;
	}
	
	//공지사항 게시글 삭제처리
	public static int deleteNotice(String n_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BIT_UNV.deleteNotice", n_idx);
		ss.close();
		return result;
	}
	
	//검색한 공지사항 글 가져오기
	public static List<NoticeVO> getSearchNotice(Map<String, String> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<NoticeVO> list = ss.selectList("BIT_UNV.searchNotice", map);
		ss.close();
		return list;
	}
	
	//전체 학생 목록 가져오기
	public static List<StudentVO> getListStudent() {
		SqlSession ss = DBService.getFactory().openSession();
		List<StudentVO> list = ss.selectList("BIT_UNV.listStudent");
		ss.close();
		return list;
	}
	//검색한 학생 정보 가져오기
	public static List<StudentVO> getSearchManager(Map<String, String> map) {
		SqlSession ss = DBService.getFactory().openSession();
		List<StudentVO> list = ss.selectList("BIT_UNV.searchManager", map);
		ss.close();
		return list;
	}
	//새로운 강의 추가
	public static int insertSubject(SubjectVO vo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BIT_UNV.insertSubject", vo);
		ss.close();
		return result;
	}
	
	//--------------------- 수강후기 부분 -----------------------------------
	
	//수강후기 게시글 갯수
	public static int CB_Count() {
		SqlSession ss = DBService.getFactory().openSession(true);
		int totalCount = ss.selectOne("BIT_UNV.CRtotalCount");
		ss.close();
		return totalCount;
	}
	
	//수강후기 게시물 리스트
	public static List<CR_BBSVO> CB_List(Map<String, Integer> map) {
		SqlSession ss = DBService.getFactory().openSession(true);
		List<CR_BBSVO> list = ss.selectList("BIT_UNV.CRlist", map);
		ss.close();
		return list;
	}
	//수강후기 검색
	public static List<CR_BBSVO> CB_Search(String idx, String keyword) {
		SqlSession ss = DBService.getFactory().openSession(true);
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("keyword", keyword);
		List<CR_BBSVO> list = ss.selectList("BIT_UNV.CRsearch", map);
		ss.close();
		return list;
	}
	
	//수강후기  조회
	public static CR_BBSVO CB_selectOne(String b_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		CR_BBSVO vo = ss.selectOne("BIT_UNV.CRone", b_idx);
		ss.close();
		return vo;
	}
	
	// 수강후기 게시글 글쓰기
	public static int CB_write(CR_BBSVO bvo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BIT_UNV.CRinsert", bvo);
		ss.close();
		return result;
	}
	
	// 수강후기 게시글 수정
	public static int CB_modify(CR_BBSVO bvo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("BIT_UNV.CRupdate", bvo);
		ss.close();
		return result;
	}
	
	//수강 후기 게시글 삭제
	public static int CB_delete(String b_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.delete("BIT_UNV.CRdelete", b_idx);
		ss.close();
		return result;
	}
	//수강후기 조회수
	public static int hit(int hit) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.update("BIT_UNV.CRhit",hit);
		ss.close();
		return result;
		
	}
	
	//수강후기 댓글 리스트
	public static List<CommVO> Comm_list(String b_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		List<CommVO> list = ss.selectList("BIT_UNV.CRCommList", b_idx);
		ss.close();
		return list;
	}

	//수강후기 댓글 쓰기
	public static int Comm_write(CommVO cvo) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.insert("BIT_UNV.CRc_insert", cvo);
		ss.close();
		return result;
	}
	
	//수강후기 댓글 삭제
	public static int Comm_delete(String b_idx) {
		SqlSession ss = DBService.getFactory().openSession(true);
		int result = ss.delete("BIT_UNV.CRc_delete", b_idx);
		ss.close();
		return result;
	}
	
	// 선택 하기
	
	public static String getD_num (String hakbun) {
		SqlSession ss = DBService.getFactory().openSession(true);
		System.out.println("hakbun>>>>>>" + hakbun);
		String D_num = ss.selectOne("BIT_UNV.CRd_sel",hakbun);
		ss.close();
		return D_num;
	}
	
	public static List<SelectVO> get_sub(String d_num){
		SqlSession ss = DBService.getFactory().openSession(true);
		List<SelectVO>list = ss.selectList("BIT_UNV.CRsub_sel",d_num);
		ss.close();
		return list;
	}
	
	
	// -----------------과목 정보 부분--------------------------- 
	
	//과목정보 게시글 갯수
	public static int Sub_Count() {
		SqlSession ss = DBService.getFactory().openSession(true);
		int totalCount = ss.selectOne("BIT_UNV.CRs_totalCount");
		ss.close();
		return totalCount;
	}
	
	//과목 리스트
	public static List<SubjectVO> Sub_List(Map<String, Integer> map) {
		System.out.println(">>>>>" + map);
		SqlSession ss = DBService.getFactory().openSession(true);
		List<SubjectVO> list = ss.selectList("BIT_UNV.CRs_list", map);
		ss.close();
		return list;
	}
	//과목 검색
	public static List<SubjectVO> Sub_Search(String idx, String keyword) {
		SqlSession ss = DBService.getFactory().openSession(true);
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("keyword", keyword);
		List<SubjectVO> list = ss.selectList("BIT_UNV.CRs_search", map);
		ss.close();
		return list;
	}
	
	// 과목 하나 선택 
	public static SubjectVO Sub_selectOne(String subjectnum) {
		SqlSession ss = DBService.getFactory().openSession(true);
		SubjectVO vo = ss.selectOne("BIT_UNV.CRs_one", subjectnum);
		System.out.println("subjectnum : " + subjectnum);
		ss.close();
		return vo;
	}
	
	//관리자가 수강신청에서 과목 클릭시 해당 과목 듣는 학생 학번 리스트에 담기
	public static List<StudentVO> getStudent(List<String> list) {
		SqlSession ss = DBService.getFactory().openSession();
		List<StudentVO> slist = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			String hakbun = list.get(i);
			StudentVO vo = ss.selectOne("BIT_UNV.CHlist", hakbun);
			slist.add(vo);
		}
		ss.close();
		return slist;
	}

		
		
		
	
	
}












