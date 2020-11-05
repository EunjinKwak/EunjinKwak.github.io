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
    <script src="js/projectWork.js"></script>
</head>
<body>
    <%@ include file="include/header.jsp" %>
    <section>
    	<input type="hidden" name="p_num" class="locationPNUM" value="${project.p_num }">
        <dl class="conTit department">
            <dt>
                TO-DO
                <a href="#" class="workAddBtn"><img src="img/todoAdd.png" alt="" width="35"></a>
            </dt>
            <dd>프로젝트내에서 할 일을 확인해보세요.</dd>
        </dl>
        <ul class="projectTodo smallMG connectedSortable">
        </ul>
        <dl class="conTit department bigMG">
            <dt class="dtImg">
                ${project.p_name }
                <a href="#" class="teamAddBtn"><img src="img/teamAdd.png" alt="" width="35"></a>
            </dt>
            <dd>프로젝트 팀원들의 업무를 확인해보세요.</dd>
        </dl>
        <div class="departTodo smallMG">
			<!-- <dl>
				<dt>
					<span class="memberName" data-index="3">권은영 과장</span>
					<span class="todoType"><span class="bullet">•</span>0
					<span class="bullet">•</span>1</span>
				</dt>
				<dd>
					<ul class="listItem">
						<li>
							<a href="#">
								<span class="todoContTxt">삼성 홈페이지 유지보수</span>
								<span class="deadLine">(11일 남았습니다.)</span>
							</a>
						</li>
					</ul>
				</dd>
			</dl> -->        
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
                                    <option selected>${project.p_name }</option>
                                </select>  
                                <input type="hidden" name="p_num" value="${project.p_num }">
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
                                    <option selected></option>
                                </select>
                                <input type="hidden" name="order_m" value="${guest.m_num }">
                            </td>
                        </tr>
                        <tr>
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
                            <td colspan="3" class="workCategory">
                                <select disabled>
                                    <option selected>${project.p_name }</option>
                                </select>  
                                <input type="hidden" name="p_num" value="${project.p_num }">
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
                                    <option selected >${guest.g_name } ${guest.role} (${guest.depart })</option>
                                </select>
                                <input type="hidden" name="order_m" value="${guest.m_num }">
                            </td>
                        </tr>
                        <tr>
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
	<div class="popup teamAddPopup">
		<dl>
			<dt>${project.p_name } 멤버 추가</dt>
            <dd>
            	<div class="table">
	            	<table>
		                <colgroup>
		                    <col width="30%"/>
		                    <col width="20%"/>
		                    <col width="30%"/>
		                    <col width="20%"/>
		                </colgroup>
		                <thead>
		                    <tr>
		                        <th>이름</th>
		                        <th>직급</th>
		                        <th>부서</th>
		                        <th>초대</th>
		                    </tr>
		                </thead>
		                <tbody>
		                    <tr>
		                        <td>최은서</td>
		                        <td>대리</td>
		                        <td>디자인팀</td>
		                        <td><input type="button" class="inviteBtn" onclick="inviteProject()"></td>
		                    </tr>
		                </tbody>
            		</table>
            	</div>
            </dd>
        </dl>
   </div>   
<script>
	getProjectTodo(${guest.m_num}, ${project.p_num });
	getProjectNotJoiner(${project.p_num });

</script>  
</body>
</html>