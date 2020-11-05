$(document).ready(function(){
   $(".header li").removeClass("active");
   $(".allInfo li").eq(2).addClass("active");

   /* 팝업창 중 검은 화면 클릭시 팝업창 꺼짐 */
   $(".darkBack").on("click",function(){
      $(".popup").hide();
      $(".darkBack").hide();
   });
   
   /* 팝업창 밑 확인버튼 클릭시 팝업창 꺼짐 */
   $(document).on("click", ".popupOK", function(){
      $(".popup").hide();
      $(".darkBack").hide();
   });
   
   /* 프로젝트 생성 버튼 클릭시 팝업창 처리 */
   $("#insertProject").on("click", function(){
      managerList();
      $(".insertProject").show();
      $(".darkBack").show();
   });
   
   /* enter key 막기*/
   $('input[type="text"]').keydown(function() {
      if (event.keyCode === 13) {
         event.preventDefault();
      };
   });
   
});

/* 매니저리스트 출력 함수 */
function managerList(m_num) {
   var mngHtml = '';
   console.log('managerList m_num : ' + m_num);
   
   
   $.ajax({
      url: '/biz/managerList.do?c_num='+c_num,
      type: 'get',
      data: c_num,
      success: function(mngList) {
         mngHtml += '<select>';
         for(var i = 0, len = mngList.length || 0; i < len; i++) {
            mngHtml += '<option class="mNumVal"value="'+mngList[i].m_num+'"';
               if(m_num == mngList[i].m_num) {
               
                  mngHtml += 'selected="selected"';
                  
               }
            mngHtml += '>'+mngList[i].g_name+' '+mngList[i].role+'('+mngList[i].depart+')';
            mngHtml += '</option>';
         }
         mngHtml += '</select>';
         
         $(".mngList").html(mngHtml);
         
         
      },
      error: function(error) {
         alert('error : ' + error);
      }
   })   
}

/* 월, 일 숫자가 10 이하일 때 앞에 숫자 0을 붙여주는 함수 */
function numberPad(n, width) {
    n = n + '';
    return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
}

