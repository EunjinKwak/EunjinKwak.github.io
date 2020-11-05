/* Todo 생성 */
function insertTodo(frm){
   /* 유효성 검사 */
   var title = $(".workAddPopup .workPopTit input").val();
   var text = $(".workAddPopup .workPopTxt input").val();
   var orderdate = $(".workAddPopup .workPopTime input").val();
   var enddate = $(".workAddPopup .workPopTime input").val();
   
   if(title == ""){
      alert("업무를 입력해주세요.");
      return false;
   }else if(text == ""){
      alert("내용 입력해주세요.");
      return false;
   }else if(orderdate == ""){
      alert("업무 시작일을 선택해주세요.");
      return false;
   }else if(enddate == ""){
      alert("업무 마감일을 선택해주세요.");
      return false;
   }
   
   frm.action="insertTodo.do";
   frm.submit();
}

/* Todo 수정 */
function updateTodo(frm){
   /* 유효성 검사 */
   var title = $(".workPopup .workPopTit input").val();
   var text = $(".workPopup .workPopTxt input").val();
   var orderdate = $(".workPopup .workPopTime input").val();
   var enddate = $(".workPopup .workPopTime input").val();
   
   console.log(title + ", " + text + ", " + orderdate + ", " + enddate);
   
   if(title == ""){
      alert("업무를 입력해주세요.");
      return false;
   }else if(text == ""){
      alert("내용 입력해주세요.");
      return false;
   }else if(orderdate == ""){
      alert("업무 시작일을 선택해주세요.");
      return false;
   }else if(enddate == ""){
      alert("업무 마감일을 선택해주세요.");
      return false;
   }
   
   
   frm.action="updateTodo.do";
   frm.submit();
}

/* 나의 Todo 조회 Html */
function getTodoMeHtml(htmlSource, todoTNUM, todoTITLE, todoPROGRESS, todoBD){

   if(todoBD <= 1){
      htmlSource += "<li class='import'>";
   }else{
      htmlSource += "<li>";
   }
   
   htmlSource += "<a href='#' data-index='" + todoTNUM +"'><span class='todoContTit'>";
   htmlSource += todoTITLE;
   
   if(todoPROGRESS == '완료'){
      htmlSource += "</span><span class='deadLine'>(결재 진행중)</span></a></li>";
   }else{
      htmlSource += "</span><span class='deadLine'>("+ todoBD +"일 남았습니다.)</span></a></li>";
   }
   return htmlSource;
}

/* Todo 팝업창에서 데이터에 맞는 option 선택 */
function getDetailSelect(option, data){
   $(option).each(function(){
      var optionVal = $(this).val();
      if(data == optionVal){
         $(this).prop('selected', true);
      }
   });
}

/* 팀원 Todo Count  */
function getTodoCnt(){
    $(".departTodo dl").each(function(){
      var allCnt = $(this).find(".listItem li").length;
      var importCnt = $(this).find(".listItem li.import").length;
      var normalCnt = allCnt - importCnt;
      
      var cntHtml = "";
      cntHtml += "<span class='bullet'>&bull;</span>" + importCnt;
      cntHtml += "<span class='bullet'>&bull;</span>" + normalCnt;
      
      $(this).find(".todoType").html(cntHtml);
    });
}


/* 나의 Todo 조회  */
function getAllTodo(worker_m, p_num) {
   var dispHtml = "";
   
   $.ajax("getAllTodo.do", {
      type : "get",
      data : { "worker_m":  worker_m },
      dataType : "json",
      async: false,
      success : function(data){
         $.each(data, function(){
            var todoTNUM = this.t_num;
            var todoPNUM = this.p_num;
            var todoTITLE = this.title;
            var todoPROGRESS = this.progress;
            var todoBD = this.betweendate;
            
            if(todoPROGRESS != "종료"){
	            if(p_num != ""){
	               if(todoPNUM == p_num){
	                  dispHtml = getTodoMeHtml(dispHtml, todoTNUM, todoTITLE, todoPROGRESS, todoBD);
	               }
	            }else{
	               dispHtml = getTodoMeHtml(dispHtml, todoTNUM, todoTITLE, todoPROGRESS, todoBD);
	            }
            }
            
         });
      }
   });
   
   return dispHtml;
}

