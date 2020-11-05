<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="include/head.jsp"%>

<link rel="stylesheet" href="css/confirm.css">
<script src="js/confirm.js"></script>
</head>
<body>
	<script>
		console.log("냐냐122");
		var list = <c:out value="${list }" />
		console.log(list);
	</script>
	<%@ include file="include/header.jsp"%>
	<section>
		<dl class="conTit">
			<dt>CONFIRM</dt>
			<dd>나의 결재 진행 사항을 확인해보세요.</dd>
		</dl>
		<div class="confirmTabMenu">
			<!--탭 메뉴 영역-->
			<ul class="tabs">
				<li><a href="getAllConfirm.do?page=1&perPageNum=3&tab=1">결재 처리</a></li>
				<li><a href="getAllConfirm.do?page=1&perPageNum=3&tab=2">결재 요청</a></li>
				<li><a href="getAllConfirm.do?page=1&perPageNum=3&tab=3">결재 완료함</a></li>
			</ul>
			<!--탭 내역-->
			<div id="tab1" class="tab_content" style="display:none;">
				<div class="table smallMG">
					<table>
						<caption>결재 처리</caption>
						<colgroup>
							<col width="5%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="30%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="5%">
						</colgroup>
						<thead>
							<tr>
								<th>No</th>
								<th>배정일시</th>
								<th>완료일시</th>
								<th>결재일시</th>
								<th>업무명</th>
								<th>기안자</th>
								<th>결재자</th>
								<th>상태</th>
								<th>상세</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="confirm" items="${list }">
								<tr>
									<td>${confirm.v_num }</td>
									<td>${confirm.orderdate }</td>
									<td>${confirm.finaldate }</td>
									<td>${confirm.confirmdate }</td>
									<td>${confirm.title }</td>
									<td>${confirm.worker }</td>
									<td>${confirm.orderer }</td>
									<td>${confirm.state }</td>
									<td><img src="img/penimg.png" id="penimg" onclick="confirmDetail(${confirm.t_num });"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					&nbsp;
					<ul class="paging">
						<c:if test="${pageMaker.prev}">
							<li><a class="arrow"
								href="getAllConfirm.do${pageMaker.makeQuery(pageMaker.startPage - 1)}&tab=1">◀</a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}" var="idx">
							<li><a href="getAllConfirm.do${pageMaker.makeQuery(idx)}&tab=1">${idx}</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a class="arrow"
								href="getAllConfirm.do${pageMaker.makeQuery(pageMaker.endPage + 1)}&tab=1">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			
			<div id="tab2" class="tab_content" style="display:none;">
				<div class="table smallMG">
					<table>
						<caption>결재 요청</caption>
						<colgroup>
							<col width="5%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="30%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="5%">
						</colgroup>
						<thead>
							<tr>
								<th>No</th>
								<th>배정일시</th>
								<th>완료일시</th>
								<th>결재일시</th>
								<th>업무명</th>
								<th>기안자</th>
								<th>결재자</th>
								<th>상태</th>
								<th>상세</th>
							</tr>
						</thead>
						<tbody>
								<c:forEach var="confirm" items="${list2 }">
								<tr>
									<td>${confirm.v_num }</td>
									<td>${confirm.orderdate }</td>
									<td>${confirm.finaldate }</td>
									<td>${confirm.confirmdate }</td>
									<td>${confirm.title }</td>
									<td>${confirm.worker }</td>
									<td>${confirm.orderer }</td>
									<td>${confirm.state }</td>
									<td><img src="img/mess.png" id="mess" onclick="confirmFeedback(${confirm.t_num });"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					&nbsp;
					<ul class="paging">
						<c:if test="${pageMaker2.prev}">
							<li><a class="arrow"
								href="getAllConfirm.do${pageMaker2.makeQuery(pageMaker2.startPage - 1)}&tab=2">◀</a></li>
						</c:if>
						<c:forEach begin="${pageMaker2.startPage}"
							end="${pageMaker2.endPage}" var="idx">
							<li><a href="getAllConfirm.do${pageMaker2.makeQuery(idx)}&tab=2">${idx}</a></li>
						</c:forEach>
						<c:if test="${pageMaker2.next && pageMaker2.endPage > 0}">
							<li><a class="arrow"
								href="getAllConfirm.do${pageMaker2.makeQuery(pageMaker2.endPage + 1)}&tab=2">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			
			<div id="tab3" class="tab_content" style="display:none;">
				<div class="table smallMG">
					<table>
						<caption>결재 완료</caption>
						<colgroup>
							<col width="5%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="30%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="5%">
							</colgroup>
						<thead>
							<tr>
								<th>No</th>
								<th>배정일시</th>
								<th>완료일시</th>
								<th>결재일시</th>
								<th>업무명</th>
								<th>기안자</th>
								<th>결재자</th>
								<th>상태</th>
								<th>상세</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="confirm" items="${list3 }">
								<tr>
									<td>${confirm.v_num }</td>
									<td>${confirm.orderdate }</td>
									<td>${confirm.finaldate }</td>
									<td>${confirm.confirmdate }</td>
									<td>${confirm.title }</td>
									<td>${confirm.worker }</td>
									<td>${confirm.orderer }</td>
									<td>${confirm.state }</td>
									<td>${confirm.feedback }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					&nbsp;
					<ul class="paging">
						<c:if test="${pageMaker3.prev}">
							<li><a class="arrow"
								href="getAllConfirm.do${pageMaker3.makeQuery(pageMaker3.startPage - 1)}&tab=3">◀</a></li>
						</c:if>
						<c:forEach begin="${pageMaker3.startPage}"
							end="${pageMaker3.endPage}" var="idx">
							<li><a href="getAllConfirm.do${pageMaker3.makeQuery(idx)}&tab=3">${idx}</a></li>
						</c:forEach>
						<c:if test="${pageMaker3.next && pageMaker3.endPage > 0}">
							<li><a class="arrow"
								href="getAllConfirm.do${pageMaker3.makeQuery(pageMaker3.endPage + 1)}&tab=3">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="include/footer.jsp"%>
	<div class="popup confirmPopup">
		<dl>
			<dt>결재</dt>
			<dd>
				<div class="table feed">
					<table>
						<colgroup>
							<col width="20%">
							<col width="90" />
						</colgroup>
						<tr>
							<th>FeedBack</th>
							<td style="text-align:left;"><input type="text" name="feedback" class="feedbackText" readonly ></td>
						</tr>
						
					</table>
				</div>
				<div class="btnBox">
					<input type="hidden" name="v_num" class="v_num" value="">
					<a href='#' class="popupOK">확인</a>
				</div>
			</dd>
		</dl>
	</div>
	
	<div class="popup penPopup">
		<dl>
			<dt>결재 처리</dt>
			<dd>
				<div class="table pen">
					<form action="updateConfirm.do" method="post">
						<table>
							<colgroup>
								<col width="15%">
								<col width="30%">
								<col width="15%">
								<col width="30%">
							</colgroup>
							<tr>
								<th>업무</th>
								<td style="text-align:left;"><input type="text" class="confirmTitle"></td>
							</tr>
							<tr>
								<th>FeedBack</th>
								<td colspan="1" style="text-align:left"><input type="text" name="feedback" placeholder="FeedBack을 입력해주세요."
									size="30" class="confirmFeedBack"></td>
							</tr>
							<tr>
								<th>결재 현황</th>
								<td style="text-align:left;"><input type="radio" name="state" class="confirmState1" value="대기" checked="checked">&nbsp;대기&nbsp;&nbsp;&nbsp;
									<input type="radio" name="state" class="confirmState2 penchk" value="완료">&nbsp;완료</td>
							</tr>
						</table>
						<div class="btnBox">
							<input type="hidden" name="t_num" class="t_num" value="">
							<input type="submit" class="popupOK" id="popupOK_R" value="입력">
						</div>
					</form>
				</div>
			</dd>
		</dl>
	</div>
	<script>
	var tab = getParameterByName('tab');
	if(tab == 1){
		$(".confirmTabMenu .tabs li").eq(0).addClass("active");
		$("#tab1").show();
	}else if(tab == 2){
		$(".confirmTabMenu .tabs li").eq(1).addClass("active");
		$("#tab2").show();
	}else if(tab == 3){
		$(".confirmTabMenu .tabs li").eq(2).addClass("active");
		$("#tab3").show();
	}
	</script>
</body>
</html>