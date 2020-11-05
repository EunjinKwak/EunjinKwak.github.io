<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%String fail = (String)request.getAttribute("fail");
System.out.println("fail :" + fail);
%>
<script>
	if("${fail}" != ""){
		alert("${fail}");
	}
</script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/Search.css" type="text/css">

</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<p class="searchid">학번 찾기</p>
<div class="wrap">
<form action="Controller?type=id" method="post">
	<div class="email">
		<label for="email"><p class="wpass">E-mail</p></label>
		<input type="text" name="email" value="">
	</div>
	<div class="bnt1">
		<input type="submit" class="bnt" name="id" value="학번 찾기">
	</div>
</form>
<form action="Controller?type=pwd" method="post">
	<div class="hakbun">
		<label for="hakbun"><p class="wpass">학번</p></label>
		<input type="text" name="hakbun" value="">
	</div>
	<div class="phone">
		<label for="phone"><p class="wpass">핸드폰 번호</p></label>
		<input type="text" name="phone" value="">
	</div>
	<div class="password">
		<input type="submit" class="bnt" name="pwd" value="패스워드 찾기">
	</div>
</form>

</div>
<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>