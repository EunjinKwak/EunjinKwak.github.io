<%@page import="com.bc.model.vo.StudentVO"%>
<%@page import="com.bc.model.dao.DAO"%>
<%@page import="com.bc.model.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//파라미터값 추출
	String cPage = request.getParameter("cPage");
	String n_idx = request.getParameter("n_idx");
	request.setAttribute("cPage", cPage);
	
	//게시글 조회수 1증가 처리
	DAO.updateHitNotice(n_idx);

	//로그인 세션값 가져오기
	StudentVO vo = (StudentVO)session.getAttribute("vo");
	
	//noticeView 세션에 저장하기
	NoticeVO noticeView = (NoticeVO)request.getAttribute("noticeView");
	session.setAttribute("noticeView", noticeView);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/noticeView.css" type="text/css">

<script>
//닫기 클릭
function close(frm) {
	document.getElementById("pwdCheck").style.display = 'none';
	
}
function modify_go(frm) {
	if ("${vo.getHakbun() }" == "admin"){
		alert("관리자 계정이 확인되었습니다.\n해당 페이지로 이동합니다.");
		frm.action = "noticeModify.jsp";
		frm.submit();
	} else {
		alert("권한이 없습니다.")
		histoty.back(-1);
	}
}
function delete_go(frm) {
	if ("${vo.getHakbun() }" == "admin"){
		alert("관리자 계정이 확인되었습니다.");
		document.getElementById("pwdCheck").style.display ='inline';
		
	} else {
		alert("권한이 없습니다.")
		histoty.back(-1);
	}
}
function all_notice(frm) {
	frm.action = "Controller?type=noticeList&cPage=${cPage } ";
	frm.submit();
}
function del_go(frm) {
	if (frm.pwd.value == "${vo.getPassword()}") { //암호일치
		var isDelete = confirm("정말 삭제할까요?");
		if (isDelete) {
			alert("공지사항 게시글 삭제가 완료되었습니다.");
			frm.action = "Controller?type=noticeDelete";
			frm.submit();
		} else {
			history.back();
		}
	} else {//암호 불일치
		alert("비밀번호가 일치하지 않습니다. 다시 확인하세요");
		frm.pwd.value = "";
		frm.pwd.focus();
	}
}
</script>
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="wrap">
<form method="post" name="frm">
	<table class="tables">
		<colgroup>
			<col width="20%"/>
			<col width="80%"/>
		</colgroup>
		<tbody>
			<tr>
				<th>글 번호</th>
				<td>${noticeView.n_idx }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${noticeView.title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${noticeView.name }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${noticeView.content }</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" class="botton" value="수정" onclick="modify_go(this.form)">
					<input type="button" class="botton" value="삭제" onclick="delete_go(this.form)">
					<input type="button" class="botton" value="목록" onclick="all_notice(this.form)">
					<input type="hidden" name="cPage" value="${cPage }">
				</td>
			</tr>
		</tfoot>
	</table>

</form>

<div id="pwdCheck">
<a href="javascript:close(this.form);"><img alt="닫기버튼" src="img/close.png" class="close"></a>
	<p class="wpass">공지사항 삭제</p>
<form method="post" name="frm">
	<label><p class="wpass">패스워드를 입력하세요</p></label>
	<input type="password" class="password" name="pwd"><br>
	<input type="hidden" name="n_idx" value="${noticeView.n_idx }">
	<input type="button" class="bnt" value="삭제" onclick="del_go(this.form)">
</form>
</div>

</div>
<div id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>