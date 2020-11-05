$().ready(function(){
    function printDays(){ // 캘린더 출력
        var addDays = "";
        
        if(todayMonth < 1){
        	todayYear--;
        	todayMonth = 12;
        } else if(todayMonth > 12){
        	todayYear++;
        	todayMonth = 1;        	
        }
        
        if(todayMonth < 10){
        	todayMonth = "0" + todayMonth;
        } 
        
        $(".year").html(todayYear);
        $(".month").html(todayMonth);
        
    	var todayDateCnt = new Date(todayYear, todayMonth, 0).getDate();
    	var todayDayCnt = new Date(todayYear, todayMonth-1, 1).getDay();
    	
    	console.log("todayDateCnt : " + todayDateCnt);
    	console.log("todayDayCnt : " + todayDayCnt);

        for(let i=1; i<=35; i++){
            if(i%7 == 1){
                addDays += "<tr>"
            }
            
            addDays += "<td><dl>";
            addDays += "<dt>";
            
            if(i <= todayDayCnt){
                addDays += "</dt>";
            }else{
            	if(todayDateCnt + todayDayCnt >= i){
	                addDays += "<span>" 
		                	+ (i-todayDayCnt) 
		                	+ "</span>" 
		                	+ "</dt>";
            	}
            }
            
            addDays += "<dd></dd>";
            addDays += "</dl></td>";
            
            if(i%7 == 0){
                addDays += "</tr>"
            }
        }        
        $("#myCalendar tbody").html(addDays);
    }

   
    
    function eachDay(){
    	$("#myCalendar td").each(function(){ // 날짜 event
    		var selectDay = $(this).find("dt span").text();
    		
    		if(selectDay < 10){
    			selectDay = "0" + selectDay;
    		}
    		
    		var selectDate = String(todayYear)+String(todayMonth)+String(selectDay);
    		$(this).find("dl").attr("title", selectDate);
    		
			
    	});
    }
    
    function executeJS(){
        printDays();
        eachDay();
        getAllProject();
    }
    
    
    var today = new Date();
    var todayYear = today.getFullYear();
    var todayMonth = today.getMonth()+1;

    
	executeJS();
    
    
    $(".prevMonth").click(function(){ // 1달 전으로 버튼 클릭시
        todayMonth--; 
        executeJS();
    });

    $(".nextMonth").click(function(){ // 1달 후로 버튼 클릭시
        todayMonth++; 
        executeJS();
    });
    

});

function getAllProject() { // 날짜 일정에 맞게 일정버튼 추가
	$("#myCalendar dl dd").html("");
	$.ajax("getAllCalendar.do", {
		type : "get",
		dataType : "json",
		async : "false",
		success : function(data) {
			
			$.each(data, function(){
				var projectStartDate = this.startdate;
				var projectEndtDate = this.enddate;
				var status = this.status;
				var name = this.name;
				var c_num = this.c_num;
				var p_num = this.p_num;
				var todoCalNum = this.calNum;
				var todoColor = this.color;
				console.log("projectStartDate :" + projectStartDate);
				
				$("#myCalendar dl").each(function(){
					var dates = this.title;
					console.log("dates :" + dates);
					if(projectStartDate == dates){
						let dateDetail = $(this).find("dd").html();
						dateDetail += "<a href='#' class='todoBtnWrap' onclick='getPrj("+ p_num + ")'>"
									+ "<span class='startBtn'>"+name+"</span>"
									+ "</a>";
						$(this).find("dd").html(dateDetail);
					} else if(projectEndtDate == dates){
						let dateDetail = $(this).find("dd").html();
						dateDetail += "<a href='#' class='todoBtnWrap' onclick='getPrj("+ p_num + ")'>"
									+ "<span class='endBtn'>"+name+"</span>"
									+ "</a>";
						$(this).find("dd").html(dateDetail);
					}
					if($(this).find("p").length){
						$(this).find(".moreAddTodo").show();
					}
				});
			});
		},
		error : function(request, error){
     		console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}
// ------------------------- popup ----------------------------
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
