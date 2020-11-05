<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/mainHead.jsp" %>
    <script src="js/nav.js"></script>
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
	    <form id="joinForm">
	        <ul class="join_box">
	            <li class="checkBox check01">
	                <ul class="clearfix">
	                    <li class="checkAllBtn">
	                        <input type="checkbox" name="chkAll" id="chk" class="chkAll">
	                    </li>
	                    <li id="checkAllContent">
				                        이용약관, 개인정보 수집 및 이용,
				                        위치정보 이용약관(선택), 프로모션 정보 수신(선택)
				                        에 모두 동의합니다.
	                    </li>
	                </ul>
	            </li>
	            <li class="checkBox check02">
	                <ul class="clearfix">
	                    <li class="checkBtn">
	                        <input type="checkbox" name="chk" class="requiredBtn1">
	                    </li>
	                    <li>이용약관 동의<span>(필수)</span></li>
	                </ul>
	                <div class="textarea">
				                    여러분을 환영합니다.
				                    WithWork 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 WithWork 서비스의 이용과 관련하여 WithWork 서비스를 제공하는 WithWork 주식회사(이하 ‘WithWork’)와 이를 이용하는 WithWork 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 WithWork 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				
				                    WithWork 서비스를 이용하시거나 WithWork 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
				
				                    다양한 WithWork 서비스를 즐겨보세요.
	                </div>
	            </li>
	            <li class="checkBox check03">
	                <ul class="clearfix">
	                    <li class="checkBtn">
	                        <input type="checkbox" name="chk" class="requiredBtn2">
	                    </li>
	                    <li>개인정보 수집 및 이용 동의<span>(필수)</span></li>
	                </ul>
	                <div class="textarea">
	                    여러분을 환영합니다.
	                    WithWork 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 WithWork 서비스의 이용과 관련하여 WithWork 서비스를 제공하는 WithWork 주식회사(이하 ‘WithWork’)와 이를 이용하는 WithWork 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 WithWork 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
	
	                    WithWork 서비스를 이용하시거나 WithWork 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
	
	                    다양한 WithWork 서비스를 즐겨보세요.
	                </div>
	            </li>
	            <li class="checkBox check04">
	                <ul class="clearfix">
	                    <li class="checkBtn">
	                        <input type="checkbox" name="chk">
	                    </li>
	                    <li>위치정보 이용약관 동의<span>(선택)</span></li>
	                    
	                </ul>
	                <div class="textarea">
				                    여러분을 환영합니다.
				                    WithWork 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 WithWork 서비스의 이용과 관련하여 WithWork 서비스를 제공하는 WithWork 주식회사(이하 ‘WithWork’)와 이를 이용하는 WithWork 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 WithWork 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				
				                    WithWork 서비스를 이용하시거나 WithWork 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
				
				                    다양한 WithWork 서비스를 즐겨보세요.
	                </div>
	            </li>
	            <li class="checkBox check04">
	                <ul class="clearfix">
	                    <li class="checkBtn">
	                        <input type="checkbox" name="chk">
	                    </li>
	                    <li>프로모션 정보 수신 동의<span>(선택)</span></li>
	                    
	                </ul>
	                <div class="textarea">
				                    여러분을 환영합니다.
				                    WithWork 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 WithWork 서비스의 이용과 관련하여 WithWork 서비스를 제공하는 WithWork 주식회사(이하 ‘WithWork’)와 이를 이용하는 WithWork 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 WithWork 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				
				                    WithWork 서비스를 이용하시거나 WithWork 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
				
				                    다양한 WithWork 서비스를 즐겨보세요.
	                </div>
	            </li>
	        </ul>
	        <ul class="footBtwrap clearfix">
	            <li><button class="fpmgBt1"><a href="register.do">동의</a></button></li>
	            <li><button class="fpmgBt2"><a href="main.do">비동의</a></button></li>
	        </ul>
	    </form>
	</div>
</body>
</html>