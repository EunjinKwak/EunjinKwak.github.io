<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%HttpSession ss = request.getSession(true); 
ss.getAttribute("list");
ss.getAttribute("bvo");
ss.getAttribute("cPage");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목정보 상세</title>
<style>
<style>

 #header {
    height: 70px;
 }

    .table{
        width: 60%;
        margin-left: auto;
        margin-right: auto;

        border: 2px solid gray;
        border-collapse: collapse;
    }
    th,td{
        border: 2px solid gray;
        text-align: center;
    }
    th{
        background-color: #0B2161;
        font-size: 2em;
       	font-style: italic;
		color: white
    }
    td{
        height: 3px;
        font-size: 15px;
    }
    .num{ 
    width: 150px;
    height: 40px;
    }
    .pro{
        width: 150px;
    }
    .time{
        width: 150px;
    }
    .room{
        width: 150px;
    }
    .pick{
        width: 150px;
    }
    .btn{
        color:whitesmoke;
        background-color: dimgrey;
        padding: 5px;
        
    }
    .table2{
        width: 50%;
        margin: auto;
    }
    p{
        font-size: 2.0em;
        font-style: italic;
		color: #0B2161;
        
    }
    .subject{
    	width: 100px;
        margin: auto;
        height: 70px;

    }
    .sub1{
        margin: auto;
        width: 800px;
        font: italic;
        font-size: 2.0em;
       font-style: italic;
		color: #0B2161;
        
    }
    .proposal{
        height: 50px;
    }
    .name{
        height: 70px;   
    }
    h1{
    	width: 70%;
		margin: 7% auto;	
		text-align : center;
		font-style: italic;
		color: #0B2161;
		font-size: 45px;
    }
  	.inform{
  		font-size: 1.5em;
  		font-style: italic;
  	}
  
</style>
</head>
<body>


<div id="header">
<jsp:include page="..\header.jsp"></jsp:include>

</div>
<br><br><br><br><br><br><br>
<br>
 	<h1>과목 상세</h1>
    <table border class="table"> 
        <thead>
        <tr>
            <th class="subject">과목</th>
            <td class="sub1" colspan="2" ><b>${bvo.subject}</b></td>
        </tr>
        <tr>
            <th>담당교수</th>
            <td colspan="2" class="name" ><p><b>${bvo.name }</b></p> </td>
       </tr>
        <tr>
            <td colspan="2"><img src="img/이미지준비중.PNG" width="800px" height="600px" alt="강사사진"></td>
        </tr>
        <tr>
            <th colspan="2" class="proposal">강의계획서</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <td colspan="2" class="inform"><br>코로나로 인하여 강의 계획서 업데이트가 미뤄지고 있습니다.<br> 
				정확한 문의는 학교로 연락바랍니다.<br><br></td>
        </tr>
        </tfoot>
    </table>
    <br><br>
</body>
</html>