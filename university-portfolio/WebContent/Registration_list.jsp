<%@page import="com.bc.model.vo.RegistrationVO"%>
<%@page import="com.bc.model.vo.CartVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bc.model.dao.RegistrationDAO"%>
<%@page import="com.bc.mybatis.Paging"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	String search = (String)session.getAttribute("search");
%> --%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>수강신청 페이지</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/Registration_list.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script>
	if("${warning}" !=""){
		alert("${warning}");
	}
	
	function success(frm){
		alert("수강신청이 완료되었습니다.\n 메인페이지로 이동합니다.");
		location.href="main.jsp";
	}
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include><br>
<div class="wrap">
<p>수강신청</p>
<div class="choose">
<form action="controller?type=sel&cPage=1&searchAll=seek" method="post">
	<select class="search" name="search">
		<option value="7" <c:if test="${search eq '7' }">selected</c:if>>선택해주세요</option>
		<option value="0" <c:if test="${search eq '0' }">selected</c:if>>학과</option>
		<option value="1" <c:if test="${search eq '1' }">selected</c:if>>과목명</option>
		<option value="2" <c:if test="${search eq '2' }">selected</c:if>>교수명</option>
		<option value="3" <c:if test="${search eq '3' }">selected</c:if>>전체보기</option>
	</select>
	<input type="text" class="search_k"  name="keyword" value="${keyword}">
	<input type="hidden" name="hakbun" value="${vo.hakbun }">
	<input type="submit" class="searchbnt" value="검색">
	
