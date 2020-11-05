package com.bc.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bc.model.command.Command;
import com.bc.model.command.H_CheckCommand;
import com.bc.model.command.IdSearchCommand;
import com.bc.model.command.LogOutCommand;
import com.bc.model.command.LoginCommand;
import com.bc.model.command.ManagerCommand;
import com.bc.model.command.ManagerSearchCommand;
import com.bc.model.command.ModifyCommand;
import com.bc.model.command.ModifyFCommand;
import com.bc.model.command.MyPageCommand;
import com.bc.model.command.NoticeDeleteCommand;
import com.bc.model.command.NoticeListCommand;
import com.bc.model.command.NoticeModifyCommand;
import com.bc.model.command.NoticeSearchCommand;
import com.bc.model.command.NoticeViewCommand;
import com.bc.model.command.NoticeWriteCommand;
import com.bc.model.command.PwdSearchCommand;
import com.bc.model.command.ScheduleCommand;
import com.bc.model.command.SearchCommand;
import com.bc.model.command.CB_DeleteCommand;
import com.bc.model.command.CB_DeleteviewCommand;
import com.bc.model.command.CB_ModifyCommand;
import com.bc.model.command.CB_ModifyviewCommand;
import com.bc.model.command.CB_SearchCommand;
import com.bc.model.command.CB_ViewCommand;
import com.bc.model.command.CB_WriteCommand;
import com.bc.model.command.CB_WriteviewCommand;
import com.bc.model.command.CR_BBSCommand;
import com.bc.model.command.C_DeleteCommand;
import com.bc.model.command.C_DeleteviewCommand;
import com.bc.model.command.C_SearchCommand;
import com.bc.model.command.C_WriteCommand;
import com.bc.model.command.SignCommand;
import com.bc.model.command.SignUpCommand;
import com.bc.model.command.Sub_DetailCommand;
import com.bc.model.command.Sub_InformCommand;
import com.bc.model.command.Sub_searchCommand;
import com.bc.model.command.SubjectInsertCommand;

@WebServlet("/Controller")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");
		
		String type = request.getParameter("type");
		System.out.println("type : " + type);
		Command command = null;
		
		if("login".equals(type)) {
			System.out.println("로그인 인내심");
			command = new LoginCommand();
		} else if ("sign".equals(type)) {//회원가입
			command = new SignCommand();
		}  else if("hCheck".equals(type)) { //회원가입시 중복확인
			command = new H_CheckCommand();
		} else if ("search".equals(type)) {//아이디 패스워드 찾기
			command = new SearchCommand();
		} else if ("id".equals(type)) {//아이디 찾기
			command = new IdSearchCommand();
		} else if ("pwd".equals(type)) {//패스워드 찾기
			command = new PwdSearchCommand();
		} else if ("signup".equals(type)) {//회원가입 페이지 이동
			command = new SignUpCommand();
		} else if ("mypage".equals(type)) {//마이페이지
			command = new MyPageCommand();
		} else if ("modify".equals(type)) {//정보수정
			command = new ModifyCommand();
		} else if ("modifyF".equals(type)) {//정보수정
			command = new ModifyFCommand();
		} else if ("schedule".equals(type)) {//시간표보기
			command = new ScheduleCommand();
		} else if ("logoutjsp".equals(type)) {//로그아웃
			command = new LogOutCommand();
		}else if ("noticeList".equals(type)) {//공지사항 목록
			command = new NoticeListCommand();
		} else if ("noticeView".equals(type)) {//공지사항 상세보기
			command = new NoticeViewCommand();
		} else if ("noticeWrite".equals(type)) {//공지사항 글쓰기
			command = new NoticeWriteCommand();
		} else if ("noticeModify".equals(type)) {//공지사항 수정
			command = new NoticeModifyCommand();
		} else if ("noticeDelete".equals(type)) {//공지사항 삭제
			command = new NoticeDeleteCommand();
		} else if ("noticeSearch".equals(type)) {//공지사항 검색
			command = new NoticeSearchCommand();
		} else if ("manager".equals(type)) {//관리자메뉴 전체학생 조회
			command = new ManagerCommand();
		} else if ("managerSearch".equals(type)) {	//관리자페이지 학생검색
			command = new ManagerSearchCommand();
		} else if ("subjectInsert".equals(type)) {//새로운 강의개설
			command = new SubjectInsertCommand();
		} else if ("CR_BBS".equals(type)) { //수강후기 게시판으로 이동 
			command = new CR_BBSCommand();
		} else if ("CB_Search".equals(type)) { //수강후기 카테고리별 검색
			command = new CB_SearchCommand();
		} else if ("CB_Write".equals(type)) { //수강후기 작성
			command = new CB_WriteCommand();
		} else if ("CB_Writeview".equals(type)) { //수강 후기 작성뷰
			command = new CB_WriteviewCommand(); 
		} else if ("CB_Modify".equals(type)) { //수강후기 수정
			command = new CB_ModifyCommand();
		} else if ("CB_Modifyview".equals(type)) { //수강후기 수정 작성뷰
			command = new CB_ModifyviewCommand();
		} else if ("CB_View".equals(type)) { //수강후기 상세페이지
			command = new CB_ViewCommand();
		} else if ("CB_Delete".equals(type)) { //수강후기 삭제
			command = new CB_DeleteCommand();
		} else if ("CB_Deleteview".equals(type)) { //수강후기 삭제
			command = new CB_DeleteviewCommand();
		} else if ("C_Write".equals(type)) { //댓글 작성
			command = new C_WriteCommand();
		} else if ("C_Delete".equals(type)) { //댓글 삭제
			command = new C_DeleteCommand();
		} else if ("C_Deleteview".equals(type)) { //댓글 삭제뷰
			command = new C_DeleteviewCommand();
		}else if("Sub_Inform".equals(type)) { //과목 정보 리스트 
			command = new Sub_InformCommand();
		} else if("Sub_Detail".equals(type)) { //과목 상세 뷰
			command = new Sub_DetailCommand();
		} else if("Sub_Search".equals(type)) { //수강후기 카테고리별 검색
			command = new Sub_searchCommand();
		} 
		
		String path = command.exec(request, response);
		System.out.println("path : " + path);
		// 페이지 전환 - 응답할 페이지(list.jsp)로 포워딩(전환)
		request.getRequestDispatcher(path).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
