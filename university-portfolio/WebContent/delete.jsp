<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 후기 - 게시글 삭제 페이지</title>
<style>
#footer {
		width: 100%;
		text-align:center;
		margin: 0 auto 5% auto;
		font-size: 1rem;
		background-color: #0B2161;
		color: white;
	}
 	.btn1{
		background-color:#0B2161;
		border: 1px solid #0B2161;
		text-decoration: none;
        font-size: 1.2rem;
        display : inline-block;
        border-radius: 5px;
        padding: 5px 3px 10px 4px;
        transition: all 0.1s;
        color: white;
        text-shadow: 0px -2px rgba(0,0,0,0.5);
        font-family: 'Orbitron', sans-serif;
		}
		 #header {
		    height: 70px;
		 }
		.hii{
			font-size: 1.5em;
			margin-top: 50px;
			text-align: center;
			
		}
		.hakbun{
		border: 2px solid #0B2161;
		}
		.h1{
		text-align: center;
		font-style:italic;
		margin-top: 300px; 
		}
</style>
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<h1 class="h1">수강 후기 삭제</h1>
<div class="hii">
<form action="Controller?type=CB_Delete" method="post">
	 학번 : <input type="password" name="hakbun" class="hakbun" placeholder="학번을 입력 바랍니다.">
	<input type="button" value="삭제" onclick="del_go(this.form)"  class="btn1">
	<input type="hidden" name="b_idx" value="${bvo.b_idx}">
</form>
</div>
<script>
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
	
</script>

</div>
<br><br><br><br><br><br>
<br>
<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>












