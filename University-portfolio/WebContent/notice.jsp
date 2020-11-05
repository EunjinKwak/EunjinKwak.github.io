<%@page import="com.bc.model.vo.StudentVO"%>
<%@page import="com.bc.model.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.bc.model.dao.DAO"%>
<%@page import="com.bc.mybatis.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	//로그인 세션값 가져오기
	StudentVO vo = (StudentVO)session.getAttribute("vo");
%>

<%
	
	//페이징 처리를 위한 Paging 객체 생성해서 값 읽고 설정
	Paging p = new Paging();

	//1. 전체 게시물의 수를 구하기
	p.setTotalRecord(DAO.getTotalCountNotice());
	p.setTotalPage();
	System.out.println("> 전체 게시글 수 : " + p.getTotalRecord() + " / 전체 페이지 수 : " + p.getTotalPage());
	
	//2. 현재 페이지 구하기
	String cPage = request.getParameter("cPage");
	
	if (cPage != null) {
		p.setNowPage(Integer.parseInt(cPage));
	} 
	
	//3. 현재 페이지에 표시할 게시글 시작번호(begin), 끝번호(end) 구하기
	p.setEnd(p.getNowPage() * p.getNumPerPage()); //현재페이지번호 * 페이지당글수
	p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
	
	//(선택적) 3-1 끝 글번호가 데이터건수보다 많아지면 데이터 건수와 동일한 번호로 설정
	if (p.getEnd() > p.getTotalRecord()) {
		p.setEnd(p.getTotalRecord());
	}
	System.out.println(">> 현재페이지 : " + p.getNowPage() + " / 시작번호(begin) : " + p.getBegin() + " / 끝번호(end) : " + p.getEnd());
	
	//---- 블록(block) 계산하기 -----------
	//4. 블록의 시작페이지, 끝페이지 구하기(현재 페이지 번호 사용)
	//시작페이지 번호 구하기
	int nowPage = p.getNowPage();
	int beginPage = (nowPage - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
	p.setBeginPage(beginPage);
	p.setEndPage(p.getBeginPage() + p.getPagePerBlock() - 1);
/*
	(개인실습) 위의 시작페이지, 끝페이지 구하기 방식을
	현재페이지가 위치한 블록값을 구하고
	블록값을 기준으로 끝페이지 구한 후 시작페이지 구하기 
*/
	//4-1 끝페이지(endPage)가 전체 페이지 수(totalPage) 보다 크면
	// 끝페이지를 전체페이지수로 변경처리
	if (p.getEndPage() > p.getTotalPage()) {
		p.setEndPage(p.getTotalPage());
	}
	System.out.println(">>> 시작페이지(beginPage) : " + p.getBeginPage() + " / 끝페이지(endPage) : " + p.getEndPage());
%>
<%
	//=============================================
	//현재 페이지 기준으로 DB데이터(게시글) 가져오기
	//시작글번호, 끝 글번호로 Map 데이터 만들기(전달할 파라미터 값)
	Map<String, Integer> map = new HashMap<>();
	map.put("begin", p.getBegin());
	map.put("end", p.getEnd());
	
	List<NoticeVO> list = DAO.getListNotice(map); 
	//System.out.println("> 현재페이지 글목록(list): " + list);
%>
<% 
	//================================
	// EL, JSTL 사용을 위해 scope에 데이터 등록(page 영역)
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("pvo", p);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/notice.css" type="text/css">

</head>
<body>
<div id="header">
<jsp:include page="header.jsp"></jsp:include>
</div>
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
	<tfoot>
		<tr>
			<td colspan="4">
				<ol class="paging">
				<li><a href="notice.jsp?cPage=1"> << </a></li>
				<c:choose><%--[이전으로]에 대한 사용여부처리 --%>
					<%--사용불가(disable) 또는 안보이게(hidden) : 첫번째 블록인 경우 --%>
					<c:when test="${pvo.beginPage == 1}">
						<li class="disable"> < </li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="notice.jsp?cPage=${pvo.beginPage - 1 }"> < </a>
						</li>
					</c:otherwise>
				</c:choose>
				<%-- 블록내에 표시할 페이지 태그 작성(시작페이지~끝페이지) --%>	
				<c:forEach var="pageNo" begin="${pvo.beginPage }" end="${pvo.endPage }">
				<c:choose>
					<c:when test="${pageNo == pvo.nowPage }">
						<li class="now">${pageNo }</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="notice.jsp?cPage=${pageNo }">${pageNo }</a>
						</li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
					
				<c:choose><%--[다음으로]에 대한 사용여부처리 --%>
					<%--사용불가(disable) 또는 안보이게(hidden) : 마지막 블록인 경우
						endPage가 전체페이지수와 같거나 큰 경우 --%>
					<c:when test="${pvo.endPage >= pvo.totalPage }">
						<li class="disable"> > </li>
					</c:when>
					<c:otherwise>
						<li><a href="notice.jsp?cPage=${pvo.endPage + 1 }"> > </a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="notice.jsp?cPage=${pvo.totalPage }"> >> </a></li>
				</ol>
			</td>
			<td>
				<input type="button" class="write" value="글쓰기" onclick="write_go(this.form)">
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
<script>
	function write_go(frm){
		if ("${vo.getHakbun() }" == "admin" ){
			alert("관리자 계정이 확인되었습니다.\n해당 페이지로 이동합니다.");
			frm.action = "noticeWrite.jsp";
			frm.submit();
		} else {
			alert("권한이 없습니다.")
			histoty.back(-1);
		}
	}
</script>
</html>