/* 팀원 Todo 조회  */
function getTeamTodo(worker_m) {
   var dispHtml = "";
   $.ajax("getAllTodo.do", {
      type : "get",
      data : { "worker_m":  worker_m },
      dataType : "json",
      async: false,
      success : function(data){
         dispHtml = "<dd><ul class='listItem connectedSortable'>";
         
         $.each(data, function(){
            var workerTNUM = this.t_num;
            
            if(this.betweendate <= 1){
               dispHtml += "<li class='import'>";
            }else{
               dispHtml += "<li>";
            }
            dispHtml += "<a href='#' data-index='"+ workerTNUM +"'>";
            dispHtml += "<span class='todoContTit'>"+ this.title +"</span>";
            dispHtml += "<span class='deadLine'>("+ this.betweendate +"일 남았습니다.)</span>";
            dispHtml += "</a></li>";
         });
         dispHtml += "</ul></dd>";
      }
   });
   
   return dispHtml;
}

/* Todo 팝업 내용 조회  */
function getTodoDetail(t_num) {
   $.ajax("getTodoDetail.do", {
      type : "get",
      dataType : "json",
      async: false,
      success : function(data){
		 $.each(data, function(){
		    var dataTNUM = this.t_num;
		    var dataOrderer = this.orderer + " " + this.o_role; 
		    var dataWorkerM = this.worker_m; 
		    var dataWorker = this.worker + " " + this.w_role; 
		    var dataProgress = this.progress; 
		    var dataPNUM = this.p_num; 
		    var dataPNAME = this.p_name; 
		    
		    if(dataTNUM == t_num){
		        
		       $(".workPopup .t_num").val(dataTNUM);
		       $(".workPopup .workPopTit input").val(this.title);
		       $(".workPopup .workPopTxt input").val(this.text);
		       $(".workPopup .workPopLeader option").text(dataOrderer);
		       $(".workPopup .workPopLeader input").val(this.order_m);
		       $(".workPopup input[name=orderdate]").val(this.orderdate);
		       $(".workPopup input[name=enddate]").val(this.enddate);
		       
		       if(dataPNUM == 0){
		          var depart = $(".todoNav li").eq(1).text();
		          $(".workPopup .workCategory option").text(depart);
		          $(".workPopup input[name=p_num]").val(0);      
		          getAllDepart();         
		       }else{
		          $(".workPopup .workCategory option").text(dataPNAME);
		          $(".workPopup input[name=p_num]").val(dataPNUM);      
		          getProjectJoiner(dataPNUM);          
		       }
		       
		       var workerOption = $(".workPopup .workPopWorker option");
		       getDetailSelect(workerOption, dataWorkerM);
		       
		       if(dataProgress == '시작 전'){
		          $(".workPopup #todoStateBefore").prop('checked', true);
		       }else if(dataProgress == '진행 중'){
		          $('.workPopup #todoStateIng').prop('checked', true);
		       }else{
		          $('.workPopup #todoStateEnd').prop('checked', true);
		          $('.workPopup td *').prop('disabled', true);
		          $('.workPopup .popupOK').hide();
		       }
		       
		       
		    }
		 });
      }
   });
}

/* 팀원 Todo 조회 */
function getAllDepartTodo() {
   $.ajax("getAllDepart.do", {
      type : "get",
      dataType : "json",
      async: false,
      success : function(data){
         var teamDispHtml = "";
         $.each(data, function(){
            var nameRole = this.g_name + " " + this.role;
            var loginMNUM = $(".loginMNUM").val();
            
            if(this.m_num != loginMNUM){
               teamDispHtml += "<dl><dt>";
               teamDispHtml += "<span class='memberName' data-index='"+ this.m_num +"'>"+ nameRole + " (" + this.depart + ")</span>";
               teamDispHtml += "<span class='todoType'>";
                   teamDispHtml += "</span></dt></dl>";
            }
         });
         
         $(".departTodo").html(teamDispHtml);
      }
   });
}

