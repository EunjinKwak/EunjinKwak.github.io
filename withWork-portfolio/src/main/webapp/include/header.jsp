<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    <header>
		<script>
		var g_name = '<c:out value="${guest.g_name}" /> <c:out value="${guest.role}" />';
		</script>
        <dl class="groupInfo headerInner">
            <dt>${guest.c_name }</dt>
            <dd>
                <img src="img/user.png" alt="">
                <span>${guest.g_name }</span>님, 안녕하세요.
                <input type="hidden" class="loginMNUM" value="${guest.m_num }">
                <input type="hidden" class="loginDEPART" value="${guest.depart }">
		    	<input type="hidden" class="guestInfo" value="${guest.g_name} ${guest.role}">
            </dd>
        </dl>
        <ul class="allInfo">
            <li><a href="groupLogin.do?c_num=${guest.c_num }" class="todoIcon">TO-DO</a></li>
            <li><a href="getAllConfirm.do?page=1&perPageNum=3&tab=1" class="confirmIcon">CONFIRM</a></li>
            <li><a href="roadmap.do" class="roadMapIcon">ROADMAP</a></li>
        </ul>
        <dl class="headerInner">
            <dt>참여중인 프로젝트</dt>
            <dd class="projectSearch">
                <input type="text" placeholder="프로젝트명을 입력해주세요.">
                <input type="button" value="">
            </dd>
        </dl>
        <ul class="projectList">
            <!-- <li>
                <a href="#" class="projectTit">SAMSUNG 리뉴얼</a>
                <ul>
                    <li><a href="projectTodo.jsp">TO-DO</a></li>
                    <li><a href="notice.html">NOTICE</a></li>
                </ul>
            </li> -->
        </ul>
    </header>
