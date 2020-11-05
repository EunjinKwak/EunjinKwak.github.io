function projectList(){
	var m_num = $(".loginMNUM").val();
	var projectCnt = $(".projectList>li").length;
	$.ajax("getProjectIn.do", {
		type : "get",
		dataType : "json",
		data : { "m_num":  m_num },
		async: false,
		success : function(data){
			if(data.length != projectCnt){
				var pjListHtml = "";
				
				$.each(data, function(){
					pjListHtml += "<li data-index='"+ this.p_num +"'>";
					pjListHtml += "<a href='projectTodo.do?p_num="+ this.p_num +"' class='projectTit'>"+ this.p_name +"</a>";
					pjListHtml += "<ul>";
					pjListHtml += "<li><a href='projectTodo.do?p_num="+ this.p_num +"'>TO-DO</a></li>";
					pjListHtml += "<li><a href='projectNotice.do?p_num="+ this.p_num +"'>NOTICE</a></li>";
					pjListHtml += "</ul>";
					pjListHtml += "</li>";
				});
				
				$(".projectList").html(pjListHtml);
			}
		}
	});	
}

$().ready(function(){
	
	projectList();
	setInterval(projectList, 1000); //1초 간격
	
})
