<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="include/head.jsp" %>
    
    <link rel="stylesheet" href="css/work.css">
    
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/work.js"></script>
</head>
<body>
    <%@ include file="include/header.jsp" %>
    <section>
        <dl class="conTit department" style="border-bottom: 0;">
            <dt>
                TO-DO
                <a href="#" class="workAddBtn"><img src="img/todoAdd.png" alt="" width="35"></a>
            </dt>
            <dd>오늘의 할 일을 확인해보세요.</dd>
        </dl>
        <div class="todoTab">
            <ul class="todoNav">
            </ul>
            <ul class="todoCont">
            </ul>
        </div>
        <dl class="conTit department bigMG">
            <dt class="dtImg">
				<c:choose>
				    <c:when test="${empty guest.depart}">
						부서를 등록해주세요.
				    </c:when>
				    <c:otherwise>
						${guest.depart}
				    </c:otherwise>
				</c:choose>
                <!-- <a href="#" class="teamAddBtn"><img src="img/teamAdd.png" alt="" width="35"></a> -->
            </dt>
            <dd>팀원들의 업무를 확인해보세요.</dd>
        </dl>
        <div class="departTodo smallMG">
        </div>        
    </section>
    <%@ include file="include/footer.jsp" %>
    <div class="popup workPopup">
        <dl>
            <dt>
            	업무 상세보기
            	<a href="#">X</a>
           	</dt>
            <dd>
		        <form method="post">
                <input type="hidden" name="t_num" class="t_num">
                <div class="table workDetail">
                    <table>
                        <colgroup>
                            <col width="15%">
                            <col width="30%">
                            <col width="15%">
                            <col width="30%">
                        </colgroup>
                        <tr>
                            <th>분류</th>
                            <td colspan="3" class="workCategory">
                                <select disabled>
                                    <option selected></option>
                                </select>  
                                <input type="hidden" name="p_num">
                            </td>
                        </tr>
                        <tr>
                            <th>업무</th>
                            <td colspan="3" class="workPopTit">
                            	<input type="text" name="title">
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="3" class="workPopTxt">
                            	<input type="text" name="text">
                            </td>
                        </tr>
                        <tr>
                            <th>지시자</th>
                            <td class="workPopLeader">
                                <select disabled>
                                    <option selected ></option>
                                </select>
                                <input type="hidden" name="order_m">
                            </td>
                            <th>업무자</th>
                            <td class="workPopWorker">
                                <select name="worker_m">
                                    <option value="" selected></option>
                                </select>                            
                            </td>
                        </tr>
                        <tr>
                            <th>기한</th>
                            <td colspan="3" class="workPopTime">
                                <input type="date" name="orderdate">
                                &nbsp;~&nbsp;
                                <input type="date" name="enddate">                            
                            </td>
                        </tr>
                        <tr>
                            <th>상태</th>
                            <td colspan="3">
                            	<input type="radio" name="progress" id="todoStateBefore" value="시작 전">
                            	<label for="todoStateBefore">시작 전</label>
                                <input type="radio" name="progress" id="todoStateIng" value="진행 중">
                            	<label for="todoStateIng">진행 중</label>
                                <input type="radio" name="progress" id="todoStateEnd" value="완료">
                            	<label for="todoStateEnd">완료</label>
							</td>
                        </tr>
                    </table>
                </div>               
                <div class="btnBox">
                	<input type="button" class="popupOK" value="수정" onclick="updateTodo(this.form);">
                </div>
               	</form>
            </dd>
        </dl>
    </div>     
    <div class="popup workAddPopup">
        <dl>
            <dt>업무 추가</dt>
            <dd>
		        <form method="post">
                <div class="table workDetail">
                    <table>
                        <colgroup>
                            <col width="15%">
                            <col width="30%">
                            <col width="15%">
                            <col width="30%">
                        </colgroup>
                        <tr>
                            <th>분류</th>
                            <td colspan="3">
                                <select name="p_num" class="workCategory">
									<c:choose>
									    <c:when test="${empty guest.depart}">
		                                    <option>부서를 등록해주세요.</option>
									    </c:when>
									    <c:otherwise>
		                                    <option value="0">${guest.depart }</option>
									    </c:otherwise>
									</c:choose>
                                </select>  
                            </td>
                        </tr>
                        <tr>
                            <th>업무</th>
                            <td colspan="3" class="workPopTit">
                            	<input type="text" name="title">
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="3" class="workPopTxt">
                            	<input type="text" name="text">
                            </td>
                        </tr>
                        <tr>
                            <th>지시자</th>
                            <td class="workPopLeader">
                                <select disabled>
									<c:choose>
									    <c:when test="${empty guest.role}">
		                                    <option>직급을 등록해주세요</option>
									    </c:when>
									    <c:otherwise>
		                                    <option value="0">${guest.depart }</option>
									    </c:otherwise>
									</c:choose>
                                    <option selected >${guest.g_name } ${guest.role}</option>
                                </select>
                                <input type="hidden" name="order_m" value="${guest.m_num }">
                            </td>
                            <th>업무자</th>
                            <td class="workPopWorker">
                                <select name="worker_m">
                                    <option value="" selected></option>
                                </select>                            
                            </td>
                        </tr>
                        <tr>
                            <th>기한</th>
                            <td colspan="3" class="workPopTime">
                                <input type="date" name="orderdate">
                                &nbsp;~&nbsp;
                                <input type="date" name="enddate">                            
                            </td>
                        </tr>
                        <tr>
                            <th>상태</th>
                            <td colspan="3">
                            	<input type="radio" name="progress" id="todoStateBefore2" value="시작 전">
                            	<label for="todoStateBefore2">시작 전</label>
                                <input type="radio" name="progress" id="todoStateIng2" value="진행 중">
                            	<label for="todoStateIng2">진행 중</label>
                                <input type="radio" name="progress" id="todoStateEnd2" value="완료" disabled>
                            	<label for="todoStateEnd2">완료</label>
							</td>
                        </tr>
                    </table>
                </div>               
                <div class="btnBox">
                	<input type="button" class="popupOK" value="확인" onclick="insertTodo(this.form);">
                </div>
               	</form>
            </dd>
        </dl>
    </div>     
</body>
</html>