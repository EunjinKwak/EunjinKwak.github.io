<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%HttpSession ss = request.getSession(true);

	ss.getAttribute("list");
	ss.getAttribute("bvo");
	ss.getAttribute("cPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 정보</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/sub_Inform.css" type="text/css">
</head>
<body>

<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<p class="titles">과목 정보</p>
<div class="choose">
<form action="Controller?type=Sub_Search" method="post" >
	<select class="search" name="idx">
		<option value="0">과목명</option>
		<option value="1">담당교수</option>
	</select>
	<input class="search_k" type="text" name="keyword" placeholder="조회할 내용을 입력하세요">
	<input class="searchbnt" type="submit" value="검색">
</form>
</div>
<div class="wrap">
	<table class="tables">
	<colgroup>
		<col width="10%"/>
		<col width="30%"/>
		<col width="10%"/>
		<col width="20%"/>
		<col width="10%"/>
	</colgroup>
	<thead>
		<tr>
			<th class="code">과목코드</th>
			<th class="subject">과목명</th>
			<th class="pro">담당교수</th>
			<th class="time">강의시간</th>
			<th class="class">강의실</th>
			<th class="view">상세페이지</th>
		</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${empty list }">
			<tr>
				<td colspan="6" class="nothing">
					<p>과목 조회가 안됩니다.</p>
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="sub" items="${list}">
				<form action="Controller?type=Sub_Detail" method="post">
					<tr>
					<td>${sub.subjectnum }</td>
					<td>${sub.subject }</td>
					<td>${sub.name }</td>
					<td>${sub.time }</td>
					<td>${sub.classroom }</td>
					<td><input type="submit" name="Detail" value="선택" class="hi" >
						<input type="hidden" name="subjectnum" value="${sub.subjectnum }">
						<input type="hidden" name="subject" value="${sub.subject }">
						<input type="hidden" name="name" value="${sub.name}">
					</td>
				</tr>
				</form>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<div class="ps">
				<ol class="paging">
				<li><a href="Controller?type=Sub_Inform&cPage=1"> << </a></li>
				<c:choose>
					<c:when test="${pvo.beginPage == 1}">
						<li class="disable"> < </li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="Controller?type=Sub_Inform&cPage=${pvo.beginPage - 1 }"> < </a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:forEach var="pageNo" begin="${pvo.beginPage }" end="${pvo.endPage }">
				<c:choose>
					<c:when test="${pageNo == pvo.nowPage }">
						<li class="now">${pageNo }</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="Controller?type=Sub_Inform&cPage=${pageNo }">${pageNo }</a>
						</li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
					
				<c:choose>
					<c:when test="${pvo.endPage >= pvo.totalPage }">
						<li class="disable"> > </li>
					</c:when>
					<c:otherwise>
						<li><a href="Controller?type=Sub_Inform&cPage=${pvo.endPage + 1 }"> > </a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="Controller?type=Sub_Inform&cPage=${pvo.totalPage} "> >> </a></li>
				</ol>
	</div>
</div>
<div id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>

</body>
</html>