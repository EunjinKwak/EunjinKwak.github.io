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

    
    <!-- 임시 css -->
    
    <style>
    	.mypageBorder {
    		border: 3px solid black;
    	}
    	
    	.mypageBorder input {
		    font-size: 20px;
		    line-height: 30px;
		    border: 1px solid #ddd;
    	}
    	
    	.mypageBorder h2 {
   		    font-size: 30px;
		    font-weight: bold;
    	}
    	
    	.mypageNone {
    		display: none;
    	}
    </style>
</head>
<body>
	<%@ include file="include/nav.jsp" %>
	<div class="mainInner">
		<div class="innerTit myPage">
			<dl>
				<dt>MY PAGE</dt>
				<dd>회원정보 수정/탈퇴</dd>
			</dl>
		</div>
<!-- 
	
	사용하지 않는 기능(버튼)
	
		<ul>
			<li><span id="menu1">회원정보 변경</span></li>
			<c:if test="${sessionScope.authstatus == 'withwork' }">
				<li><span id="menu2">비밀번호 변경</span></li>
			</c:if>
			<li><span id="menu3">회원탈퇴</span></li>
		</ul>
-->
		<div class="mypageTable" id="mypageUpdateName">
			<form id="updateName" method="post">
	        <table class="groupTableForm">
				<caption>회원정보 변경</caption>
	        	<colgroup>
	        		<col width="20%"/>
	        		<col width="70%"/>
	        	</colgroup>
	        	<tr>
	        		<th>성함</th>
	        		<td>
			            <input type="text" name="g_name" value='<c:out value="${sessionScope.g_name }" />'>       		
			            <input type="hidden" name="email" value='<c:out value="${sessionScope.email}" />'>  
	        		</td>
	        	</tr>
	        </table>
     	    <div class="navBtn">
     	    	<input type="button" id="updateNameBtn" class="defaultBtn" value="수정"> 
	        </div>
			</form>
		</div>
		<c:if test="${sessionScope.authstatus == 'withwork' }">
			<div class="mypageTable" id="mypageUpdatePwd">
				<form id="updatePwd" method="post">
		        <table class="groupTableForm mypage">
					<caption>비밀번호 변경</caption>
		        	<colgroup>
		        		<col width="20%"/>
		        		<col width="70%"/>
		        	</colgroup>
		        	<tr>
		        		<th>기존 비밀번호</th>
		        		<td>
				            <input type="password" name="mypagePwd1" placeholder="'기존 비밀번호'를 입력해주세요.">
		        		</td>
		        	</tr>
		        	<tr>
		        		<th>변경 할 비밀번호</th>
		        		<td>
				            <input type="password" name="mypagePwd2" placeholder="'변경 할 비밀번호'를 입력해주세요.">
		        		</td>
		        	</tr>
		        	<tr>
		        		<th>변경 할 비밀번호 확인</th>
		        		<td>
							<input type="password" name="mypagePwd3" placeholder="'변경 할 비밀번호'를 입력해주세요.">
							<input type="hidden" name="email" value='<c:out value="${sessionScope.email}" />'>
		        		</td>
		        	</tr>
		        </table>
	     	    <div class="navBtn">
					<input type="button" id="updatePwdBtn" class="defaultBtn" value="수정">
		        </div>
				</form>
			</div>
		</c:if>
		<div class="mypageTable" id="mypageWithdrawal">
			<form id="withdrawal" action="withdrawal.do" method="post">
	        <table class="groupTableForm">
				<caption>
					회원탈퇴<br/>
					<span>한번 삭제된 계정은 더이상 복구가 불가능하오니 신중하게 선택하시길 부탁드립니다.</span>
				</caption>
	        	<colgroup>
	        		<col width="20%"/>
	        		<col width="70%"/>
	        	</colgroup>
	        	<tr>
	        		<th>회원탈퇴</th>
	        		<td>
						<input type="text" name="withdrawal" placeholder="'회원탈퇴'를 입력해주세요.">
						<input type="hidden" name="email" value='<c:out value="${sessionScope.email}" />'>
	        		</td>
	        	</tr>
	        </table>
     	    <div class="navBtn">
				<input type="button" id="withdrawalBtn" class="defaultBtn" value="탈퇴">
	        </div>
			</form>
		</div>
	</div>
</body>
</html>