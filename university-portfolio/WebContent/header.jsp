<%@page import="com.bc.model.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//로그인 세션값 가져오기
	StudentVO vo = (StudentVO)session.getAttribute("vo");
	if(vo != null){
		System.out.println("> header 로그인 hakbun : " + vo.getHakbun());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네비게이션바</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/header.css" type="text/css">
<script>
//공지사항 클릭
function all_notice(frm) {
   <%
   if(vo != null){
   %>
      frm.action = "Controller?type=noticeList";
      frm.submit();
   <%
   } else {
   %>   
      alert("로그인을 먼저 해주세요.");
      histoty.back(-1);
   <%
   }
   %>   
}

//로그인 클릭
function login(frm) {
	document.getElementById("wrap").style.display = 'inline';
	/* alert("로그인 얍"); */
/* 	frm.action = "Controller?type=loginjsp"; */
	/* frm.submit(); */
}
//로그아웃 클릭
function logout(frm) {
	alert("${vo.name}님 로그아웃 되었습니다.");
	frm.action = "Controller?type=logoutjsp";
	frm.submit();
}
//회원가입 클릭
function signup(frm) {
	frm.action = "Controller?type=signup";
	frm.submit();
}
//마이페이지 클릭
function mypage(frm) {
	frm.action = "Controller?type=mypage";
	frm.submit();
}
// 수강신청 클릭
function all_search(frm) {
	<%
	if(vo != null){
	%>
		frm.action = "controller?type=all&hakbun=${vo.hakbun}";
		frm.submit();
	<%
	} else {
	%>	
		alert("로그인을 먼저 해주세요.");
		histoty.back(-1);
	<%
	}
	%>	
}

//관리자 클릭
function manager(frm) {
	frm.action = "Controller?type=manager";
	frm.submit();
}
//수강후기 클릭
function CR_BBS(frm) {
	<%
	if(vo != null){
	%>
		frm.action = "Controller?type=CR_BBS";
		frm.submit();
	<%
	} else {
	%>	
		alert("로그인을 먼저 해주세요.");
		histoty.back(-1);
	<%
	}
	%>	
}
//과목정보클릭
function sub_inform(frm) {
	<%
	if(vo != null){
	%>
		frm.action = "Controller?type=Sub_Inform";
		frm.submit();
	<%
	} else {
	%>	
		alert("로그인을 먼저 해주세요.");
		histoty.back(-1);
	<%
	}
	%>	
}
//닫기 클릭
function close2(frm) {
	document.getElementById("wrap").style.display = 'none';
	
}
</script>
</head>
<body>
<div class="header">
	<form method="post">
	<ul>
	  <li><img alt="비트대학교" src="img/logo_2.png" class="Bbutton" onclick="location.href='main.jsp'"></li>
	  <li><input type="button" class="button" value="공지사항" onclick="all_notice(this.form)"></li>
	  <li><input type="button" class="button" value="과목정보" onclick="sub_inform(this.form)"></li>
      <li><input type="button" class="button" value="수강후기" onclick="CR_BBS(this.form)"></li>
	  <li><input type="button" class="button" value="수강신청" onclick="all_search(this.form)"></li>
	  <%
	  if(vo == null){
	  %>
		<li><input type="button" class="button" value="로그인" onclick="login(this.form)"></li>  
		<li><input type="button" class="log" value="   회원가입" onclick="signup(this.form)"></li>
		<!-- <li><input type="button" class="blank" value="공백" ></li> -->
	  <%
	  } else if(vo.getHakbun().equals("admin")){
	  %>
	  <!-- <li><input type="button" class="button" value="마이페이지" onclick="mypage(this.form)"></li> -->
	  <li><input type="button" class="button" value="관리자페이지" onclick="manager(this.form)"></li>
	  <li><input type="button" class="button" value="로그아웃" onclick="logout(this.form)"></li>
	  <%
	  } else {
	  %>
	  <li><input type="button" class="button" value="마이페이지" onclick="mypage(this.form)"></li>
	  <li><input type="button" class="log" value="   로그아웃" onclick="logout(this.form)"></li>
	  <!-- <li><input type="button" class="blank" value="공백" ></li> -->
	  <%
	  } 
	  %>
	</ul>
	</form>
</div>
<div id="wrap">
 <a href="javascript:close2(this.form);"><img alt="닫기버튼" src="img/close.png" class="close"></a>
 <p class="login-form-text" >LOGIN</p>
	<form action="Controller?type=login" method="post" class="loginForm">
		<div class="loginDiv">
			<label for="hakbun" calss="loginLabel">학번</label><br>
			<input type="text" name="hakbun" value="" placeholder="" class="loginInput">
		</div>
		<br>
		<div class="loginDiv">
			<label for="pwd" calss="loginLabel">비밀번호</label><br>
			<input type="password" name="password" value="" placeholder="" class="loginInput">
		<br>
		</div>
		<div class="loginBt">
			<input type="submit" value="로그인">
		</div>
	</form>
	<form action="Controller?type=search" method="post" class="loginForm">
		<div class="loginBt1">
			<input type="submit" name="hakbun" value="학번 및 패스워드 찾기">
		</div>
	</form>
</div>
<div class="darkBack"></div>

</body>
</html>















