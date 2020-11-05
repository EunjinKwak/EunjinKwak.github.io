<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/view.css" type="text/css">
<script>
	function modify_go() {
		document.frm.action = "Controller?type=CB_Modifyview&b_idx=${bvo.b_idx }&cPage=${pvo.nowPage}";
		document.frm.submit();
	}
	function delete_go() {
		
		document.getElementById("pwdCheck").style.display ='inline';
		
	}
	function list_go() {
		document.frm.action = "Controller?type=CR_BBS";
		document.frm.submit();	 
	}
	/* function del_go() {
		document.frm.action = "Controller?type=CB_Deleteview&b_idx=${bvo.b_idx }&cPage=${pvo.nowPage}";
		document.frm.submit(); 
	} */
	function del_go(frm) {
		var hakbun1 = frm.hakbun.value; //새로 입력한 암호
		var hakbun2 = "${bvo.hakbun}"; //"" 이부분 잘 파악해서 쓰자.
		if (hakbun1 != hakbun2) {
			alert("학번이 일치하지 않습니다. 재학생 맞으세요?");
			frm.hakbun.value ="";
			frm.hakbun.focus();
			return false;
		}
		var isDelete = confirm("게시글을 삭제 하시겠습니까?");
		if (isDelete) {
			alert("잘못 누르신거 아니시죠?");
			alert("후회 안하시죠?");
			alert("확실 하신거 맞으시죠?");
			alert("지우시겠습니다.?");
			alert("삭제");
			alert("삭제 완료");
			frm.submit(); //삭제처리 진행
		} else {
			history.back(); //삭제취소하고 이전페이지로 이동
		}
	}

function close(frm) {
	document.getElementById("pwdCheck").style.display = 'none';
	
}
	
	
	
</script>
</head>
<body>

<div id="header">
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div id="pwdCheck">
<a href="javascript:close(this.form);"><img alt="닫기버튼" src="img/close.png" class="close"></a>
<form action="Controller?type=CB_Delete" method="post">
	 <p class="wpass">학번</p>
	<input type="password" name="hakbun" class="hakbun" placeholder="학번을 입력 바랍니다."><br>
	<input type="button"  class="btn1" value="삭제" onclick="del_go(this.form)" >
	<input type="hidden" name="b_idx" value="${bvo.b_idx}">
</form>
</div>
<div class= "wrap">
<p class="title">상세보기</p>
<%-- 게시글 내용 표시 --%>
<form method="post" name="frm">
	<table class="table">
		<colgroup>
			<col width="30%"/>
		</colgroup>
		<tbody>
			<tr>
				<th class="inline">제목</th>
				<td class="getline">${bvo.title}</td>
			</tr>
			<tr>
				<th class="inline">작성자</th>
				<td class="getline">${bvo.writer }</td>
			</tr>
			<tr>
				<th class="proposal" colspan="2">내용</th>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" class="content">${bvo.content }</td>
			</tr>
		</tfoot>
	</table>

	<div class="bottons">
		<input type="button" value="수정" onclick="modify_go()" class="botton">
		<input type="button" value="삭제" onclick="delete_go()" class="botton">
		<input type="button" value="목록" onclick="list_go()" class="botton">
		<input type="hidden" name="cPage" value="${cPage }">
    </div>
</form>

<%-- 게시글에 대한 댓글 작성 영역 --%>
<form action="Controller?type=C_Write" method="post">
	<div class="comment">
		<hr class="hr">
		<p class="write">이름 : <input type="text"  class="writer" name="writer" placeholder="이름을 입력해주세요." ></p>
		<p class="write">학번 : <input type="password" name="hakbun" class="writer" placeholder="학번을 입력해주세요." ></p>
		<hr class="hr">	
	</div>
	<p class="write">내용 : <textarea class="writing" name="content" rows="10" cols="55	" class="content2" placeholder="댓글을 입력해주세요." ></textarea></p>
	
	<input type="submit" value="댓글저장" class="botton" >
	<input type="hidden" name="b_idx" value="${bvo.b_idx }">
	<input type="hidden" name="cPage" value="${cPage }">

</form>

<c:forEach var="commVO" items="${c_list }">
<div class="comment">
	<form  method="post" action="Controller?type=C_Deleteview" >
	<p class="write">댓글</p>
		<p class="write">이름 : ${commVO.writer }&nbsp;&nbsp; 날짜 : ${commVO.writer_date } </p>
		<p class="write">내용 : ${commVO.content }</p>
		<input type="submit" value="댓글삭제"  class="botton" >
		<input type="hidden" name="c_idx" value="${commVO.c_idx }">
		<input type="hidden" name="hakbun" value="${commVO.hakbun }">
		<input type="hidden" name="b_idx" value="${commVO.b_idx }">
		<input type="hidden" name="cPage" value="${cPage }">
	</form>
</div>
</c:forEach>
</div>

	<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>