/* 팀원 조회 */
function getAllDepart() {
   $.ajax("getAllDepart.do", {
      type : "get",
      dataType : "json",
      async: false,
      success : function(data){
         var dispHtml = "";
         $.each(data, function(){
            var nameRole = this.g_name + " " + this.role;
            var loginMNUM = $(".loginMNUM").val();
         
            dispHtml += "<option value='";
            dispHtml += this.m_num + "'>";
            dispHtml += nameRole + "</option>";
         });
         
         $(".workPopWorker select").html(dispHtml);
      }
   });
}

/* 나의 Todo에서 부서, 프로젝트 조회 */
function projectNav(m_num){
   $.ajax("getProjectIn.do", {
      type : "get",
      dataType : "json",
      data : { "m_num":  m_num },
      async: false,
      success : function(data){
         var navCnt = $(".todoNav li").length-2;
         
         if(data.length != navCnt){
            var originTxt = "";
            var loginDEPART = $(".loginDEPART").val();
            
            originTxt += "<li class='active'><a href='#'>All</a></li>";
            originTxt += "<li data-index='0'><a href='#'>"+ loginDEPART +"</a></li>";
            
            $.each(data, function(){
               if(this.p_num != 0){
                  originTxt += "<li class='project' data-index='" + this.p_num + "'>";
               }else{
                  originTxt += "<li data-index='" + this.p_num + "'>";
               }
               originTxt += "<a href='#'>" + this.p_name + "</a></li>";
            });
            
            $(".todoNav").html(originTxt);
         }
      }
   });
   
   if($(".todoNav > li").length != $(".todoCont > li").length){
      var originCont = "";
      for(var i=$(".todoCont > li").length; i<$(".todoNav > li").length; i++){
         if($(".todoCont > li").length == 0){
            originCont += "<li class='active'><ul class='todoContList listItem connectedSortable'></ul></li>";         
         }
         originCont += "<li><ul class='todoContList listItem connectedSortable'></ul></li>";
         $(".todoCont").html(originCont);
      };   
   }
}

/*  */
function getMemberProject(m_num, p_num){
   $.ajax("getAllProject.do", {
      type : "get",
      dataType : "json",
      data : { "m_num":  m_num },
      async: false,
      success : function(data){
         $.each(data, function(){
            if(this.p_num == p_num){
               return true;
            }else{
               return false;
            }
         });
      }
   });   
}

/* Todo 생성팝업창에서 내 프로젝트 조회*/
function projectOption(m_num){
   var categoryTxt = "";
   $.ajax("getProjectIn.do", {
      type : "get",
      dataType : "json",
      data : { "m_num":  m_num },
      async: false,
      success : function(data){
         $.each(data, function(){
            categoryTxt += "<option value='"+ this.p_num +"'>" + this.p_name + "</option>";
         });
      }
   });   
   return categoryTxt;
}

/* 드래그 앤 드랍 데이터 */
function dragTodoUpdate(worker_m, t_num){
   $.ajax("dragTodoUpdate.do", {
      type : "get",
      dataType : "json",
      data : { "worker_m":  worker_m, "t_num": t_num },
      async: false,
      success : function(data){
      }
   });   
}

/* 팝업창에서 프로젝트 참가 팀원 조회 */
function getProjectJoiner(p_num){
   $.ajax("getProjectJoiner.do", {
      type : "get",
      dataType : "json",
      data : { "p_num":  p_num },
      async: false,
      success : function(data){
         var JoinerListHtml = "";
         
         $.each(data, function(){
            JoinerListHtml += "<option value='"+ this.m_num +"'>"+ this.g_name;
            JoinerListHtml += " " + this.role + "</option>";
         });
         
         $(".workPopWorker select").html(JoinerListHtml);
      }
   });   
}

/* 드래그 앤 드랍 UI */
function dragAnddrop(loginMNUM){
    // drag and drop
    $(".todoContList, .departTodo ul").sortable({
        connectWith: ".connectedSortable",
      stop: function(event, ui) {
            getTodoCnt();
      },
      update: function(event, ui){
          if (this === ui.item.parent()[0]) {
            var dragMNUM = ui.item.closest("dl").find(".memberName").attr("data-index");
            var dragTNUM = ui.item.find('a').attr('data-index');
            
            if(dragMNUM){
               dragTodoUpdate(dragMNUM, dragTNUM);         
            }else{
               dragTodoUpdate(loginMNUM, dragTNUM);
            }
            
            $(".todoContList li, .departTodo ul li").each(function(){
               var liParent = $(this).parent();
               var idx = $(this).find("a").attr('data-index');
               
               if(dragTNUM == idx){
                  $(this).remove();
                  $(liParent).prepend($(this));
               }
            });
          }
      }
    }).disableSelection();
}