/* yyyy-mm-dd 타입의 date 변환 함수 */
function conversionData(dateString) {
   var currentTime = new Date(parseInt(dateString));
   var month = currentTime.getMonth() + 1;
   var day = currentTime.getDate();
   var year = currentTime.getFullYear();
   
   if(month < 10) {
      //console.log('month under 10');
      month = numberPad(month, 2);
   } else if(day < 10) {
      //console.log('day under 10');
      day = numberPad(day, 2);
   }
   
   var date = year + "-" + month + "-" + day;
   //console.log(date);
   
   return date;
}
/* 프로젝트 클릭시 조회처리 */
function getPrj(p_num) {

   var getPrjHtml = '';
   var updatePrjHtml = '';
   console.log('p_num : ' + p_num + ', auth : ' + auth);
   
   $.ajax({
      url: '/biz/getPrj.do?p_num='+p_num,
      type: 'get',
      data: p_num,
      success: function(data) {
         //console.log('data : ' + JSON.stringify(data));
            if(auth == '관리자') {
            
               getPrjHtml += '<tr><th>제목</th><td><input type="text" name="prjName" id="prjName" value="'+data.name+'"></td></tr>';
               getPrjHtml += '<tr><th>주제</th><td><input type="text" name="prjSubject" id="prjSubject" value="'+data.subject+'"></td></tr>';
               getPrjHtml += '<tr><th>상태</th><td>';
               getPrjHtml += '<input type="radio" name="prjStatus" id="prjStatus" value="시작 전" ';
                  if(data.status=="시작 전") {
                     getPrjHtml += 'checked="checked"';
                  }
               getPrjHtml += '> 시작 전 &nbsp;&nbsp;';
               getPrjHtml += '<input type="radio" name="prjStatus" id="prjStatus" value="진행 중" ';
                  if(data.status=="진행 중") {
                     getPrjHtml += 'checked="checked"';
                  }
               getPrjHtml += '> 진행 중 &nbsp;&nbsp;';
               getPrjHtml += '<input type="radio" name="prjStatus" id="prjStatus" value="완료" ';
                  if(data.status=="완료") {
                     getPrjHtml += 'checked="checked"';
                  }
               getPrjHtml += '> 완료 &nbsp;&nbsp;';
               getPrjHtml += '</td></tr>';
               getPrjHtml += '<tr><th>관리자</th><td class="mngList getMngList"></td></tr>';
               getPrjHtml += '<tr><th>기간</th><td>';
               getPrjHtml += '<input type="date" name="startDate" id="startDate" value="'+conversionData(data.startDate)+'">&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;';            
               getPrjHtml += '<input type="date" name="endDate" id="endDate" value="'+conversionData(data.endDate)+'"></td></tr>';      
               getPrjHtml += '<tr><th>내용</th><td><textarea name="getPrjCon" id="getPrjCon" placeholder="내용을 입력하세요.">'+data.content+'</textarea>';
               getPrjHtml += '<input type="hidden" name="prjP_num" id="prjP_num" value="'+data.p_num+'"></td></tr>';      
               
                   updatePrjHtml += '<button type="button" id="updatePrjBtn" class="popupOK">수정</button>';
                   
            }
            
            if(auth == '멤버' || data.status == '완료') {
            
               getPrjHtml = '';
               updatePrjHtml = '';
            
               getPrjHtml += '<tr><th>이름</th><td><input type="text" name="prjName" id="prjName" value="'+data.name+'" readonly></td></tr>';
               getPrjHtml += '<tr><th>주제</th><td><input type="text" name="prjSubject" id="prjSubject" value="'+data.subject+'" readonly></td></tr>';
               getPrjHtml += '<tr><th>상태</th><td>';
               getPrjHtml += '<input type="radio" name="prjStatus" id="prjStatus" value="시작 전" ';
                  if(data.status=="시작 전") {
                     getPrjHtml += 'checked="checked"';
                  }
               getPrjHtml += ' disabled> 시작 전 &nbsp;&nbsp;';
               getPrjHtml += '<input type="radio" name="prjStatus" id="prjStatus" value="진행 중" ';
                  if(data.status=="진행 중") {
                     getPrjHtml += 'checked="checked"';
                  }
               getPrjHtml += ' disabled> 진행 중 &nbsp;&nbsp;';
               getPrjHtml += '<input type="radio" name="prjStatus" id="prjStatus" value="완료" ';
                  if(data.status=="완료") {
                     getPrjHtml += 'checked="checked"';
                  }
               getPrjHtml += ' disabled> 완료 &nbsp;&nbsp;';
               getPrjHtml += '</td></tr>';
               getPrjHtml += '<tr><th>관리자</th><td><input type="text" name="memName" id="memName" value="'+data.g_name+' '+data.role+'('+data.depart+')'+'" readonly></td></tr>';            
               getPrjHtml += '<tr><th>기간</th><td>';
               getPrjHtml += '<input type="date" name="startDate" id="startDate" value="'+conversionData(data.startDate)+'" readonly>&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;';            
               getPrjHtml += '<input type="date" name="endDate" id="endDate" value="'+conversionData(data.endDate)+'" readonly></td></tr>';      
               getPrjHtml += '<tr><th>내용</th><td><textarea name="getPrjCon" id="getPrjCon" placeholder="내용을 입력하세요." readonly>'+data.content+'</textarea></td></tr>';
               
               updatePrjHtml += '<button type="button" class="popupOK">확인</button>';
            }
            
         $("#getPrj").html(getPrjHtml);
         $(".updatePrjBtn").html(updatePrjHtml);
         
         managerList(data.m_num);
         
         $(".prjInfo").show();
         $(".darkBack").show();
         
      },
      error: function(error) {
         alert('error : ' + error);
      }
   })
}


