<%@page import="com.bc.model.vo.CR_BBSVO"%>
<%@page import="com.bc.model.dao.DAO"%>
<%@page import="com.bc.mybatis.Paging"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<title>수강 후기</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/searchList.css" type="text/css">
</head>
<body>
<div id="header">
	<jsp:include page="header.jsp"></jsp:include>
</div>
<p class="titles">수강 후기</p>
<div class="choose">
<form action="Controller?type=CB_Search" method="post">
	<select class="search" name="idx">
		<option value="0" class="titlte">제목</option>
		<option value="1">글쓴이</option>
	</select>
	<input class = "search_k" type="text" name="keyword"  placeholder="조회할 내용을 입력하세요" >
	<input class="searchbnt" type="submit" value="검색">
</form>
</div>
<div class="wrap">
<form name ="CR_BBS">
<table class="tables">
	<colgroup>
		<col width="10%"/>
		<col width="10%"/>
		<col width="40%"/>
		<col width="10%"/>
		<col width="10%"/>
		<col width="10%"/>
	</colgroup>
	<thead>
		<tr class="title">
			<th class="no">번호</th>
			<th class="subjectnum">과목코드</th>
			<th class="title1">제목</th>			
			<th class="writer">글쓴이</th>
			<th class="wrtier_date">날짜</th>
			<th class="hit">힛뜨다 힛트!</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td colspan="6" class="nothing">
					<p>게시글이 없습니다.</p>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach  var="vo" items="${list}">
			<tr>
				<td>${vo.b_idx }</td>
				<td>${vo.subjectnum }</td>
				<td><a class="vieew" href="Controller?type=CB_View&b_idx=${vo.b_idx }&cPage=${pvo.nowPage}">${vo.title }</a></td>
				<td>${vo.writer }</td>
				<td>${vo.writer_date.substring(0,10) }</td>
				<td>${vo.hit }</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
</form>

<div class="write1">
	<form action="Controller?type=CB_Writeview" method="post">
		<input type="submit" name="write" value="글쓰기" class="write">
		<input type="hidden"  name="hakbun" value="${vo.hakbun}">
		<input type="hidden"  name="hakbun" value="${vo.d_num}">
	</form>
</div>

<div class="ps">
				<ol class="paging">
				<li><a href="Controller?type=CR_BBS&cPage=1"><img alt="첫페이지" src="img/첫페이지.jpg" width="100px"  height="100px"></a></li>
				<c:choose>
					<c:when test="${pvo.beginPage == 1}">
						<li class="disable"><img alt="이전" src="img/이전.jpg" width="100px"  height="100px"></li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="Controller?type=CR_BBS&cPage=${pvo.beginPage - 1 }"> <img alt="이전" src="img/이전.jpg" width="100px"  height="100px"></a>
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
							<a href="Controller?type=CR_BBS&cPage=${pageNo }">${pageNo }</a>
						</li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
					
				<c:choose>
					<c:when test="${pvo.endPage >= pvo.totalPage }">
						<li class="disable"><img alt="다음" src="img/다음.jpg" width="100px"  height="100px"></li>
					</c:when>
					<c:otherwise>
						<li><a href="Controller?type=CR_BBS&cPage=${pvo.endPage + 1 }"><img alt="다음" src="img/다음.jpg" width="100px"  height="100px"></a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="Controller?type=CR_BBS&cPage=${pvo.totalPage} "><img alt="마지막페이지" src="img/마지막페이지.jpg" width="100px"  height="100px"></a></li>
				</ol>
</div>
</div>
<div id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
</html>












