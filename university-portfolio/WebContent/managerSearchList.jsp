<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bc.model.dao.DAO"%>
<%@page import="com.bc.mybatis.Paging"%>
<%@page import="com.bc.model.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	// EL, JSTL 사용을 위해 scope에 데이터 등록(page 영역)
	pageContext.setAttribute("list", request.getAttribute("list"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 검색 결과</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/managerSearchList.css" type="text/css">

</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<h2 class="searched">학생 검색 결과 </h2>
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
<form method="post" name="frm">
<table>
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
					<p>검색 조건과 일치하는 학생이 없습니다.</p>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${list }" >
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
</form>
</div>
<div id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>