</form>
</div>

	<table class="tables">
		<colgroup>
			<col width="10%"/>
			<col width="20%"/>
			<col width="12.5%"/>
			<col width="12.5%"/>
			<col width="15%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
		</colgroup>
		<thead>
			<tr>
				<th>과목번호</th>
				<th>과목명</th>
				<th>담당교수</th>
				<th>강의시간</th>
				<th>강의실</th>
				<th>학점</th>
				<th>정원</th>
				<th>처리</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
			<c:when test="${empty list }">
			<tr>
				<td colspan="8" class="nothing">
					<p>현재 등록된 강의가 없습니다.</p>
				</td>
			</tr>
			</c:when>
			<c:otherwise>
			<c:forEach var="cvo" items="${list }" >
			<form action="controller?type=sel&cPage=${cPage }&search=${search }&searchAll=noseek" method="post">
			<tr>
				<td><input type="text" class="subjectnum" name="subjectnum" value="${cvo.subjectnum }" readonly></td>
				<td><input type="text" class="subject" name="subject" value="${cvo.subject }" readonly></td>
				<td><input type="text" class="name" name="name" value="${cvo.name }" readonly></td>
				<td><input type="text" class="time" name="time" value="${cvo.time }" readonly></td>
				<td><input type="text" class="classroom" name="classroom" value="${cvo.classroom }" readonly></td>
				<td><input type="text" class="grade" name="grade" value="${cvo.grade }" readonly></td>
				<td><input type="text" class="personnel" name="personnel" value="${cvo.personnel }" readonly></td>
				<td><input type="submit" class="select" value="선택" readonly>
					<input type="hidden" name="keyword" value="${keyword }">
					<input type="hidden" name="hakbun" value="${vo.hakbun }">
				</td>
			</tr>
				
			</form>
			</c:forEach>
			</c:otherwise>
			</c:choose>
		</tbody>
		<c:if test="${count > 5 }">
			<tfoot>
			<tr>
				<td colspan="8">
					<ol class="paging">
					<c:choose><%--[이전으로]에 대한 사용여부처리 --%>
						<%--사용불가(disable) 또는 안보이게(hidden) : 첫번째 블록인 경우 --%>
						<c:when test="${pvo.beginPage == 1}">
							<li class="disable">이전으로</li>
						</c:when>
						<c:otherwise>
							<li>
								<a href="controller?type=sel&cPage=${pvo.beginPage - 1 }&hakbun=${vo.hakbun}&search=${search }
								&searchAll=seek&keyword=${keyword }">이전으로</a>
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
								<a href="controller?type=sel&cPage=${pageNo }&hakbun=${vo.hakbun}
								&search=${search }&searchAll=seek&keyword=${keyword }">${pageNo }</a>
							</li>
						</c:otherwise>
					</c:choose>
					</c:forEach>
						
					<c:choose><%--[다음으로]에 대한 사용여부처리 --%>
						<%--사용불가(disable) 또는 안보이게(hidden) : 마지막 블록인 경우
							endPage가 전체페이지수와 같거나 큰 경우 --%>
						<c:when test="${pvo.endPage >= pvo.totalPage }">
							<li class="disable">다음으로</li>
						</c:when>
						<c:otherwise>
							<li><a href="controller?type=sel&cPage=${pvo.endPage + 1 }&hakbun=${vo.hakbun}
							&search=${search }&searchAll=seek&keyword=${keyword }">다음으로</a></li>
						</c:otherwise>
					</c:choose>
					</ol>
				</td>
			</tr>
		</tfoot>
	</c:if>
	</table>
		<p>수강신청 리스트</p>
	<table class="tables">
		<colgroup>
			<col width="15%"/>
			<col width="20%"/>
			<col width="15%"/>
			<col width="15%"/>
			<col width="15%"/>
			<col width="10%"/>
			<col width="10%"/>
		</colgroup>
		<thead>
		<c:if test="${vo.hakbun eq 'admin' }">
			<tr>
			<th>정원</th>
			<td colspan="2"><input type="text" class="s_grade" name="s_grade" value="${sum }" readonly></td>
			<th>신청 인원</th>
			<td colspan="3"><input type="text" class="sum_grade" name="sum_grade" value="${sum_people }" readonly></td>
			</tr>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>E-mail</th>
				<th>핸드폰</th>
				<th>학과번호</th>
				<th>신청가능 학점</th>
				<th>처리</th>
			</tr>
		</c:if>
		<c:if test="${vo.hakbun ne 'admin' }">
			<tr>
			<th>수강가능 학점</th>
			<td colspan="2"><input type="text" class="s_grade" name="s_grade" value="${s_grade }" readonly></td>
			<th>수강 학점</th>
			<td colspan="3"><input type="text" class="sum_grade" name="sum_grade" value="${sum_grade }" readonly></td>
			</tr>
			<tr>
				<th>과목번호</th>
				<th>과목명</th>
				<th>담당교수</th>
				<th>강의시간</th>
				<th>강의실</th>
				<th>학점</th>
				<th>처리</th>
			</tr>
		</c:if>
		</thead>
		<tbody>
			<c:choose>
			<c:when test="${vo.hakbun eq 'admin' }">
				<c:choose>
				<c:when test="${empty shlist }">
				<tr>
					<td colspan="7" class="nothing">
						<p>현재 신청중인 학생이 없습니다.</p>
					</td>
				</tr>
				</c:when>
				<c:when test="${not empty shlist }">
				<c:forEach var="svo" items="${shlist }" >
				<form action="" method="post">
				<tr>
					<td><input type="text" name="subjectnum" value="${svo.hakbun}" readonly></td>
					<td><input type="text" name="subject" value="${svo.name }" readonly></td>
					<td><input type="text" name="name" value="${svo.email }" readonly></td>
					<td><input type="text" name="time" value="${svo.phone}" readonly></td>
					<td><input type="text" name="classroom" value="${svo.d_num }" readonly></td>
					<td><input type="text" name="grade" value="${svo.s_grade }" readonly></td>
					<td><input type="submit" class="delete" value="" readonly>
						<input type="hidden" name="search"value="${search }">
						<input type="hidden" name="keyword"value="${keyword }">
						<input type="hidden" name="hakbun" value="${vo.hakbun }">
					</td>
				</tr>
				</form>
				</c:forEach>
				</c:when>
				</c:choose>
			</c:when>
			<c:when test="${empty cart }">
			<tr>
				<td colspan="7" class="nothing">
					<p>현재 선택한 강의가 없습니다.</p>
				</td>
			</tr>
			</c:when>
			
			<c:otherwise>
			<c:forEach var="cvo" items="${cart }" >
			<form action="controller?type=del&cPage=${cPage }" method="post">
			<tr>
				<td><input type="text" class="subjectnum" name="subjectnum" value="${cvo.subjectnum }" readonly></td>
				<td><input type="text" class="subject" name="subject" value="${cvo.subject }" readonly></td>
				<td><input type="text" class="name" name="name" value="${cvo.name }" readonly></td>
				<td><input type="text" class="time" name="time" value="${cvo.time }" readonly></td>
				<td><input type="text" class="classroom" name="classroom" value="${cvo.classroom }" readonly></td>
				<td><input type="text" class="grade" name="grade" value="${cvo.grade }" readonly></td>
				<td><input type="submit" class="delete" value="삭제" readonly></td>
				<input type="hidden" name="search"value="${search }">
				<input type="hidden" name="keyword"value="${keyword }">
				<input type="hidden" name="hakbun" value="${vo.hakbun }">
				
			</tr>
			</form>
			</c:forEach>
			</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="7">
					<input type="button" class="success" value="수강신청" onclick="success(this.form)">
				</td>
			</tr>
		</tbody>
	</table>
</div>
<div id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</body>
</html>