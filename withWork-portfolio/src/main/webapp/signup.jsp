<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/mainHead.jsp" %>
</head>
<body>
	<%@ include file="include/nav.jsp" %>
	<div class="mainInner">
		<div class="innerTit join">
			<dl>
				<dt>SIGN UP</dt>
				<dd>WithWork의 회원이 되어 여러가지 서비스를 즐겨보세요.</dd>
			</dl>
		</div>
		<form id="signup" action="register.do" method="post">
        <table class="groupTableForm">
			<caption>회원정보 입력</caption>
        	<colgroup>
        		<col width="20%"/>
        		<col width="70%"/>
        	</colgroup>
        	<tr>
        		<th>이메일</th>
        		<td>
		            <input type="email" id="joinEmail" class="signUpEmail" name="email" placeholder="아이디로 사용 할 이메일">	
		            <div class="test"></div>
        		</td>
        	</tr>
        	<tr>
        		<th>성함</th>
        		<td><input type="text" name="g_name" placeholder="성함" class="signUpGname"></td>
        	</tr>
        	<tr>
        		<th>비밀번호</th>
        		<td><input type="password" name="password" id="pwd1" placeholder="비밀번호"></td>
        	</tr>
        	<tr>
        		<th>비밀번호 확인</th>
        		<td><input type="password" name="pwdConfirm" id="pwd2" placeholder="비밀번호 확인"></td>
        	</tr>
        </table>
    	    <div class="navBtn">
    	    	<button type="button" class="signupBtn">회원가입</button>
        	</div>
		</form>
	</div>
</body>

<script>
	/* 아이디 중복 확인 함수 */
	join();
</script>
</html>