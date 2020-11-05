<%@page import="com.bc.model.dao.DAO"%>
<%@page import="com.bc.model.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	List<StudentVO> list = DAO.getListStudent();
	//System.out.println("> 전체학생목록 : " + list);
	
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/manager.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

</head>
<body>
<div id="header">
	<jsp:include page="header.jsp"></jsp:include>
</div>
<p class="searched">학생 조회 </p>
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
<div class="choose">
	<form method="post" name="frm2" action="Controller?type=managerSearch">
		<select class="search" name="idx">
			<option value="hakbun" selected>학번</option>
			<option value="name">이름</option>
			<option value="email">이메일</option>
			<option value="phone">전화번호</option>
			<option value="d_num">학과</option>
		</select>
		<input type="text" class="search_k" name="keyword" >
		<input type="submit" class="searchbnt" value="검색">
	</form>
</div>
<div class="tableshow">
	<table class="show">
		<colgroup>
				<col width="10%"/>
				<col width="10%"/>
				<col width="20%"/>
				<col width="10%"/>
				<col width="10%"/>
		</colgroup>
		<thead>
			<tr class="title">
				<th>학번</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>학과</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="5" class="nothing">
							<p>데이터 조회 실패</p>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${list }">
						<tr class="contents">
							<td>${vo.hakbun }</td>
							<td>${vo.name }</td>
							<td>${vo.email }</td>
							<td>${vo.phone }</td>
							<td>${vo.d_num }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
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


















