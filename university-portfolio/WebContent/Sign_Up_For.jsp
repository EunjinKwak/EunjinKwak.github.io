<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/Sign_Up_For.css" type="text/css">

<script>
if("${pwdCheck}" != ""){ // 중복 확인후 메시지 출력
	alert("${pwdCheck}"); 
}
function signDate() {
	
	var firstForm = document.forms[3];
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
function hCheck(){
	var firstForm = document.forms[3];
	if (firstForm.elements[0].value.trim() == "") {
		alert(firstForm.elements[0].title + "을 입력하세요");
		firstForm.elements[0].focus();
		return;
	}
	var hakbun = firstForm.elements[0].value;
	location.href="Controller?type=hCheck&hakbun=" + hakbun + "";
	
}
</script>
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include><br>
</div>
<div class="wrap">
<p class="titles">회원가입</p>
<form action="Controller?type=sign" method="post">
		<div class="hakbun">
			<label for="hakbun">학번</label><br>
			<input type="text" name="hakbun" value="${hakbun }" title="학번">
		</div>
		<div class="bnt1">
			<input type="button" class="bnt1" value="학번확인" onclick="hCheck()">
		</div>
		<div class="name">
			<label for="name">이름</label><br>
			<input type="text" name="name" value="" title="이름">
		</div>
		<div class="password">
			<label for="pwd">비밀번호</label><br>
			<input type="password" name="password" value="" title="비밀번호">
		</div>
		<div class="password">
			<label for="pwdCheck">비밀번호 확인</label><br>
			<input type="password" name="password" value="" title="비밀번호 확인">
		</div>
		<div class="select">
			<p>학과선택</p> 
			<select name="d_num" title="학과">
				 <option value="">학과선택</option>
				 <option value="E_01">전자정보통신</option>
				 <option value="F_01">식품영양학과</option>
				 <option value="N_01">간호학과</option>
				 <option value="P_01">패션디자인과</option>
				 <option value="M_01">연극영화과</option>
				 <option value="R_01">레크레이션과</option>
			</select>
		</div>
		<div class="phone">
			<label for="phone">핸드폰 번호</label><br>
			<input type="text" name="phone" value="" title="핸드폰 번호">
		</div>
		<div class="email">
			<label for="email">E-mail</label><br>
			<input type="email" name="email" value="" title="Email">
		</div>
		<div class="bnt">
		<input type="button" value="회원가입" onclick="signDate()">
		<input type="reset" value="다시작성">
		</div>
	</form>
</div>
<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>