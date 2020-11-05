<%@page import="com.bc.model.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	StudentVO vo = (StudentVO)session.getAttribute("vo");

%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/modify.css" type="text/css">
<script>
function modifyDateF() {
	
	var firstForm = document.forms[6];
	for (var i=0; i<firstForm.elements.length; i++) {
		if (firstForm.elements[i].value.trim() == "") {
			alert(firstForm.elements[i].title + " 입력하세요");
			firstForm.elements[i].focus();
			return;
		}
	}
	var pwd1 = firstForm.elements[2].value; //새로 입력한 암호
	//var pwd1 = document.myform.pwd.value; //새로 입력한 암호 form 태그에 네임을 붙여 속성에 접근
	var pwd2 = firstForm.elements[3].value;
	if (pwd1 != pwd2) {
		alert("비밀번호가 일치하지 않습니다.");
		firstForm.elements[2].value = "";
		firstForm.elements[3].value = "";
		firstForm.elements[2].focus();

		return false;
	}else{
		firstForm.submit();
	}
}
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

</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="pwdCheck">
		<a href="javascript:close(this.form);"><img alt="닫기버튼" src="img/close.png" class="close"></a>
		<form action="Controller?type=modify" method="post">
			<label for="hakbun"><p class="wpass">패스워드를 입력하세요</p></label>
			<input type="password" class="password" name="password" value="" title="비밀번호"><br>
			<input type="button" class="bnt" value="확인" onclick="modifyData()">
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
	<div class="wrap">
		<form action="Controller?type=modifyF" method="post">
			<div class="hakbun">
				<label for="hakbun">학번 </label><br>
				<input type="text" name="hakbun" value="${vo.hakbun}" title="학번" readonly>
			</div>
			<div class="name">
				<label for="name">이름</label><br>
				<input type="text" name="name" value="${vo.name}" title="이름">
			</div>
			<div class="password1">
				<label for="pwd">비밀번호</label><br>
				<input type="password" name="password" value="" title="비밀번호">
			</div>
			<div class="password1">
				<label for="pwdCheck">비밀번호 확인</label><br>
				<input type="password" name="password" value="" title="비밀번호 확인">
			</div>
			<div class="select">
				<label for="select">학과선택</label><br>
				<select name="d_num" title="학과">
					 <option value="">학과선택</option>
					 <option value="E_01" <c:if test="${vo.d_num eq 'E_01'}"> selected</c:if>>전자정보통신</option>
					 <option value="F_01" <c:if test="${vo.d_num eq 'F_01'}"> selected</c:if>>식품영양학과</option>
					 <option value="N_01" <c:if test="${vo.d_num eq 'N_01'}"> selected</c:if>>간호학과</option>
					 <option value="P_01" <c:if test="${vo.d_num eq 'P_01'}"> selected</c:if>>패션디자인과</option>
					 <option value="M_01" <c:if test="${vo.d_num eq 'M_01'}"> selected</c:if>>연극영화과</option>
					 <option value="R_01" <c:if test="${vo.d_num eq 'R_01'}"> selected</c:if>>레크레이션과</option>
				</select>
			</div>
			<div class="phone">
				<label for="phone">핸드폰 번호</label><br>
				<input type="text" name="phone" value="${vo.phone}" title="핸드폰 번호">
			</div>
			<div class="email">
				<label for="email">E-mail</label><br>
				<input type="email" name="email" value="${vo.email}" title="Email">
			</div>
			<div class="bnt1">
				<input type="button" value="수정완료" onclick="modifyDateF()">
				<input type="reset" value="다시작성">
			</div>
		</form>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>