<%@page import="com.bc.model.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인 세션값 저장하기
	StudentVO svo = (StudentVO)request.getAttribute("vo");
	if(svo != null){
	session.setAttribute("vo", svo);
	StudentVO vo = (StudentVO)session.getAttribute("vo");
	System.out.println("svo : " + svo.getHakbun() + ", vo : " + vo);
	}
	
	String success = (String)request.getAttribute("success");//로그인 성공 메시지
	
	String fail = (String)request.getAttribute("fail");
	System.out.println("fail :" + fail);
%>  
<script>

	if("${success}" != ""){ // 로그인 성공시 메시지 출력!
		alert("${success}"); 
	}
	if("${fail}" != ""){
		alert("${fail}");
}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>

$(document).ready(function() {
	var $banner = $(".banner").find("ul");

	var $bannerWidth = $banner.children().outerWidth();//이미지의 폭
	var $bannerHeight = $banner.children().outerHeight(); // 높이
	var $length = $banner.children().length;//이미지의 갯수
	var rollingId;

	//정해진 초마다 함수 실행
	rollingId = setInterval(function() { rollingStart(); }, 2000);

	function rollingStart() {
		$banner.css("width", $bannerWidth * $length + "px");
		$banner.css("height", $bannerHeight + "px");
		$banner.animate({left: - $bannerWidth + "px"}, 500, function() { 
			$(this).css("left", 0);
			$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
			$(this).find("li:first").remove();
			$(this).css("left", 0);
		});
	}
});
</script>
</head>
<body>
	<div class="main">
		<div id="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
		<div id="soge">
			<img alt="소개이미지" src="img/soge_3.png" width="100%" height="auto">
		</div>
		<div class="contents">
			<div class="banner">
				<ul>
					<li><img src="img/main.jpg" width="340px" height="210px"></li>
					<li><img src="img/main_1.png" width="340px" height="210px"></li>
					<li><img src="img/main_2.jpg" width="340px" height="210px"></li>
					<li><img src="img/main_3.jpg" width="340px" height="210px"></li>
					<li><img src="img/main_4.jpg" width="340px" height="210px"></li>
					<li><img src="img/main_5.jpg" width="340px" height="210px"></li>
					<li><img src="img/main_6.jpg" width="340px" height="210px"></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="foot">
		<p class="fo">
			비트캠프 서울시 서초구 강남대로 459 (서초동, 백암빌딩)｜ 사업자등록번호 : 214-85-24928<br><br>
			(주)비트컴퓨터 서초본원 대표이사 : 조현정 / 문의 : 02-3486-9000 / 팩스 : 02-6007-1245<br><br>
			통신판매업 신고번호 : 제 서초-00098호 / 개인정보보호관리책임자 : 최종진
		</p>
	</div>
</body>
</html>