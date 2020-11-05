
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// HttpSession ss = request.getSession(true);
// ss.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 후기 -  작성 페이지</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/write.css" type="text/css">
<script>
function send_data() {
	//alert(">> sendData() 시작");
	var firstForm = document.forms[3];
	for (var i=0; i<firstForm.elements.length; i++) {
		if (firstForm.elements[i].value.trim() == "") {
			alert(firstForm.elements[i].title + " 입력하세요");
			firstForm.elements[i].focus();
			return;
		}
	}	
	alert("필력이 출중 하시구만요!");
	alert("합격! 저장해 드림!");
	firstForm.submit();
}

function list_go() {
	location.href = "Controller?type=CR_BBS";
}
</script>

</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class= "wrap"> 
		<p class="title">수강 후기</p>
		<div class="choose">
			<form action="Controller?type=CB_Write" method="post" >
				<select name="subjectnum" class="search">
					<option value="E_001">프로그래밍언어</option>
					<option value="E_002">통신학</option>
					<option value="E_003">정보통신학개론</option>
					<option value="E_004">전자회로</option>
					<option value="E_005">한글과컴퓨터</option>
					<option value="F_001">생화학1</option>
					<option value="F_002">공증보건학</option>
					<option value="F_003">분자생물학</option>
					<option value="F_004">식품화학</option>
					<option value="F_005">유기화학</option>
					<option value="N_001">간호통계학</option>
					<option value="N_002">병태생리학</option>
					<option value="N_003">재활간호학</option>
					<option value="N_004">정신건강간호학</option>
					<option value="N_005">간호연구개론</option>
					<option value="P_001">패션마케팅론</option>
					<option value="P_002">패션드로잉</option>
					<option value="P_003">염색의원리</option>
					<option value="P_004">기초패턴설계</option>
					<option value="P_005">패션창업실무</option>
					<option value="M_001">연극뮤지컬기초</option>
					<option value="M_002">현대연극연구</option>
					<option value="M_003">개발전공연구</option>
					<option value="M_004">공연제작실습</option>
					<option value="M_005">양식과표현</option>
					<option value="R_001">놀이지도</option>
					<option value="R_002">레크레이션원리</option>
					<option value="R_003">레크스포츠</option>
					<option value="R_004">레크관리론</option>
					<option value="R_005">레크지도자론</option>
					<option value="C_001">식생활과건강</option>
					<option value="C_002">글쓰기연습</option>
					<option value="C_003">생활과경제</option>
					<option value="C_004">음악의이해</option>
					<option value="C_005">행복학개론</option>
					<option value="C_006">성의과학</option>
					<option value="C_007">교사인성교육</option>
					<option value="C_008">현대인의정신건강</option>
					<option value="C_009">세계놀이문화</option>
					<option value="C_010">리더쉽교육</option>
				</select>
			
		</div>
	
		<table class="tables">
			<colgroup>
				<col width="30%"/>
			</colgroup>
			<tbody>
				<tr>
					<th class="inline">제목</th>
					<td>
						<input type="text" class="write" name="title" size="45" title="제목" placeholder="제목을 작성해주세요.">
					</td>
				</tr>
				<tr>
					<th class="inline">작성자</th>
					<td>
						<input type="text" class="write" name="writer" size="45" title="작성자" placeholder="이름을 입력해주세요.">
					</td>
				</tr>
				<tr>
					<th class="inline">학번</th>
					<td>
						<input type="password" class="write" name="hakbun" size="12" title="학번" placeholder="재학생이시면 학번을 입력바랍니다.">
					</td>
				</tr>
				<tr>
					<th colspan="2" class="content">내용</th>
				</tr>
				<tr>
					<td colspan="2">
						<textarea class="writing" name="content" rows="15" cols="50" title="내용"  placeholder="수강후기를 입력해주세요."></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" >
						<input type="button" value="저장" onclick="send_data()" class="botton">
						<input type="reset" value="다시작성" class="botton">
						<input type="button" value="목록" onclick="list_go()" class="botton">
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
</html>












