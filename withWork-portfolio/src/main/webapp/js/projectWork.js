/* 프로젝트 Todo 생성 */
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
   frm.action="pjInsertTodo.do";
   frm.submit();
}

/* 프로젝트 Todo 수정 */
function updateTodo(frm){
   /* 유효성 검사 */
   var title = $(".workPopup .workPopTit input").val();
   var text = $(".workPopup .workPopTxt input").val();
   var orderdate = $(".workPopup .workPopTime input").val();
   var enddate = $(".workPopup .workPopTime input").val();
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
   frm.action="pjupdateTodo.do";
   frm.submit();
}

/* 프로젝트 참가 팀원 Todo 출력 */
function getProjectJoiner(p_num){
   $.ajax("getProjectJoiner.do", {
      type : "get",
      dataType : "json",
      data : { "p_num":  p_num },
      async: false,
      success : function(data){
         var JoinerTodoList = "";
         var loginMNUM = $(".loginMNUM").val();
         
         $.each(data, function(){
            if(this.m_num != loginMNUM){
               JoinerTodoList += "<dl><dt>";
               JoinerTodoList += "<span class='memberName' data-index='"+ this.m_num +"'>";
               JoinerTodoList += this.g_name + " "+ this.role + " (" + this.depart + ")</span>";
               JoinerTodoList += "<span class='todoType'>";
                   JoinerTodoList += "</span></dt></dl>";
            }
         });
         $(".departTodo").html(JoinerTodoList);
      }
   });  
   getProjectNotJoiner(p_num);
}

/* 팝업 생성창에서 프로젝트 팀원 표시 */
function getProjectJoinerPop(p_num){
   $.ajax("getProjectJoiner.do", {
      type : "get",
      dataType : "json",
      data : { "p_num":  p_num },
      async: false,
      success : function(data){
         var JoinerListHtml = "";
         var loginMNUM = $(".loginMNUM").val();
         
         $.each(data, function(){
            JoinerListHtml += "<option value='"+ this.m_num +"'>"+ this.g_name;
            JoinerListHtml += " " + this.role;
            JoinerListHtml += " (" + this.depart + ")</option>";
         });
         
         $(".workPopWorker select").html(JoinerListHtml);
      }
   });  
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

/* 프로젝트 팀원 Todo 카운트 */
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

/* 나의 프로젝트 Todo 표시 */
function getProjectTodo(worker_m, p_num){
   $.ajax("getProjectTodo.do", {
      type : "get",
      dataType : "json",
      data : { "worker_m":  worker_m, "p_num": p_num },
      async: false,
      success : function(data){
         var projcetTodoHtml = "";
         
         $.each(data, function(){
            if(this.betweendate <= 1){
               projcetTodoHtml += "<li class='import'>";
            }else{
               projcetTodoHtml += "<li>";
            }
            
            projcetTodoHtml += "<a href='#' data-index='"+ this.t_num +"'>";
            projcetTodoHtml += "<span class='todoContTit'>" + this.title + "</span>";
            projcetTodoHtml += "<span class='deadLine'>";
            
            if(this.progress == '완료'){
               projcetTodoHtml += "(컨펌 진행중입니다.)</dd>";                        
            }else{
               projcetTodoHtml += "(마감일까지  "+ this.betweendate +"일 남았습니다)</dd>";            
            }
            
            projcetTodoHtml += "</span><span class='todoContTxt'>"+ this.text +"</span>";
            projcetTodoHtml += "</a></li>";
            
         });
         $(".projectTodo").html(projcetTodoHtml);
      }
   });   
}

/* 드래그 앤 드랍시 수정 */
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

/* 프로젝트 팀원들의 Todo 표시 */
function getProjectMemberTodo(worker_m, p_num){
   var dispHtml = "";
   $.ajax("getProjectTodo.do", {
      type : "get",
      dataType : "json",
      data : { "worker_m":  worker_m, "p_num": p_num },
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
            dispHtml += "<span class='deadLine'>(마감일까지  "+ this.betweendate +"일 남았습니다.)</span>";
            dispHtml += "<span class='todoContTxt'>"+ this.text +"</span>";
            dispHtml += "</a></li>";
         });
         dispHtml += "</ul></dd>";
      }
   });   
   return dispHtml;
}

