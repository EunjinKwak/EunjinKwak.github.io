<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면에 표시하고, 수정버튼 클릭시 암호확인
	- 암호가 일치하면 : 수정요청처리(DB연동작업) - modify_ok.jsp
	- 암호가 불일치면 : 암호확인 메시지 표시 --%>
<%

String c_idx = request.getParameter("c_idx");	
String b_idx = request.getParameter("b_idx");
String hakbun = request.getParameter("hakbun");

pageContext.setAttribute("c_idx", c_idx);
pageContext.setAttribute("hakbun", hakbun);
pageContext.setAttribute("b_idx", b_idx);

HttpSession ss = request.getSession(true); 
ss.getAttribute("list");
ss.getAttribute("bvo");
ss.getAttribute("cPage");
ss.getAttribute("bvo");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 후기 - 수정 페이지</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/CB_modify.css" type="text/css">
<script>
function send_data() {
	var hakbun1 = document.myForm.hakbun.value; //새로 입력된 값
	var hakbun2 = "${bvo.hakbun}"; //DB에 저장된 패스워드 값
	var firstForm = document.forms[3];
	//게시글 항목에 값 유무 체크
	for (var i=0; i<firstForm.elements.length; i++) {
		if (firstForm.elements[i].value.trim() == "") {
			alert(firstForm.elements[i].title + " 입력하세요");
			firstForm.elements[i].focus();
			return;
		}else if (hakbun1 != hakbun2) {
			alert("입력하신 학번이 일치하지 않습니다. 확인하세요");
			document.myForm.hakbun.value = "";
			document.myForm.hakbun.focus();
			return;	
		}
		}
		alert('수정 완료!')
		document.myForm.action="Controller?type=CB_Modify";
		document.myForm.submit();
		
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

<div class="wrap">
<p class="titles">수강 후기</p>
<form method="post" name="myForm">
	<table class="tables">
		<colgroup>
			<col width="30%"/>
		</colgroup>
		<tbody>
			<tr>
				<th class="inline">제목</th>
				<td>
					<input type="text" name="title" size="45" title="제목"  class="getline" value="${bvo.title }">
				</td>
			</tr>
			<tr>
				<th class="inline">작성자</th>
				<td>
					<input type="text" name="writer" size="45" title="작성자" class="getline"
							value="${bvo.writer } " readonly>
				</td>
			</tr>
			<tr>
				<th class="inline">학번</th>
				<td>
					<input type="password" name="hakbun" size="12" title="학번" class="getline" placeholder="수정 하시려면 학번을 입력바랍니다.">
				</td>
			</tr>
			<tr>
				<th  colspan="2" class="proposal">내용</th>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" rows="20" cols="50" title="내용" class="content">${bvo.content }</textarea>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2" class="bottons">
					<input type="button" value="수정" onclick="send_data()" class="botton">
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












