<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/head.jsp" %>
    
    <link rel="stylesheet" href="css/roadmap.css">
    <script src="js/roadmap.js"></script>
    <script src="js/calendar.js"></script>

    <title>withWork</title>
  </head>
  
  <!-- 임시 css -->
  
  <style>
  
  .right33 {
  	text-align: right;
  }
  
  .workDetail input[type=text], .workDetail select{
  	width: 100%;
  	outline: none;
  }
  
  </style>
  <!-- 임시 스크립트 -->
  <script>
  
  	/* 
  		임시 로그인 
  		넘겨받은 값 변수처리
	*/
	var g_name = '<c:out value="${guest.g_name}" />';
	var c_num = '<c:out value="${guest.c_num}" />';
	var auth = '<c:out value="${guest.authority}" />';

  </script>
<body>
	<%@ include file="include/header.jsp" %>
    <section>
        <dl class="conTit department">
            <dt>
            	ROADMAP
            	<c:if test="${auth eq '관리자'}">
            	<a href="#" id="insertProject"><img src="img/todoAdd.png" alt="" width="35"></a>
         	    </c:if>
            </dt>
            <dd>현재 회사에서 진행 또는 심사 중인 프로젝트를 확인해보세요.</dd>
            
            <!-- role = manager만 프로젝트 생성 버튼을 볼 수 있음.  -->
            <%-- <c:if test="${auth eq '관리자'}">
            	<dd class="right33"><button type="button" id="insertProject">버튼</button></dd>
            </c:if> --%>
            
        </dl>
        <div class="roadMapTab">
            <ul class="roadMapNav">
                <li class="active"><a href="#">전체일정</a></li>
                <li><a href="#">스케줄러</a></li>
            </ul>
            <div class="roadMapCont">
                <div class="progress" style="display: block;">
                   
                   	<!-- 
                   			프로젝트 찾기(search)
                   			담당자(관리자), 프로젝트이름으로 프로젝트를 찾을 수 있음.
                   	 -->
                   
                    <div class="roadMapSearch">
                    	<form id="searchForm">
	                        <select name="type">
	                            <option value="P">프로젝트 이름</option>
	                            <option value="M">담당자</option>
	                        </select>
	                        <input type="text" id="keyword"> 
                        	<button type="button" id="searchBtn">검색</button>
                        </form>
                    </div>
                    
                    <!-- 
                    		프로젝트 출력부분
                    		DB 데이터를 가져와서 출력하는 부분
                     -->
                    
                    <div class="roadMapState smallMG">
                        <dl class="stateForm prjB">
                            <dt class="waiting">시작 전</dt>
                           	<dd id="prjB"></dd>
                        </dl>
                        <dl class="stateForm prjO">
                            <dt class="starting">진행 중</dt>
                            <dd id="prjO"></dd>
                        </dl>
                        <dl class="stateForm prjF">
                            <dt class="stopping">완료</dt>
                            <dd id="prjF"></dd>
                        </dl>
                    </div>
                </div>
			    <div class="inner">
			        <table id="myCalendar">
			            <caption>
			                <a href="#" class="prevMonth">◀</a> 
			                &nbsp;&nbsp;               
			                <span class="year"></span>
			                .
			                <span class="month"></span>
			                &nbsp;&nbsp;
			                <a href="#" class="nextMonth">▶</a>
			            	
			            	<p class="startWord"><span></span>&nbsp시작일</p>
			                <p class="endWord"><span></span>&nbsp종료일</p>
			            </caption>
			            <colgroup>
			                <col width="14.28%" />
			                <col width="14.28%" />
			                <col width="14.28%" />
			                <col width="14.28%" />
			                <col width="14.28%" />
			                <col width="14.28%" />
			                <col width="14.28%" />
			            </colgroup>
			            <thead>
			                <tr>
			                    <th>SUN</th>
			                    <th>MON</th>
			                    <th>TUE</th>
			                    <th>WED</th>
			                    <th>THR</th>
			                    <th>FRI</th>
			                    <th>SAT</th>
			                </tr>
			            </thead>
			            <tbody>
			                <!-- <tr>
			                    <td>
			                        <dl title="20200701">
			                            <dt>1</dt>
			                            <dd></dd>
			                        </dl>
			                    </td>
			                </tr> -->
			            </tbody>
			        </table>
			    </div>
            </div>
        </div>
    </section>

    <!-- ----------------------------------------------------- -->
    <%@ include file="include/footer.jsp" %>
    
    <!-- 
    		프로젝트 생성 팝업창
     -->
    
    <div class="popup insertProject">
       	<dl>
       		<dt>프로젝트 생성</dt>
       		<dd>
       			<div class="table workDetail">
        			<table>
        				<tbody>
        					<tr>
        						<th>프로젝트 이름</th>
        						<td><input type="text" id="prjName"></td>
        					</tr>
        					<tr>
        						<th>프로젝트 주제</th>
        						<td><input type="text" id="prjSubject"></td>
        					</tr>
        					<tr>
        						<th>상태</th>
        						<td>
        							<input type="radio" name="prjChk_status" value="시작 전" checked="checked"> 시작 전 &nbsp;&nbsp;
        							<input type="radio" name="prjChk_status" value="진행 중"> 진행 중 &nbsp;&nbsp;
        							<input type="radio" name="prjChk_status" value="완료"> 완료
        						</td>
        					</tr>
        					<tr>
       							<th>관리자</th>
        						<td id="instSelect" class="mngList"></td>
        					</tr>
       						<tr>
       							<th>기한</th>
       							<td>
									<input type="date" id="prjStartDate">&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;					
									<input type="date" id="prjEndDate">       							
       							</td>
       						</tr>
       						<tr>
       							<th>내용</th>
       							<td>
       								<textarea id="prjContent" placeholder="내용을 입력하세요."></textarea>
       							</td>
       						</tr>
        				</tbody>
        			</table>
       			</div>
       			<div class="btnBox">
       				<button type="button" id="insertProjectBtn" class="popupOK">확인</button>
       			</div>
       		</dd>
   		</dl>
    </div>
    
    <!-- 
    		프로젝트 상세창
    		직원은 확인만 할 수 있고,
    		관리자는 수정이 가능하다.
     -->
    
    <div class="popup prjInfo">
    	<dl>
    		<dt>
    			프로젝트 상세
    			<a href="#">X</a>
   			</dt>
    		<dd>
    			<div class="table workDetail">
	    			<table>
	    				<tbody id="getPrj"></tbody>
	    			</table>
    			</div>
    			<div class="btnBox updatePrjBtn"></div>
    		</dd>
    	</dl>
    </div>
    <div class="darkBack"></div>
    <script>
    $().ready(function () {
    	  // 탭메뉴
		$(".roadMapNav li").click(function () {
			var idx = $(this).index();
			$(".roadMapNav li").removeClass("active");
			$(this).addClass("active");
			$(".roadMapCont > div").hide();
			$(".roadMapCont > div").eq(idx).show();
		});
   	});
    </script>
  </body>
</html>

  
  