/* 실시간 작동 함수 */
function todoSetInterval(){

   var loginMNUM = $(".loginMNUM").val();

   projectNav(loginMNUM);
   
   getAllDepartTodo();
   
   /* Todo창에서 부서 팀원 이름 표시 */
   $(".departTodo dl").each(function(){
      var teamTodo = $(this).html();
      var workerM = $(this).find(".memberName").attr("data-index");
      
      teamTodo += getTeamTodo(workerM);
      $(this).html(teamTodo);
   });

   getTodoCnt();   
   
   /* Todo 출력 */
   $(".todoCont li").each(function(){
      var idx = $(this).index();
      var tabPNUM = $(".todoNav li").eq(idx).attr("data-index");
      var tabTodoHtml = "";
      
      if(idx == 0){
         tabTodoHtml = getAllTodo(loginMNUM, "");
      }else{
         tabTodoHtml = getAllTodo(loginMNUM, tabPNUM);
      }
      
      $(this).find(".todoContList").html(tabTodoHtml); 
   });
   
   dragAnddrop(loginMNUM);
}

$().ready(function(){
   $(".header li").removeClass("active");
   $(".allInfo li").eq(0).addClass("active");
   
   var loginMNUM = $(".loginMNUM").val();

   
   // Todo 탭메뉴 active 효과
   $(document).on("click", ".todoNav li", function(){    
      var tabTodoHtml = "";
      var tabPNUM = $(this).attr("data-index");
      var idx = $(this).index();
      
      $(".todoNav li").removeClass("active");
      $(this).addClass("active");
        $(".todoCont > li").removeClass("active");
        $(".todoCont > li").eq(idx).addClass("active");   
      
      /*if(idx == 0){
         tabTodoHtml = getAllTodo(loginMNUM, "");
      }else{
         tabTodoHtml = getAllTodo(loginMNUM, tabPNUM);
      }
      
      $(".todoCont li.active").find(".todoContList").html(tabTodoHtml); */
   });

   // 나의 Todo 버튼 누를 시 띄워지는 팝업
   $(document).on("click", ".todoContList li a", function(){ 
      var detailTNUM = $(this).attr("data-index");
      
      $('.workPopup td *').prop('disabled', false);
      $('.workPopup .workPopLeader select').prop('disabled', true);
      $('.workPopup .workCategory select').prop('disabled', true);
      $('.workPopup .popupOK').show();
      
      getTodoDetail(detailTNUM);
      
        $(".workPopup").show();
        $(".darkBack").show();
   });
   
   // 다른사람 Todo 버튼 누를 시 띄워지는 팝업
   $(document).on("click", ".departTodo li a", function(){ 
      var detailTNUM = $(this).attr("data-index");
      
      $('.workPopup td *').prop('disabled', true);
      $('.workPopup .popupOK').hide();
      
      getTodoDetail(detailTNUM);
      
        $(".workPopup").show();
        $(".darkBack").show();
   });
   
   // Todo 팝업 창에서 프로젝트 변경 시 작업자 selectBox에 참가인원 표시
    $(".workAddPopup .workCategory").on('change', function(){
       var option = $(this).val();
       
       if(option == 0){
          getAllDepart();
       }else{
          getProjectJoiner(option);       
       }
    });
   
   // 일정 추가 버튼 눌렀을 때
    $(".workAddBtn").click(function(){
        $("input[name=progress]:first-child").prop('checked', true);
        $(".workAddPopup .workPopWorker option").eq(0).prop('selected', true);
       
       var depart = $(".todoNav li").eq(1).text();
       var selectHtml = "<option value='0'>"+ depart +"</option>";
       selectHtml += projectOption(loginMNUM);
       
      $(".workAddPopup .workCategory").html(selectHtml);
      getAllDepart();
        $(".workAddPopup").show();
        $(".darkBack").show();
    });
    
   todoSetInterval();
   setInterval("todoSetInterval()", 3000);
});