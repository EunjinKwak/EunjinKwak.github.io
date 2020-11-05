<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 개설</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/managerSubject.css" type="text/css">
</head>
<body>
<div id="header">
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div class="sidebanner">
	<ul>
	   <li>
		   <form action="Controller?type=manager" method="post">
		   		<input type="submit" class="banner" name="전체학생" value="학생 조회"></input>
		   </form>
	   </li>
	   <li>
		   <form action="managerSubject.jsp" method="post">
		   	 	<input type="submit" class="banner" name="강의개설" value="새로운 강의 개설"></input>
		   </form>
	   </li>
	</ul>
</div>
<div class="tableshow">
	<form method="post" name="frm">
		<table class="show">
			<colgroup>
					<col width="10%"/>
					<col width="10%"/>
					<col width="20%"/>
					<col width="10%"/>
					<col width="10%"/>
			</colgroup>
			<caption class="searched">새로운 강의 개설</caption>
			<thead></thead>
			<tbody class="contents">
				<tr>
					<th class="title">강의 코드</th>
					<td>
						<input type="text" name="subjectnum" size="45" title="강의코드" placeholder="예) E_001">
					</td>
				</tr>
				<tr>
					<th class="title">강의명</th>
					<td>
						<input type="text" name="subject" size="45" title="강의명">
					</td>
				</tr>
				<tr>
					<th class="title">강의 시간</th>
					<td>
						<input type="text" name="time" size="45" title="강의시간" placeholder="예) 월(1,2)">
					</td>
				</tr>
				<tr>
					<th class="title">강의실</th>
					<td>
						<input type="text" name="classroom" size="45" title="강의실" placeholder="예) 공학관_201">
					</td>
				</tr>
				<tr>
					<th class="title">학년</th>
					<td>
						<input type="text" name="grade" size="45" title="학년" placeholder="예) 3">
					</td>
				</tr>
				<tr>
					<th class="title">학과</th>
					<td>
						<input type="text" name="d_num" size="45" title="학과" placeholder="예) E_01">
					</td>
				</tr>
				<tr>
					<th class="title">교수</th>
					<td>
						<input type="text" name="f_num" size="45" title="교수" placeholder="예) E_3121">
					</td>
				</tr>
				<tr>
					<th class="title">수강인원</th>
					<td>
						<input type="text" name="personnel" size="45" title="수강인원" placeholder="예) 5">
					</td>
				</tr>
			</tbody>
			
				<div class="bnt1">
					<tr>
						<td colspan="2">
							<input type="button" value="저장" class="bottom" onclick="insert_go(this.form)">
							<input type="reset" value="다시작성" class="bottom">
						</td>
					</tr>
				</div>
		</table>
	</form>
</div>
<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
<script>
	function insert_go(frm) {
		alert("새로운 강의 개설 등록이 완료되었습니다.");
		frm.action = "Controller?type=subjectInsert";
		frm.submit();
	}
</script>
</html>