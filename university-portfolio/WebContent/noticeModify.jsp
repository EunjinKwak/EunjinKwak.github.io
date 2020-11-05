<%@page import="com.bc.model.vo.NoticeVO"%>
<%@page import="com.bc.model.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인 세션값 가져오기
	StudentVO vo = (StudentVO)session.getAttribute("vo");

	//세션에 저장한거 불러오기 (덮어쓰기 가능)
	NoticeVO noticeView = (NoticeVO)session.getAttribute("NoticeView");
	if(noticeView != null){
	System.out.println("noticeView.getContent() : " + noticeView.getContent());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/noticeModify.css" type="text/css">
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="wrap">
<form method="post" name="frm">
	<table class="tables">
		<p>공지사항 수정</p>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" title="제목" value="${noticeView.title }">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="name" title="작성자" value="${noticeView.name }" readOnly>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="30" title="내용">${noticeView.content }</textarea>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="저장" class="botton" onclick="modify_go(this.form)">
					<input type="reset" value="다시작성" class="botton" >
					<input type="button" value="목록" class="botton" onclick="all_notice(this.form)">
					<input type="hidden" name="n_idx" value="${noticeView.n_idx }" >
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
	function modify_go(frm) {
		alert("공지사항 게시글 수정이 완료되었습니다.");
		frm.action = "Controller?type=noticeModify";
		frm.submit();
	}
</script>
</html>