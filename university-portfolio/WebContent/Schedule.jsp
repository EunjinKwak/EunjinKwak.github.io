<%@page import="com.bc.model.vo.StudentVO"%>
<%@page import="com.bc.model.vo.RegistrationVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	StudentVO vo = (StudentVO)session.getAttribute("vo");
    	List<RegistrationVO> list = (List<RegistrationVO>)request.getAttribute("list");
    %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>시간표보기</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/Schedule.css" type="text/css">
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
<link rel="stylesheet" href="css/reset.css" type="text/css">

</head>
<body>
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
	
	<div class="tables">
		<p class="write">${vo.name }님의 시간표</p>
		<table class="tableview">
		 	<p class="write">2020년도 2학기</p>
			<colgroup>
				<col width="15%"/>
				<col width="15%"/>
				<col width="15%"/>
				<col width="15%"/>
				<col width="15%"/>
				<col width="15%"/>
				
			</colgroup>
			<tr>
				<th> </th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
			</tr>
			${scehdule}
		</table>
	</div>
	<div id="footer">
			<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>