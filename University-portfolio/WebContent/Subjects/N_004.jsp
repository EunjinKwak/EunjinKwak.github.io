<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목정보 상세</title>
<style>
	 #header {
	    height: 70px;
	 }
	 /* 과목정보 제목 */
	 .title{
	 	width: 70%;
		margin: 50px auto;
		text-align : center;
		font-size: 1.3rem;
	 }
	 /* 테이블 */
	 .wrap{
	 	width: 70%; margin: 0 auto;
	 }
	 .table {
	 	border: 1px solid #ddd;
	 }
	 .table th, .table td {
        border-collapse: collapse;
		border: 1px solid #ddd; 
	 }
	 .table th{
		padding: 10px 10px;
		width: 30%;
		background-color: #0B2161;
		color: white;
		height: 20px;
	}
	.inline{
		text-align: center;
		font-size : 0.9rem;
	}
	.table td{
		padding: 10px 20px;
	}
	.getline{
		text-align : left;
		font-size : 1rem;
	}
	 .proposal{
		text-align: center;
		padding: 10px 10px;
		width: 20%;
		background-color: #0B2161;
		color: white; 
		border: 1px solid #ddd;
		font-size : 0.9rem;
	}
	/* 이미지 */
	.photo{
		margin: 0 auto;
		text-align : center;
	}
	/* 강의 계획서 글 */
	.inform{
		text-align : center;
		font-size : 1rem;
		margin : 10px auto;
	}
    
</style>
</head>
<body>
<div id="header">
	<jsp:include page="..\header.jsp"></jsp:include>
</div>
<div class= "wrap">
 	<p class="title">과목 상세</p>
    <table class="table"> 
        <thead>
        <tr>
            <th class="inline">과목</th>
            <td class="getline" colspan="2" >${bvo.subject}</td>
        </tr>
        <tr>
            <th class="inline">담당교수</th>
            <td colspan="2" class="getline" ><p>${bvo.name }</p> </td>
       </tr>
        <tr>
            <td colspan="2">
            	<p class="photo"><img src="img/형진이형님.jpeg" width="800px" height="600px" alt="강사사진"></p>
            </td>
        </tr>
        <tr>
            <th colspan="2" class="proposal">강의계획서</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <td colspan="2" class="inform"><img src="img/강의계획서1.jpg" width="1200px" height="1000px" alt="강사사진"></td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
</html>