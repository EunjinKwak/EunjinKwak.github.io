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
<title>공지사항 검색 완료</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/noticeSearchList.css" type="text/css">
</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
<p class="searched"> 검색 결과 </p>
<div class="choose">
<form method="post" name="frm2" action="Controller?type=noticeSearch">
	<select class="search" name="idx">
		<option value="title" selected>제목</option>
		<option value="content">내용</option>
		<option value="whole">전체보기</option>
	</select>
	<input type="text" class="search_k" name="keyword" >
	<input type="submit" class="searchbnt" value="검색">
</form>
</div>
<div class="wrap">
<form method="post" name="frm">
<table class="tables">
	<colgroup>
		<col width="10%"/>
		<col width="30%"/>
		<col width="10%"/>
		<col width="20%"/>
		<col width="10%"/>
	</colgroup>
	<thead>
		<tr class="title">
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
	</thead>
 	<tbody>
		<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td colspan="5" class="nothing">
					<p>현재 등록된 게시글이 없습니다.</p>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${list }" >
			<tr>
				<td>${vo.n_idx }</td>
				<td class="align-left">
					<a href="Controller?type=noticeView&n_idx=${vo.n_idx }&cPage=${pvo.nowPage }">${vo.title }</a>
				</td>
				<td>${vo.name }</td>
				<td>${vo.regdate }</td>
				<td>${vo.hit }</td>
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