/* 프로젝트 Todo 팝업 */
function getTodoDetail(t_num) {
	var locationPNUM = $(".locationPNUM").val();
	getProjectJoinerPop(locationPNUM);
   $.ajax("getTodoDetail.do", {
      type : "get",
      dataType : "json",
      async: false,
      success : function(data){
         $.each(data, function(){
            var dataTNUM = this.t_num;
            var dataOrderer = this.orderer + " " + this.o_role + " (" + this.depart + ")"; 
            var dataWorkerM = this.worker_m; 
            var dataWorker = this.worker + " " + this.w_role + " (" + this.depart + ")"; 
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

/* 프로젝트 초대창에서 참가하지 않고 있는 인원 조회 */
function getProjectNotJoiner(p_num) {
   $.ajax("getProjectNotJoiner.do", {
      type : "get",
      dataType : "json",
      data : { "p_num": p_num },
      async: false,
      success : function(data){
         var notJoinerHtml = "";
         $.each(data, function(){
            notJoinerHtml += "<tr>";
            notJoinerHtml += "<td>"+ this.g_name + "</td>";
            notJoinerHtml += "<td>"+ this.role + "</td>";
            notJoinerHtml += "<td>"+ this.depart + "</td>";
            notJoinerHtml += "<td><input type='button' class='inviteBtn' onclick='inviteProject("+ this.m_num +", "+ p_num +")'></td>";
            notJoinerHtml += "</tr>";
         });
         $(".teamAddPopup tbody").html(notJoinerHtml);
      }
   });
}

/* 드래그 앤 드랍시 UI 표시 */
function dragAnddrop(loginMNUM){
    $(".projectTodo, .departTodo ul").sortable({
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
            
            $(".projectTodo li, .departTodo ul li").each(function(){
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
	var locationPNUM = $(".locationPNUM").val();
	var loginMNUM = $(".loginMNUM").val();
   
   getProjectJoiner(locationPNUM);
   
   $(".departTodo dl").each(function(){
      var teamTodo = $(this).html();
      var workerM = $(this).find(".memberName").attr("data-index");
      
      teamTodo += getProjectMemberTodo(workerM, locationPNUM);
      $(this).html(teamTodo);
   });
   
   getTodoCnt();
   
   dragAnddrop(loginMNUM);
}

/* 프로젝트 인원 초대 */
function inviteProject(m_num, p_num) {
   $.ajax("inviteProject.do", {
      type : "post",
      dataType : "json",
      data : { "m_num":  m_num, "p_num": p_num },
      async: false,
      success : function(data){
         alert("초대되었습니다.");
         getProjectNotJoiner(p_num);
      }
   });
}

$().ready(function(){
   
   var locationPNUM = $(".locationPNUM").val();
   var loginMNUM = $(".loginMNUM").val();
   
   /* header active 효과 */
   $(".projectList li").each(function(){
      var p_num = $(this).attr("data-index");
      if(locationPNUM == p_num){
         $("header li").removeClass("active");
         $(this).addClass("active");
      }
   });
   
   $(".workAddBtn").click(function(){
      $("input[name=progress]:first-child").prop('checked', true);
       $(".workAddPopup").show();
       $(".darkBack").show();
       getProjectJoinerPop(locationPNUM);
   });
   
   $(document).on("click", ".projectTodo li a", function(){ 
      $('.workPopup td *').prop('disabled', false);
      $('.workPopup .workCategory select').prop('disabled', true);
      $('.workPopup .workPopLeader select').prop('disabled', true);
      $('.workPopup .popupOK').show();   
      
      getTodoDetail($(this).attr('data-index'));
        $(".workPopup").show();
        $(".darkBack").show();
   });   
   
   $(document).on("click", ".departTodo li a", function(){ 
      var detailTNUM = $(this).attr("data-index");
      
      $('.workPopup td *').prop('disabled', true);
      $('.workPopup .popupOK').hide();
      
      getTodoDetail(detailTNUM);
      
        $(".workPopup").show();
        $(".darkBack").show();
   });   
    
   $(".teamAddBtn").click(function(){
      $(".teamAddPopup").show();
      $(".darkBack").show();
   });
   
   todoSetInterval();
   setInterval("todoSetInterval()", 3000);
   
});