$(document).ready(function(){

   /* 페이지 로드되자마자 리스트 호출 */
   init();
   
   /* 프로젝트 리스트 호출 */
   function init() {
      
      console.log('c_num : ' + c_num);
      var prjB = '';
      var prjO = '';
      var prjF = '';
      
      $.ajax({
         url: '/biz/prjList.do?c_num='+c_num,
         type: 'get',
         data: c_num,
         success: function(data) {
            console.log('projectList load success');
            
            for(var i = 0, len = data.length || 0; i < len; i++) {
            
               if(data[i].status=='시작 전') {
                  prjB += '<a href="javascript:void(0);" onclick="getPrj('+data[i].p_num+');"><dl class="projectThumb getPrjB">';
                  prjB += '<dt>'+data[i].name+'</dt>';
                  prjB += '<dd>'+data[i].subject+'</dd>';
                  prjB += '<dd>'+data[i].content+'</dd>';
                  prjB += '</dl></a>';
                  
               } else if(data[i].status=='진행 중') {
                  prjO += '<a href="javascript:void(0);" onclick="getPrj('+data[i].p_num+');"><dl class="projectThumb getPrjO">';
                  prjO += '<dt>'+data[i].name+'</dt>';
                  prjO += '<dd>'+data[i].subject+'</dd>';
                  prjO += '<dd>'+data[i].content+'</dd>';
                  prjO += '</dl></a>';
                  
               } else if(data[i].status=='완료') {
                  prjF += '<a href="javascript:void(0);" onclick="getPrj('+data[i].p_num+');"><dl class="projectThumb getPrjF">';
                  prjF += '<dt>'+data[i].name+'</dt>';
                  prjF += '<dd>'+data[i].subject+'</dd>';
                  prjF += '<dd>'+data[i].content+'</dd>';
                  prjF += '</dl></a>';
               }
            }
            $("#prjB").html(prjB);
            $("#prjO").html(prjO);
            $("#prjF").html(prjF);
            
         },
         error: function(error) {
            alert('error : ' + error);
         }
      });
   }
   
   /* 프로젝트 생성 버튼 클릭시 */
   $("#insertProjectBtn").on("click", function(){
      name = $("#prjName").val();
      status = $("input[name='prjChk_status']:checked").val();
      startDate = $("#prjStartDate").val();
      endDate = $("#prjEndDate").val();
      content = $("#prjContent").val();
      subject = $("#prjSubject").val();
      m_num = $("#instSelect select option:selected").val();
      
      if(name == ""){
         alert("프로젝트 이름을 입력해주세요");
         return false;
      }else if(startDate == ""){
         alert("프로젝트 시작일을 선택해주세요");
         return false;
      }else if(endDate == ""){
         alert("프로젝트 마감일을 선택해주세요");
         return false;
      }else if(content == ""){
         alert("내용을 입력해주세요");
         return false;
      }else if(subject == ""){
         alert("주제를 입력해주세요");
         return false;
      }
      
      
      $.ajax({
            url: '/biz/insertProject.do',
            type: 'post',
            data: 'name='+name+'&status='+status+'&startDate='+startDate+'&subject='+subject+
                  '&endDate='+endDate+'&content='+content+'&m_num='+m_num+'&c_num='+c_num,
            success: function(result) {
               if(result == 'success') {
                  init();
                  alert('프로젝트가 생성되었습니다.');
                  
               } else if(result == 'fail') {
                  alert('오류가 발생하였습니다. \n 다시 시도해주세요.');
                  return;
               }
            },
            error: function(error) {
               alert('error : ' + error);
            }
      });
      $("#prjName").val('');
      $("#prjStartDate").val('');
      $("#prjEndDate").val('');
      $("#prjContent").val('');
      $("#prjSubject").val('');
   });
   
   /* 프로젝트 업데이트 처리 */
   $(document).on("click", "#updatePrjBtn", function(){
   
      updName = $("input[name='prjName']").val();
      updSubject = $("input[name='prjSubject']").val();
      updStatus = $("input[name='prjStatus']:checked").val();
      updP_num = $("input[name='prjP_num']").val();
      updStartDate = $("input[name='startDate']").val();
      updEndDate = $("input[name='endDate']").val();
      updContent = $("#getPrjCon").val();
      updM_num = $(".getMngList select option:selected").val();
      
      if(updName == ""){
         alert("수정할 프로젝트 이름을 입력해주세요");
         return false;
      }else if(updStartDate == ""){
         alert("수정할 시작일을 선택해주세요");
         return false;
      }else if(updEndDate == ""){
         alert("수정할 마감일을 선택해주세요");
         return false;
      }else if(updContent == ""){
         alert("수정할 내용을 입력해주세요");
         return false;
      }else if(updSubject == ""){
         alert("수정할 주제를 입력해주세요");
         return false;
      }
      
      $.ajax({
         url: '/biz/updatePrjoect.do',
         type: 'post',
         data: 'name=' + updName + '&subject=' + updSubject + '&status=' + updStatus +
               '&p_num=' + updP_num + '&startDate=' + updStartDate +
               '&endDate=' + updEndDate + '&content=' + updContent + '&m_num=' + updM_num,
         success: function(result) {
            if(result == 'success') {
               alert('프로젝트가 수정되었습니다.');
               /*window.location.reload();   */
               init();   
               getAllProject();
            } else if(result == 'fail') {
               alert('오류가 발생하였습니다. \n 다시 시도해주세요.');
               return;
            }
         },
         error: function(error) {
            alert('error : ' + error);
         }
      });
   })
   
   /* search버튼 클릭시 */
   
   $("#searchBtn").on("click", function(){
   
      console.log('c_num : ' + c_num);
      prjB = '';
      prjO = '';
      prjF = '';
      
      searchForm = $("#searchForm");
      type = searchForm.find("option:selected").val();
      keyword = $("#keyword").val();
      if (keyword == ""){
         alert("검색어를 입력해주세요.");
      }
      console.log('type : ' + type + ', keyword : ' + keyword);
      
      $.ajax({
         url: '/biz/searchProject.do?type='+type+'&keyword='+keyword+'&c_num='+c_num,
         type: 'get',
         success: function(data) {
            
            for(var i = 0, len = data.length || 0; i < len; i++) {
            
               if(data[i].status=='시작 전') {
                  prjB += '<a href="javascript:void(0);" onclick="getPrj('+data[i].p_num+');"><dl class="projectThumb getPrjB">';
                  prjB += '<dt>'+data[i].name+'</dt>';
                  prjB += '<dd>'+data[i].subject+'</dd>';
                  prjB += '<dd>'+data[i].content+'</dd>';
                  prjB += '</dl></a>';
                  
               } else if(data[i].status=='진행 중') {
                  prjO += '<a href="javascript:void(0);" onclick="getPrj('+data[i].p_num+');"><dl class="projectThumb getPrjO">';
                  prjO += '<dt>'+data[i].name+'</dt>';
                  prjO += '<dd>'+data[i].subject+'</dd>';
                  prjO += '<dd>'+data[i].content+'</dd>';
                  prjO += '</dl></a>';
                  
               } else if(data[i].status=='완료') {
                  prjF += '<a href="javascript:void(0);" onclick="getPrj('+data[i].p_num+');"><dl class="projectThumb getPrjF">';
                  prjF += '<dt>'+data[i].name+'</dt>';
                  prjF += '<dd>'+data[i].subject+'</dd>';
                  prjF += '<dd>'+data[i].content+'</dd>';
                  prjF += '</dl></a>';
               }
            }
            $("#prjB").html(prjB);
            $("#prjO").html(prjO);
            $("#prjF").html(prjF);
            
         },
         error: function(error) {
            alert('error : ' + error);
         }
      })
   });
   
});

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

