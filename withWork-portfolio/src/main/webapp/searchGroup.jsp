<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/mainHead.jsp" %>
    
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
    <script src="js/nav.js"></script>
</head>

	<!-- 임시 css -->
	<style>
		.getGroup {
			color: blue;
			cursor: pointer;
		}

	</style>

<body>
	<%@ include file="include/nav.jsp" %>
	<div class="mainInner">
		<div class="innerTit groupImg">
			<dl>
				<dt>현재 생성된 그룹 목록입니다.</dt>
				<dd>WithWork의 회원은 물론 비회원도 그룹을 조회 할 수 있습니다.</dd>
			</dl>
		</div>
		<div class="searchSelect">
			<form action="searchGroup.do" id="searchForm">
				<select name="type">
					<option>그룹 테마별 검색</option>
					<option value="P">개인</option>
					<option value="C">회사</option>
					<option value="E">기타</option>
				</select>
				<input type="hidden" name="pageNum" value="${sgPageMaker.cri.pageNum }">
           		<input type="hidden" name="amount" value="${sgPageMaker.cri.amount }">
				<button type="submit" class="searchBtn">검색</button>
			</form>
		</div>
        <table class="mainTableForm">
        	<tr>
        		<th>번호</th>
        		<th>그룹 이름</th>
        		<th>그룹 테마</th>
        		<th>생성자</th>
        		<th>등록일</th>
        	</tr>
        	<c:choose>
        		<c:when test="${empty groupList}">
		        	<tr>
		        		<td colspan="5"> 조회된 그룹이 없습니다. </td>
		        	</tr>
        		</c:when>
        		<c:otherwise>
        			<c:forEach var="list" items="${groupList}">
			        	<tr>
			        		<td>${list.rn }</td>
			        		<td class="getGroup">
			        			<a href="javascript:void(0);" onclick="getGroup('${list.c_num}')">
			        				${list.name}
			        			</a>
		        			</td>
			        		<td>${list.subject }</td>
			        		<td>${list.g_name }</td>
			        		<td>${list.regdate }</td>
			        	</tr>
        			</c:forEach>
        		</c:otherwise>
        	</c:choose>
        </table>
	</div>
	
	
	<!-- end Pagination -->	                
	
	
    <div class="popup getGroup">
    	<dl>
    		<dt>그룹 정보</dt>
    		<dd>
				<table class="groupTable" style="margin-top: 0;">
		        	<colgroup>
		        		<col width="20%"/>
		        		<col width="70%"/>
		        	</colgroup>
		        	<tr>
		        		<th>그룹 이름</th>
		        		<td id="getGName"></td>
		        	</tr>
		        	<tr>
		        		<th>그룹 테마</th>
		        		<td id="getGSub"></td>
		        	</tr>
		        	<tr>
		        		<th>이름</th>
		        		<td id="getGG_Name"></td>
		        	</tr>
		        	<tr>
		        		<th>등록일</th>
		        		<td id="getGDate"></td>
		        	</tr>
		        	<tr>
		        		<th>부서목록</th>
		        		<td>
		        			<select id="deptList"></select>
		        		</td>
		        	</tr>
		        	<tr>
		        		<th>직책목록</th>
		        		<td>
		        			<select id="roleList"></select>
		        		</td>
		        	</tr>
	        	</table>
				<div class="navShortBtn">
					<button class="defaultBtn searchOk">확인</button>
				</div>
    		</dd>
    	</dl>
    </div>
    <div class="darkBack"></div>
</body>
</html>