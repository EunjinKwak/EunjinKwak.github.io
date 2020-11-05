<%@ page import="com.spring.withwork.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- popup include -->
	 <script>
		var auth = '<c:out value="${guest.authority}" />';
		console.log("auth : " + auth);
	 </script>
    <footer>
        <ul class="quickBar">
            <li class="members">
                <a href="#"><img src="img/users.png" alt=""></a>
            </li>
            <li class="chatBtn">
                <a href="#"><img src="img/chat.png" alt=""></a>
            </li>
            <li class="outBtn">
                <a href="main.jsp"><img src="img/groupOut.png" alt=""></a>
            </li>
        </ul>
    </footer>
    <div class="darkBack"></div>
    <dl class="pop memberCont">
        <dt>
            그룹멤버
            <a href="#">X</a>
        </dt>
        <dd>
            <div class="memberTab">
                <ul class="tabs">
                    <li class="active"><a href="#">전체보기</a></li>
                    <c:if test="${guest.authority eq '관리자'}">
	                    <li><a href="#">멤버초대</a></li>
	                    <li><a href="#">멤버수정</a></li>
	                    <li><a href="#">멤버삭제</a></li>
                    </c:if>
                </ul>
            </div>
            
            <div class="tab_content">
                <!-- 전체보기 영역 -->
                <div class="allGetMember">
	                <!-- 검색 영역 -->
                	
		            
                    <%-- <ul class="memberTeam">
                        <li class='memberTeamNav'><a href="#">> ${member.depart }</a></li>
                        <li class="memberList">
                            <ul>
                                <li><img src="img/usericon.png"  alt=""> ${member.g_name } &nbsp&nbsp&nbsp ${member.email }</li>
                            </ul>
                        </li>
                    </ul> --%> 
                </div>
                <c:if test="${guest.authority eq '관리자'}">
                <!-- 멤버추가 영역 -->
                <div class="addMember">
                	<!-- 검색 영역 -->
	                <p class="projectSearch search">
		                <input type="text" id = "keyword" placeholder="이름, 이메일 중 하나를 입력해주세요.">
		                <input type="button" onclick="searchAddMember()" value="">
	          		</p>
                    <div class="table Tables">
                        <table>
                            <colgroup>
                                <col width="10%">
                                <col width="40%"/>
                                <col/>
                                <col/>
                                <col width="15%"/>
                            </colgroup>
                            <%-- <tr>
                            <c:forEach var= "member" items="${searchAdd }" >
                                <th><img src="img/usericon.png"  alt=""></th>
                                <td>
                                    <p>${member.g_name }</p>
                                    <p class="emailTxt">${member.email }</p>
                                </td>
                                <td>
                                    <select class="sel">
                                        <option>그룹선택</option>
                                        <option>${member.depart }</option>
                                    </select>
                                </td>
                                <td>
                                    <select>
                                        <option>권한선택</option>
                                        <option>관리자</option>
                                        <option>멤버</option>
                                    </select>
                                </td>
                                <td>초대<!-- <input type="checkbox"> --></td>
                                </c:forEach>
                            </tr> --%>
                        </table>
                    </div>
                </div>
                <!-- 멤버수정 영역 -->
                <div class = "upMember">
                	<!-- 검색 영역 -->
                	<p class="projectSearch search">
		                <input type="text" id = "upKeyword" placeholder="이름, 이메일 중 하나를 입력해주세요.">
		                <input type="button" onclick="searchUpMember()" value="">
	          		</p>
                    <div class="table Tables">
                        <table>
                            <colgroup>
                                <col width="10%">
                                <col width="40%"/>
                                <col/>
                                <col/>
                                <col width="15%"/>
                            </colgroup>
                            <%-- <tr>
                                <th><img src="img/usericon.png"  alt=""></th>
                                <td>
                                    <p>최은서</p>
                                    <p class="emailTxt">test@test.com</p>
                                </td>
                                <td>
                                    <select class="sel">
                                        <option>그룹선택</option>
                                        <option>마케팅팀</option>
                                        <option>디자인팀</option>
                                        <option>기획팀</option>
                                        <option>재무관리팀</option>
                                    </select>
                                </td>
                                <td>
                                    <select class="sel">
                                        <option>권한선택</option>
                                        <option>관리자</option>
                                        <option>멤버</option>
                                    </select>
                                </td>
                                <td>수정</td>
                            </tr> --%>
                        </table>
                    </div>
                </div>
                <!-- 멤버삭제 영역 -->
                <div class="delMember">
                	<!-- 검색 영역 -->
	                <p class="projectSearch search">
		                <input type="text" id = "delKeyword" placeholder="이름, 이메일 중 하나를 입력해주세요.">
		                <input type="button" onclick="searchDelMember()" value="">
	           		</p>
                    <div class="table Tables">
                        <table>
                            <colgroup>
                                <col width="10%">
                                <col width="40%"/>
                                <col/>
                                <col/>
                                <col width="15%"/>
                            </colgroup>
                            <%-- <tr>
                                <th><img src="img/usericon.png"  alt=""></th>
                                <td>
                                    <p>${member.g_name }</p>
                                    <p class="emailTxt">${member.email }</p>
                                </td>
                                <td>${member.depart}</td>
                                <td>${member.authority}</td>
                                <td>삭제</td>
                            </tr> --%>
                        </table>
                    </div>
                </div>
            	</c:if>
            </div>
        </dd>
    </dl>
    <div class="popupM msgPopup">
        <dl>
            <dt>
                ${guest.c_name }
                <a href="#">X</a>
            </dt>
        </dl>
        <ul class="msgPopupC">
            <li><a href="#">멤버</a></li>
            <li><a href="#">대화방</a></li>
        </ul>
        <div class="msgPopupAll">
            <div class="msgPopupA">
            	<!-- 검색 영역 -->
	            <div class="projectSearch searchMemberChat">
		            <input type="text" placeholder="이름이나 직급으로 멤버를 검색하세요." name=searchMember class="searchBoxx">
		            <input type="button" value="" class="searchBtnn">
		        </div>
				<div class="msgPopupI"></div>
		        <div class="msgPopupAA">
                <!-- <a href="#" class="profileImg">
                    <dl>
                        <dt class="memPopup">권은영 팀장</dt>
                        <dd class="onlineId">카트 들어오세요</dd>
                    </dl>
                </a> -->
                </div>
            </div>
            <div class="msgPopupB">
            	<!-- 검색 영역 -->
            	<div class="projectSearch searchMemberChat">
		            <input type="text" placeholder="이름을 입력하세요." name=searchMember class="searchBoxx2">
		            <input type="button" value="" class="searchBtnn2">
		        </div>
		        <div class="msgPopupBB">
                <!-- <a href="#" class="profileImg2">
                    <dl>
                        <dt class="memPopup2">권은영 팀장, 최은서 부사장, 곽은진 과장</dt>
                        <dd class="onlineId">카트중...</dd>
                    </dl>
                </a> -->
                </div>
            </div>            
        </div>
    </div>
    <div class="popupP chatProfile">
        <dl>
            <dt>
               	 프로필
                <a href="#" class="popupOK1">X</a>
            </dt>
            <dd>
                <ul class="msgPopupD">
                    <!-- <li>
                        <img src="img/profile.png" alt="" width="110px">
                    </li>
                    <li>권은영 팀장</li>
                    <li>
                    	<a href='#' class='conMsg'>상태메세지를 입력해보세요.</a>
                    </li> -->
                    <li>
                        <img src="img/profile.png" alt="" width="110px">
                    </li>
                    <li>권은영 팀장</li>
                    <li>
                    	<span class="msgConPop"></span>
                   		<!-- <a href='#' class='conMsg'>
                   			EDIT
                   		</a> -->
                    </li>
                </ul>
                
                <form action="insert11Chat.do" method="post" class="insertRoom">
                
                <div class="btnBox set2">
                	<input type="hidden" class="chatM_num" name="m_num">
                    <input type="button" class="set11" value="1:1 채팅" onclick="set101(this.form);">
                    <!-- <input type="button" class="set1n" value="채팅방 초대"> -->
                    <input type="button" class="conMsg" value="수정">
                </div>
                
                </form>
            </dd>
        </dl>
    </div>
	<div class="popupP chatProfile2">
        <dl>
            <dt>
               	 대화방
                <a href="#" class="popupOK1">X</a>
            </dt>
            <dd>
                <ul class="msgPopupD2">
                    <li>
                        <img src="img/profile.png" alt="" width="110px">
                    </li>
                    <li>이민형 부장, 권은영 팀장</li>
                </ul>
                
                <form action="insert11Chat.do" method="post" class="insertRoom">
                
                <div class="btnBox set2">
                	<input type="hidden" class="chatRoom_id" name="room_id">
                    <input type="button" class="set11" value="채팅방 입장" onclick="set202(this.form);">
                    <!-- <input type="button" class="set1n" value="채팅방 초대"> -->
                </div>
                
                </form>
            </dd>
        </dl>
    </div>
	<div class="popupP2 conditionMsg">
        <dl>
            <dt>상태메세지</dt>
            <dd>
            
               	<form action="updateNotice.do" method="post">
               	
                <ul class="msgPopupD2">
                    <li class="projectSearch searchMemberChat2">
                        <input type="text" name="content" class="conText">
                    </li>
                </ul>
                
                <div class="btnBox set2">
                	<input type="hidden" class="chatM_num" name="m_num">
                    <input type="button" class="set99" value="저장">
                    <input type="button" class="set44" value="취소">
                </div>
                
                </form>
            </dd>
        </dl>
    </div>