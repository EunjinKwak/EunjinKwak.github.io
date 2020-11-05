<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="include/head.jsp" %>
    <link rel="stylesheet" href="css/notice.css">
</head>
<body>
	<%@ include file="include/header.jsp" %>
    <section>
    	<input type="hidden" class="p_num" value="${project.p_num }">
        <dl class="conTit">
            <dt class="conTitM">공지사항
                <!-- <a href="#" class="noticeImg1">
                    <img src="img/bell.png" alt="" width="24px">
                </a>
                <a href="#" class="noticeImg2">
                    <img src="img/user2.png" alt="" width="19px">
                </a> -->
            </dt>
            <dd>${project.p_name } 프로젝트의 공지사항을 확인해보세요.</dd>
        </dl>
        <div class="chatBox" id="chatBoxId">
            <!-- <p>
                <span>2020년 12월 8일 화요일</span>
            </p> -->
            <!-- <dl>
                <dt>권은영 팀장</dt>
                <dd class="chatBoxCont1">여러분, 카트 덤비세요~</dd>
                <dd class="chatTime">오후 11:57</dd>
            </dl> -->
            <%-- <c:forEach var="chat" items="${notice }">
	            <dl>
	                <dt>${chat.g_num } ${chat.role }</dt>
	                <dd class="chatBoxCont1">${chat.message }</dd>
	                <dd class="chatTime">${chat.time }</dd>
	            </dl>
            </c:forEach> --%>
           
            <!-- <ul>
                <li class="chatBoxCont2">ㄴㅇㅁ라ㅕㅈ마ㅓㅜ</li>
                <li class="chatTime2">오후 11:59</li>
            </ul>
            <ul>
                <li class="chatBoxCont2">ㄴㅁ려ㅑㅗ뮈ㅈ</li>
                <li class="chatTime2">오후 11:59</li>
            </ul> -->
            
            <!-- <dl>
                <dt>박실 대리</dt>
                <dd class="chatBoxCont1">ㅋㅋㅋ</dd>
                <dd class="chatTime">오전 09:37</dd>
            </dl>
            <dl>
                <dt>곽은진 과장</dt>
                <dd class="chatBoxCont1">나 속상해 ㅠㅠㅠ</dd>
                <dd class="chatTime">오전 09:41</dd>
            </dl>
            <dl>
                <dt>원윤희 사원</dt>
                <dd class="chatBoxCont1">왜그래요 은진씨</dd>
                <dd class="chatTime">오전 09:43</dd>
            </dl>
            <dl>
                <dt>유영준 인턴</dt>
                <dd class="chatBoxCont1">설문조사 하겠습니다.</dd>
                <dd class="chatTime">오전 09:50</dd>
            </dl>
            <dl>
                <dt>유영준 인턴</dt>
                <dd class="chatBoxCont1">설문조사 완료되면 제 자리에 갖다놔 주세요 반장님 ^^</dd>
                <dd class="chatTime">오전 09:51</dd>
            </dl>
            <dl>
                <dt>이민형 사원</dt>
                <dd class="chatBoxCont1">...네</dd>
                <dd class="chatTime">오전 10:26</dd>
            </dl> -->
        </div>
        <div class="chatFoot">
        
        	<form action="insertNotice.do" method="post">
        	
            <ul class="fileUpload">
                <li>
                    <a href="#">
                        <img src="img/plus2.png" alt="" width="30px">
                    </a>
                </li>
                <li class="chatSendBox">
                    <textarea rows="5px" placeholder="메세지를 입력하세요." name="message" class="textarea"></textarea>
                    <input type="button" value="전송" class="sendBtn">
                </li>
            </ul>
            
            </form>
            
        </div>
    </section>
    <%@ include file="include/footer.jsp" %>
    <script>
    
    $().ready(function(){
    	var locationPNUM = $(".p_num").val();
    	
    	$(".projectList li").each(function(){
    		var p_num = $(this).attr("data-index");
    		if(locationPNUM == p_num){
    			$("header li").removeClass("active");
    			$(this).addClass("active");
    		}
    	});
    	
	    getNoticeList();
    	$(".chatBox").scrollTop($(".chatBox")[0].scrollHeight);	
    	
    	//setInterval(getNoticeList, 1000); //1초 간격
    })
    </script>
</body>
</html>