<%@page import="com.bc.model.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    //	StudentVO vo = (StudentVO)session.getAttribute("vo");
    %>
<script>
	function pwdcheck(){
		document.getElementById("pwdCheck").style.display ='inline';
	}
	

	function modifyData(){
		var firstForm = document.forms[3];
		
			if (firstForm.elements[0].value.trim() == "") {
				alert(firstForm.elements[0].title + " 입력하세요");
				firstForm.elements[0].focus();
				return false;
			}

		var pwd1 = firstForm.elements[0].value; //새로 입력한 암호
		
		var pwd2 = "${vo.password}";
		if (pwd1 != pwd2) {
			alert("비밀번호가 일치하지 않습니다.");
			firstForm.elements[0].value = "";
			firstForm.elements[0].focus();
			return false;
		}else{
			firstForm.submit();
		}
	}
	//닫기 클릭
	function close(frm) {
		document.getElementById("pwdCheck").style.display = 'none';
		
	}
</script>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/MyPage.css" type="text/css">
</head>
<body>
<div class="main">
	<div id="header">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="pwdCheck">
		<a href="javascript:close(this.form);"><img alt="닫기버튼" src="img/close.png" class="close"></a>
		<form action="Controller?type=modify" method="post">
			<label for="hakbun"><p class="wpass">패스워드를 입력하세요</p></label>
			<input type="password" class="password" name="password" value="" title="비밀번호"> </input><br>
			<input type="button" class="bnt" value="확인" onclick="modifyData()"></input>
		</form>
	</div>
	<div class="sidebanner">
		<ul>
			<li class="banner">${vo.name }님 안녕하세요</li>
			<li>
				<form action="Controller?type=mypage" method="post">
					<input type="submit" class="banner" name="mypage" value="정보 보기"></input>
				</form>
			</li>
			<li>
				<input type="button" class="banner" value="정보 수정" onclick="pwdcheck()">
			</li>
			<li>
				<form action="Controller?type=schedule" method="post">
					<input type="submit" class="banner" name="schedule" value="시간표 보기"></input>
				</form>
			</li>
		</ul>
	</div>
	<div class="tableshow">
		<table class="show">
		<colgroup>
			<col width="30%"/>
			<col width="70%"/>
		</colgroup>
			<thead>
				<tr>
					<td class="head">학번</td>
					<td>${vo.hakbun}</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="head">이름</td>
					<td>${vo.name}</td>
				</tr>
				<tr>
					<td class="head">학과</td>
					<td>
						<c:if test="${vo.d_num eq 'E_01'}">전자정보통신</c:if>
						<c:if test="${vo.d_num eq 'R_01'}">레크레이션과</c:if>
						<c:if test="${vo.d_num eq 'M_01'}">연극영화과</c:if>
						<c:if test="${vo.d_num eq 'P_01'}">패션디자인과</c:if>
						<c:if test="${vo.d_num eq 'N_01'}">간호학과</c:if>
						<c:if test="${vo.d_num eq 'F_01'}">식품영양학과</c:if>
					</td>
				</tr>
				<tr>
					<td class="head">핸드폰 번호</td>
					<td>${vo.phone}</td>
				</tr>
				<tr>
					<td class="head">E-mail</td>
					<td>${vo.email}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</div>
</body>
</html>