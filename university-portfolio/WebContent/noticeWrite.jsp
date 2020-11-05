<%@page import="com.bc.model.dao.DAO"%>
<%@page import="com.bc.model.vo.NoticeVO"%>
<%@page import="com.bc.model.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//로그인 세션값 가져오기
	StudentVO vo = (StudentVO)session.getAttribute("vo");
	
	//새 글의 글번호(n_idx + 1)을 위한 총 갯수 메소드 불러오기
	int totalCount = DAO.getTotalCountNotice();
	pageContext.setAttribute("totalCount", totalCount);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/noticeWrite.css" type="text/css">
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="wrap">
<form method="post" name="frm">
	<table class="tables">
		<p>공지사항</p>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title"title="제목">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="name"title="작성자" value="관리자" readOnly>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="30" title="내용"></textarea>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="저장" class="botton" onclick="write_go(this.form)">
					<input type="reset" value="다시작성" class="botton" >
					<input type="button" value="목록" class="botton" onclick="all_notice(this.form)">
					<input type="hidden" name="n_idx" value="${totalCount + 1 }" >
					<input type="hidden" name="email" value="${vo.getEmail() }" >
					<input type="hidden" name="regdate" value = sysdate >
					<input type="hidden" name="hakbun" value="${vo.getHakbun() }" >
				</td>
			</tr>
		</tfoot>
	</table>
</form>
</div>
<div id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
<script>
	function all_notice(frm) {
		frm.action = "Controller?type=noticeList&cPage=1 ";
		frm.submit();
	}
	function write_go(frm) {
		alert("공지사항 게시글 등록이 완료되었습니다.");
		frm.action = "Controller?type=noticeWrite";
		frm.submit();
	}
</script>
</html>