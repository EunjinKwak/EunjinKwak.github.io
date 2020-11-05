function set101(frm){
	var m_num = $(".chatM_num").val();
	var set = setChatMember2(m_num);
	if (set != null) {
		frm.action="getChatMember2_In.do?room_id=" + set;
		frm.submit();
	} else {
	    frm.action="insert11Chat.do";
	    frm.submit();
	}
}

function set202(frm){
	var room_id = $(".chatRoom_id").val();
		frm.action="getChatMember2_In.do?room_id=" + room_id;
		frm.submit();
}

//------------------------ ajax ------------------------------	

function insertNotice() {
	
	var message = $(".textarea").val();
	var p_num = $(".p_num").val();
	
	if(message == ""){
		alert("메세지를 입력하세요");
		return;
	}
	
	$.ajax("insertNotice.do", {
		type : "post",
		dataType : "json",
		data : "message=" + message + "&p_num=" + p_num,
		success : function(data) {
			
			$(".textarea").val("");
		},
		error : function(){
			
		}
	});
}

function updateNotice() {
	
	var content = $(".conText").val();
	
	$.ajax("updateNotice.do", {
		type : "post",
		dataType : "json",
		async: false,
		data : "content=" + content,
		success : function(data) {
			$(".conText").val("");
		},
		error : function(){
			
		}
	});
}

/* function getConditionMsg() {
	$.ajax("getChatMember.do", {
		type : "post",
		dataType : "json",
		success : function(data){
			var a = "";

				a += "<li>";
				a += "<img src='img/profile.png' width='110px'>";
				a += "</li>";
				a += "<li>" + this.g_name + "</li>";
				a += "<li>";
				a += "<a href='#' class='conMsg'>" + this.content + "</a>";
				a += "</li>";
				
			$(".msgPopupD").html(a);
		},
		error : function(){
			
		}		
	});
} */

function getNoticeList() {
	var p_num = $(".p_num").val();

	$.ajax("getNoticeList.do", {
		type : "post",
		dataType : "json",
		data : "p_num=" + p_num,
		async: false,
		success : function(data, index){
			var chatCnt = data.length;
			var chatBoxCnt = $(".chatBox dl").length;
		    if(data.length != chatBoxCnt){
				$(".chatBox").scrollTop($(".chatBox")[0].scrollHeight);	    
		    }
			console.log(chatCnt);		
			
		    var today = new Date();
		    var todayYear = today.getFullYear();
		    var todayMonth = today.getMonth()+1;
		    var todayDate = today.getDate();
		    var selectDate = String(todayYear)+String(todayMonth)+String(todayDate);
		    var dl = "";
		    
			for(var i=0; i<data.length; i++){
				if(i == 0){
					dl += "<p>";
					dl += "<span>"+ data[i].chatdate +"</span>";
					dl += "</p>";	
				}else if(i > 0){
					if(data[i].chatdate != data[i-1].chatdate){
						dl += "<p>";
						dl += "<span>"+ data[i].chatdate + "</span>";
						dl += "</p>"
					}
				}
				
				
				dl += "<dl>";
				dl += "<dt>" + data[i].g_name + " " + data[i].role + "</dt>";
				dl += "<dd class='chatBoxCont1'>" + data[i].message + "</dd>";
				dl += "<dd class='chatTime'>" + data[i].time + "</dd>";
				dl += "</dl>";
			}

			$(".chatBox").html(dl);
		},
		error : function(){

		}
	});
}

function getNoticeList_Search() {
	
	var searchMember = $(".searchBoxx").val();
	
	$.ajax("getNoticeList_Search.do", {
		type : "post",
		dataType : "json",
		data : "searchMember=" + searchMember,
		success : function(data){
			if(searchMember != ""){
				var a = "";
				$.each(data, function(){
					a += "<a href='#' class='profileImg'>";
					a += "<input type='hidden' name='m_num' value='" + this.m_num + "'>";
					a += "<dl>";
					a += "<dt class='memPopup'>" + this.g_name + " " + this.role + "</dt>";
					a += "<dd class='onlineId'>" + this.content + "</dd>";
					a += "</dl>";
					a += "</a>";
				})
			}else{
				getChatMember();
			}
			
			$(".msgPopupAA").html(a);
		},
		error : function(){
			
		}
	});	
}

function getNoticeList_Search2() {
	
	var searchMember = $(".searchBoxx2").val();
	var guestInfo = $(".guestInfo").val();
	$.ajax("getNoticeList_Search2.do", {
		type : "post",
		dataType : "json",
		data : "searchMember=" + searchMember,
		success : function(data){
			if(searchMember != ""){
				var a = "";
				$.each(data, function(){
					a += "<a href='#' class='profileImg2'>";
					a += "<input type='hidden' name='room_id' value='" + this.room_id + "'>";
					a += "<dl>";
					a += "<dt class='memPopup2'>" + guestInfo + ", " + this.g_name + " " + this.role + "</dt>";
					a += "</dl>";
					a += "</a>";
				})
			}else{
				getChatMember2();
			}
			
			$(".msgPopupBB").html(a);
		},
		error : function(){
			
		}
	});	
}

function insertMessenger(room_id) {
	
	var message = $(".textarea2").val();
	
	if(message == ""){
		alert("메세지를 입력하세요");
		return;
	}
	
	$.ajax("insertMessenger.do", {
		type : "post",
		dataType : "json",
		data : "message=" + message + "&room_id=" + room_id,
		success : function(data) {
			
			$(".textarea2").val("");
		},
		error : function(){
			
		}
	});
}

function getMessengerList() {
	var room_id = $(".room_id").val();
	$.ajax("getMessengerList.do", {
		type : "post",
		dataType : "json",
		data : { "room_id":  room_id },
		success : function(data){
			var chatCnt = data.length;
			var chatBoxCnt = $(".chatBox dl").length;
			if(data.length != chatBoxCnt){
				$(".chatBox").scrollTop($(".chatBox")[0].scrollHeight);	    
		    }
		    
		    var today = new Date();
		    var todayYear = today.getFullYear();
		    var todayMonth = today.getMonth()+1;
		    var todayDate = today.getDate();
		    var selectDate = String(todayYear)+String(todayMonth)+String(todayDate);
		    var dl = "";
		    
			for(var i=0; i<data.length; i++){
				if(i == 0){
					dl += "<p>";
					dl += "<span>"+ data[i].chatdate +"</span>";
					dl += "</p>";	
				}else if(i > 0){
					if(data[i].chatdate != data[i-1].chatdate){
						dl += "<p>";
						dl += "<span>"+ data[i].chatdate + "</span>";
						dl += "</p>"
					}
				}
				
				dl += "<dl>";
				dl += "<dt>" + data[i].g_name + " " + data[i].role + "</dt>";
				dl += "<dd class='chatBoxCont1'>" + data[i].message + "</dd>";
				dl += "<dd class='chatTime'>" + data[i].time + "</dd>";
				dl += "</dl>";
			}
			
			$(".chatBox").html(dl);
		},
		error : function(){

		}
	});
}

function getChatMember() {
	$.ajax("getChatMember.do", {
		type : "post",
		dataType : "json",
		success : function(data){
			var a = "";
			$.each(data, function(){
				a += "<a href='#' class='profileImg'>";
				a += "<input type='hidden' name='m_num' value='" + this.m_num + "'>";
				a += "<dl>";
				a += "<dt class='memPopup'>" + this.g_name + " " + this.role + "</dt>";
				a += "<dd class='onlineId'>" + this.content + "</dd>";
				a += "</dl>";
				a += "</a>";
			})
			
			$(".msgPopupAA").html(a);
		},
		error : function(){
			
		}		
	});
}

function getChatMember2() {
	var guestInfo = $(".guestInfo").val();
	$.ajax("getChatMember2.do", {
		type : "post",
		dataType : "json",
		success : function(data){
			var originTxt = "";
			$.each(data, function(){
				originTxt += "<a href='#' class='profileImg2'>";
				originTxt += "<input type='hidden' name='room_id' value='" + this.room_id + "'>";
				originTxt += "<dl>";
				originTxt += "<dt class='memPopup2'>" + guestInfo + ", " + this.g_name + " " + this.role + "</dt>";
				originTxt += "</dl>";
				originTxt += "</a>";
				
			})
			
			$(".msgPopupBB").html(originTxt);
		},
		error : function(){

		}
	});
}

function setChatMember2(m_num) {
		var set;
	$.ajax("setChatMember2.do", {
		type : "post",
		dataType : "json",
		async: false,
		success : function(data){
			$.each(data, function(){
				if (m_num == this.m_num) {
					set = this.room_id;
				} 
			})
		},
		error : function(request,status,error){
			    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
	return set;
}

function getChatMember_Me() {
   $.ajax("getChatMember_Me.do", {
      type : "post",
      dataType : "json",
      success : function(data){
         var a = "";
         $.each(data, function(){
            a += "<a href='#' class='profileImg'>";
            a += "<input type='hidden' name='m_num' value='" + this.m_num + "'>";
            a += "<dl>";
            a += "<dt class='memPopup'>" + this.g_name + " " + this.role + "</dt>";
            a += "<dd class='onlineId'>" + this.content + "</dd>";
            a += "</dl>";
            a += "</a>";
         })
         
         $(".msgPopupI").html(a);
      },
      error : function(){
         
      }      
   });
}
	


// 전체보기 탭 -> 멤버 불러오기 메소드
function departList(teamList, depart) {
	teamList += "<ul class='memberTeam'>";
	teamList += "<li class='memberTeamNav'><a href='#'>" + depart + "</a></li>";
	teamList += "<li class='memberList'>";
	teamList += "</li>";
	teamList += "</ul>";
	return teamList;
}

// 멤버초대 -> 멤버 불러오기 메소드
function searchAdd(searchList, g_name, email, r_num, role, d_num, depart, authority, g_num) {
	searchList += "<tr>";
	//searchList += "<th><img src='img/usericon.png'  alt=''></th>"
    searchList += "<td class='name_gmail' width='40%'>";
    searchList += "<p>" + g_name + "</p>";
    searchList += "<p class='emailTxt'>" + email + "</p>";
    searchList += "</td>";
    searchList += "<td width='60px'>";
    searchList += "<select class='sel' id='depart' name='depart'>";
    searchList += "<option>그룹선택</option>";
    searchList += "<option value='"+ depart +"'>" + depart + "</option>";
    searchList += "</select>";
    searchList += "</td>";
    searchList += "<td width='60px'>";
    searchList += "<select class='rSel' id='role' name='role'>";
    searchList += "<option>직책선택</option>";
    searchList += "<option value='"+ role +"'>" + role + "</option>";
    searchList += "</select>";
    searchList += "</td>";
    searchList += "<td width='60px'>";
    searchList += "<select id='authority' name='authority'>";
    searchList += "<option>권한선택</option>";
    searchList += "<option value='관리자'> 관리자</option>";
    searchList += "<option value='멤버'>멤버</option>";
    searchList += "</select>";
    searchList += "</td>";
    searchList += "<td class='buttons'><input type='hidden' class='insertGNUM' value='"+ g_num +"'>";
	searchList += "<input type='button' class='insertBtn' value='초대'></td>";
    searchList += "</tr>";
    return searchList;
}

// 멤버수정 탭 -> 멤버 불러오기 메소드
function upMember(upList, g_name, email, r_num, role, d_num, depart, authority, m_num) {
	upList += "<tr>";
	upList += "<th><img src='img/usericon.png'  alt=''></th>"
	upList += "<td class='name_gmail'>";
	upList += "<p>" + g_name +"&nbsp" + role + "</p>";
	//upList += "<p class='emailTxt'>" + email + "</p>";
	upList += "</td>";
	upList += "<td>";
	upList += "<select class='sel' id='depart' name='depart'>";
	upList += "<option class='resultDepart'>" + depart + "</option>";
	upList += "</select>";
	upList += "</td>";
	upList += "<td>";
    upList += "<select class='rSel' id='role' name='role'>";
	upList += "<option class='resultRole'>" + role + "</option>";
    upList += "</select>";
    upList += "</td>";
	upList += "<td>";
	upList += "<select id='authority' name='authority'>";
	upList += "<option>권한선택</option>";
    if(authority == '관리자'){
	    upList += "<option value='관리자' selected> 관리자</option>";
	    upList += "<option value='멤버'>멤버</option>";
    }else{
	    upList += "<option value='관리자'> 관리자</option>";
	    upList += "<option value='멤버' selected>멤버</option>";
    }
	upList += "</select>";
	upList += "</td>";
	upList += "<td class='buttons'><input type='hidden' class='updateMNUM' value='"+ m_num +"'>";
	upList += "<input type='button' class='updateBtn' value='수정'></td>";
	upList += "</tr>";
	return upList;
}

// 멤버삭제 탭 -> 멤버 불러오기 메소드
function delMember(delList, g_name, role, email, depart, authority, m_num) {
	delList += "<tr>";
	delList += "<th><img src='img/usericon.png'  alt=''></th>"
	delList += "<td class='name_gmail'>";
    delList += "<p>" + g_name + "&nbsp" + role  + "</p>";
    //delList += "<p class='emailTxt'>" + email + "</p>";
    delList += "</td>";
    delList += "<td>" + depart + "</td>";
    delList += "<td>" + authority + "</td>";
    delList += "<td class='buttons'><input type='button' onclick='deleteMember("+ m_num + ")' value='삭제'></td>";
	delList += "</tr>";
	return delList;
}


// 멤버수정 탭 검색 -> 멤버 불러오기 메소드
function searchUp(searchUpList, g_name, email, r_num, role, d_num, depart, authority, m_num) {
	searchUpList += "<tr>";
	searchUpList += "<th><img src='img/usericon.png'  alt=''></th>"
    searchUpList += "<td class='name_gmail'>";
    searchUpList += "<p>" + g_name +"&nbsp" + role + "</p>";
    //searchUpList += "<p class='emailTxt'>" + email + "</p>";
    searchUpList += "</td>";
	searchUpList += "<td>";
	searchUpList += "<select class='sel' id='depart' name='depart'>";
	searchUpList += "<option class='resultDepart'>" + depart + "</option>";
	searchUpList += "</select>";
	searchUpList += "</td>";
	searchUpList += "<td>";
    searchUpList += "<select class='rSel' id='role' name='role'>";
	searchUpList += "<option class='resultRole'>" + role + "</option>";
    searchUpList += "</select>";
    searchUpList += "</td>";
    searchUpList += "<td>";
    searchUpList += "<select id='authority' name='authority'>";
    searchUpList += "<option>권한선택</option>";
    if(authority == '관리자'){
	    searchUpList += "<option value='관리자' selected> 관리자</option>";
	    searchUpList += "<option value='멤버'>멤버</option>";
    }else{
	    searchUpList += "<option value='관리자'> 관리자</option>";
	    searchUpList += "<option value='멤버' selected>멤버</option>";
    }
    searchUpList += "</select>";
    searchUpList += "</td>";
    searchUpList += "<td class='buttons'><input type='hidden' class='updateMNUM' value='"+ m_num +"'>";
	searchUpList += "<input type='button' class='updateBtn' value='수정'></td>";
    searchUpList += "</tr>";
    return searchUpList;
}

// 멤버삭제 탭 검색 -> 멤버 불러오기 메소드
function searchDel(searchDelList, g_name, role, email, depart, authority, m_num) {
	searchDelList += "<tr>";
	searchDelList += "<th><img src='img/usericon.png'  alt=''></th>"
	searchDelList += "<td class='name_gmail'>";
    searchDelList += "<p>" + g_name  + "&nbsp" + role + "</p>";
    //searchDelList += "<p class='emailTxt'>" + email + "</p>";
    searchDelList += "</td>";
    searchDelList += "<td>" + depart + "</td>";
    searchDelList += "<td>" + authority + "</td>";
    searchDelList += "<td class='buttons'><input type='button' onclick='deleteMember("+ m_num + ")' value='삭제'></td>";
	searchDelList += "</tr>";
    return searchDelList;
}

// 부서 불러오기
function getDepart(memberDepart, selectDepart) {
	$.ajax("getDepart.do", {
		type : "get",
		dataType : "json",
		async : "false",
		success : function(data) {
		var upList = "";
		
		upList += "<option>그룹선택</option>";
			$.each(data, function(){
				var depart = this.depart; 
				var d_num = this.d_num;
				
				if(memberDepart == depart){
			    	upList += "<option value='"+ depart +"' selected>" + depart + "</option>";				
				}else{
			    	upList += "<option value='"+ depart +"'>" + depart + "</option>";								
				}
	    	
	        });
			selectDepart.html(upList);
		},
		error : function(){
			alert("getDepart()실패");
		}
	});
}
// 직책 불러오기 
function getRoles(memberRole, selectRole) {
	$.ajax("getMemberRoles.do", {
		type : "get",
		dataType : "json",
		async : "false",
		success : function(data) {
		var upList = "";
		console.log("실행");
		upList += "<option>직책선택</option>";
			$.each(data, function(){
				var role = this.role; 
				var r_num = this.r_num;
				if(memberRole == role){
			    	upList += "<option value='"+ role +"' selected>" + role + "</option>";			
				}else{
			    	upList += "<option value='"+ role +"'>" + role + "</option>";							
				}
	    	
	        });
			selectRole.html(upList);
		},
		error : function(){
     		alert("getRoles()실패");
		}
	});
}

//전체보기 탭 리스트 불러오기
function getDepartMember() {
	$.ajax("getAllMember.do", {
		type : "get",
		dataType : "json",
		async : "false",
		success : function(data) {
		
		$(".memberTeam").each(function(){
			var fixDepart = $(this).find(".memberTeamNav a").text();
			var originText = "";
			
	        originText += "<ul>";
			$.each(data, function(){
				var g_name = this.g_name;
				var m_num = this.m_num;
				var depart = this.depart;
				var email = this.email;
				var role = this.role;
				
	            if(fixDepart == depart){
	            	originText += "<li data-index='"+ m_num +"'><img src='img/usericon.png' alt=''>" + g_name + "&nbsp" + role + "&nbsp&nbsp&nbsp" + email + "</li>";
	            }
        	});
	        originText += "</ul>";
        	$(this).find(".memberList").html(originText);
		});
		},
		error : function(){
     		alert("getDepartMember()실패");
		}
   });
}

// 전체보기 탭 -> 검색하기
function searchAllMember() {
	var inputVal = $("#allKeyword").val();
	$.ajax("searchAllMember.do", {
		type : "get",
		async : "false",
		data : { "g_name": inputVal, "email": inputVal },  
		success : function(data) {
			if(inputVal != ""){
				$(".memberCont .tab_content > div").eq(0).find(".memberList").hide();
	            /*$(".memberCont .tab_content > div").eq(0).find(".memberList ul").empty();*/
				
            	$(".memberTeamNav").removeClass("active");
            	
				$.each(data, function(){
					var g_name = this.g_name;
					var email = this.email;
					var depart = this.depart;
					var authority = this.authority;
					var g_num  = this.g_num;
					var d_num  = this.d_num;
					var m_num  = this.m_num;
					var role = this.role;
				
					$(".memberTeam").each(function(){
						
						var fixed = $(this).find(".memberTeamNav a").text();
						var searchList = $(this).find(".memberList ul li");
						var memberList = $(this).find(".memberList");
						var memberLi = $(this).find(".memberTeamNav");
						
			            if(fixed == depart){
			            	memberLi.addClass("active");
				        	memberList.show();
			            } 
					});
				});	
				
				$("#allKeyword").val("");
			}else{
				$(".memberList").show();
				$(".memberTeamNav").addClass("active");
				getDepartMember();
			}
		},
		error : function(request, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 멤버리스트 불러오기
function getMember() {
	$.ajax("getMember.do", {
		type : "get",
		dataType : "json",
		async : "false",
		success : function(data) {
		var delList = "";
		var upList = "";		
		 
		$.each(data, function(){
			var g_name = this.g_name;
			var email = this.email;
			var depart = this.depart;
			var authority = this.authority;
			var d_num = this.d_num;
			var m_num = this.m_num;
			var r_num = this.r_num;
			var role = this.role;
			
            upList = upMember(upList, g_name, email, r_num, role, d_num, depart, authority, m_num);
            delList = delMember(delList, g_name, role, email, depart, authority, m_num);
		});
	        $(".delMember table").html(delList);
	        $(".upMember table").html(upList);
	        
			$(".upMember table tr").each(function(){
				var tableRow = $(this);
				
				var departSel = tableRow.find(".sel");
				var roleSel = tableRow.find(".rSel");
				
				var resultDepart = tableRow.find(".resultDepart").text();
				var resultRole = tableRow.find(".resultRole").text();
				
				getRoles(resultRole, roleSel);
				getDepart(resultDepart, departSel);
			});
		},
		error : function(){
			alert("getMember()실패");
		}
	});
	
}

// 멤버 추가 탭 -> 검색하기
function searchAddMember() {
	var inputVal = $("#keyword").val();
	$.ajax("searchAddMember.do", {
		type : "get",
		async : "false",
		data : { "g_name": inputVal, "email": inputVal },  
		success : function(data) {
			var searchList = "";
			$.each(data, function(){
				var g_name = this.g_name;
				var email = this.email;
				var depart = this.depart;
				var authority = this.authority;
				var g_num  = this.g_num;
				var d_num  = this.d_num;
				var r_num  = this.r_num;
				var role  = this.role;
				
	            searchList = searchAdd(searchList, g_name, email, r_num, role, d_num, depart, authority, g_num);
	        });
	        
			$(".addMember table").html(searchList);
			
			var rSel = $(".addMember").find(".rSel");
			var Dsel = $(".addMember").find(".sel");
			
            getDepart("", Dsel);
            getRoles("", rSel);
		},
		error : function(request, error){
     		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 멤버 초대 유효성
function selectMember(clickGNUM, role, depart, authority) {
	var search_var = ""; 
	$.ajax("selectMember.do", {
		type : "get",
		dataType : "json",  
		async : "false",
		success : function(data) {
			$.each(data, function(){
				var g_num  = this.g_num;
				
				if(clickGNUM == g_num){
					search_var = true;
				}
	        });
	        
			if(search_var){
				alert("이미 초대된 회원입니다.");
			} else{
				alert("초대되었습니다.");	
				insertMember(clickGNUM, role, depart, authority);	
			}
		},
		error : function(request, error){
     		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 멤버 수정 탭 -> 검색하기
function searchUpMember() {
	var inputVal = $("#upKeyword").val();
	$.ajax("searchUpMember.do", {
		type : "get",
		async : "false",
		data : { "g_name": inputVal, "email": inputVal },  
		success : function(data) {
			var searchUpList = "";
		
			$.each(data, function(){
				var g_name = this.g_name;
				var email = this.email;
				var depart = this.depart;
				var authority = this.authority;
				var m_num  = this.m_num;
				var d_num  = this.d_num;
				var c_num  = this.c_num;
				var r_num  = this.r_num;
				var role  = this.role;
				
	            searchUpList = searchUp(searchUpList, g_name, email, r_num, role, d_num, depart, authority, m_num);
	        });
			$(".upMember table").html(searchUpList);
			
			$(".upMember table tr").each(function(){
				var tableRow = $(this);
				
				var departSel = tableRow.find(".sel");
				var roleSel = tableRow.find(".rSel");
				
				var resultDepart = tableRow.find(".resultDepart").text();
				var resultRole = tableRow.find(".resultRole").text();
				
				getDepart(resultDepart, departSel);
				getRoles(resultRole, roleSel);
			});
		},
		error : function(request, error){
     		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}


// 멤버 삭제 탭 -> 검색하기
function searchDelMember() {
	var inputVal = $("#delKeyword").val();
	$.ajax("searchDelMember.do", {
		type : "get",
		async : "false",
		data : { "g_name": inputVal, "email": inputVal },  
		success : function(data) {
			var searchDelList = "";
			
			$.each(data, function(){
				var g_name = this.g_name;
				var email = this.email;
				var depart = this.depart;
				var authority = this.authority;
				var d_num = this.d_num;
				var m_num = this.m_num;
				var role = this.role;
				
	            searchDelList = searchDel(searchDelList, g_name, role, email, depart, authority, m_num);
	            
	        });
			$(".delMember table").html(searchDelList);
		},
		error : function(request, error){
     		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}



// 전체보기 부서 불러오기
function viewGetDepart() {
	$.ajax("getDepart.do", {
		type : "get",
		dataType : "json",
		async : "false",
		success : function(data) {
			var teamList = "";
			var g_name = this.g_name;
			var email = this.email;
		
			teamList += "<p class='projectSearch search'>";
	    	teamList += "<input type='text' id = 'allKeyword' placeholder='이름, 이메일 중 하나를 입력해주세요.'>";
	    	teamList += "<input type='button' class='searchAllBnt' onclick='searchAllMember()' value=''>";
			teamList += "</p>";
		
			$.each(data, function(){
				var depart = this.depart;
		    	teamList = departList(teamList, depart);
	        });
	        
			$(".allGetMember").html(teamList);		
		},
		error : function(){
     		alert("viewGetDepart()실패");
		}
	});
}

// 멤버 초대
function insertMember(g_num, role, depart, authority){
	$.ajax("insertMember.do", {
		type : "post",
		async : "false",
		data : "g_num=" + g_num + "&role=" + role + "&depart=" + depart + "&authority="+ authority,
		success : function(data) {
				
		},
		error : function(request, error){
 			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}
	
// 멤버 수정
function updateMember(m_num, role, depart, authority){
	$.ajax("updateMember2.do", {
		type : "post",
		async : "false",
		data : "m_num=" + m_num + "&role=" + role + "&depart=" + depart + "&authority="+ authority,
		success : function(data) {
			alert("수정되었습니다.");
		},
		error : function(request, error){
 			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 멤버 삭제
function deleteMember(m_num){
	$.ajax("deleteMember.do", {
		type : "post",
		async : "false",
		data : "m_num=" + m_num,
		success : function(data) {
			alert("삭제되었습니다.");
		},
		error : function(request, error){
 			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
     	}
	});
}	


$().ready(function(){

	viewGetDepart();
	getMember();
	getDepartMember();	
	
    // 팝업 닫기
    $(".pop dt a, .popupM dt a, .darkBack").click(function(){
        $(".pop").removeClass("show");
        $(".popupM").removeClass("show");
        $(".darkBack").hide();
    });

    // 팝업닫기
    $(".popupOK, .popup dt a, .darkBack").click(function(){
    	$(".popupP2").hide();
        $(".popup").hide();
        $(".popupM").removeClass("show");
        $(".popupP").hide();
        $(".darkBack").hide();
    });

 	/********** 멤버팝업(은진) **********/
    
	// 초대버튼 클릭 시
	$(document).on("click", ".insertBtn", function (e) {
		var tableRow = $(this).closest("tr");
		var g_num = tableRow.find(".insertGNUM").val();
		var role = tableRow.find("#role option:selected").val();
		var depart = tableRow.find("#depart option:selected").val();
		var authority = tableRow.find("#authority option:selected").val();
	
		selectMember(g_num, role, depart, authority);
	});
	
	// 수정버튼 클릭 시
	$(document).on("click", ".updateBtn", function (e) {
		var tableRow = $(this).closest("tr");
		var m_num = tableRow.find(".updateMNUM").val();
		var role = tableRow.find("#role option:selected").val();
		var depart = tableRow.find("#depart option:selected").val();
		var authority = tableRow.find("#authority option:selected").val();
		updateMember(m_num, role, depart, authority);
	});
	
    // 아이콘 클릭 -> 팝업창띄우기 
    $(document).on("click", ".members", function (e) { 
        $(".pop").addClass("show");
        $(".darkBack").show();
        $(".memberCont .tab_content > div").hide();
        $(".memberCont .tab_content > div").eq(0).show();
        $(".memberCont .tabs li").removeClass("active");
        $(".memberCont .tabs li").eq(0).addClass("active");
    });
    
    // 첫 팝업창에서 전체보기 default
    $(".memberCont .tabs li:first").click(function(){
        $(this).addClass("active").show();
        //$(".memberCont .allTap").show();
    });
    
    // 탭메뉴 선택
    $(document).on("click", ".memberCont .tabs li", function (e) { 
		viewGetDepart();
		getMember();
		getDepartMember();
		
		$(".memberCont .tab_content > div").eq(1).find("table").empty();
		
		$("#allKeyword").val("");
		$("#keyword").val("");
		$("#upKeyword").val("");
		$("#delKeyword").val("");
		
    	var idx = $(this).index();
        $(".memberCont .tab_content > div").hide();
        $(".memberCont .tab_content > div").eq(idx).show();
        $(".memberCont .tabs li").removeClass("active");
        $(this).addClass("active");
    });
    
    // 전체보기에서 토글
    $(document).on("click", ".memberTeamNav", function (e) { 
    	$(this).next().toggle();
        $(this).toggleClass("active");
    });   
    
    /********** 채팅팝업(민형) **********/

    // 팝업열기
    $(".chatBtn a").click(function(){
        $(".msgPopup").toggleClass("show");
        $(".msgPopupAll > div").hide();
        $(".msgPopupAll > div").eq(0).show();
        $(".msgPopupC li").removeClass("active");
        $(".msgPopupC li").eq(0).addClass("active");
        $(".darkBack").show();
    });

    //채팅 멤버/대화방 탭
    $(".msgPopupC li").click(function(){
        var idx = $(this).index(); // --> 0
        $(".msgPopupC li").removeClass("active");
        $(this).addClass("active");
        $(".msgPopupAll > div").hide();
        $(".msgPopupAll > div").eq(idx).show();
    });
    
    //프로필 창 열기
    $(".profileImg").click(function(){
    	$(".chatProfile2").hide();
        $(".chatProfile").show();
        $(".darkBack").show();
    });
    
    $(".profileImg2").click(function(){
    	$(".chatProfile").hide();
        $(".chatProfile2").show();
        $(".darkBack").show();
    });
    
    //프로필 창 닫기
    $(".popupOK1").click(function(){
        $(".chatProfile").hide();
        $(".chatProfile2").hide();
        $(".msgPopup").show();
    });
    
    //상태메세지 수정 창
    $(".conMsg").click(function(){
    	$(".conditionMsg").show();
    	$(".darkBack").show();
    });
    
    $(".set44").click(function(){
    	$(".conditionMsg").hide();
    });
    
    //-------------- notice.jsp -------------------------
    
    $(".sendBtn").click(function(){
		insertNotice();
		getNoticeList();
	});
	
	$(".textarea").keypress(function(event){
	     if (event.which == 13) {
	         $(".sendBtn").click();
	         return false;
	     }
	});
	
	
		
	/* var scroll = document.getElementsByClassName("chatBox");
	scroll.scrollTop = scroll.scrollHeight; */

	/* var chatBoxId = document.getElementById("chatBoxId");
	chatBoxId.scrollTop = chatBoxId.scrollHeight; */

	/* $(".chatBox").scrollTop(
		$(".chatBox")[0].scrollHeight
	); */
	
	$(".chatBtn").click(function(){
		getChatMember_Me();
		getChatMember();
		getChatMember2();
	});
	
	$(document).on("click", ".profileImg", function (e) {
		/* getConditionMsg(); */
		
		var name = $(this).find(".memPopup").text();
		$(".msgPopupD li").eq(1).text(name);

		var condition = $(this).find(".onlineId").text();
		$(".msgConPop").text(condition);
					
		var loginMNUM = $(".loginMNUM").val();
		var chatM_num = $(this).find("input").val();
		$(".chatM_num").val(chatM_num);
		
		if(loginMNUM == chatM_num){
			$(".conMsg").show();
		}else{
			$(".conMsg").hide();
		}
		
		$(".chatProfile2").hide();
		$(".chatProfile").show();
        $(".darkBack").show();
	});
	
	$(document).on("click", ".profileImg2", function (e) {
	
		var name = $(this).find(".memPopup2").text();
		$(".msgPopupD2 li").eq(1).text(name);
		
		var chatRoom_id = $(this).find("input").val();
		$(".chatRoom_id").val(chatRoom_id);
		
		$(".chatProfile").hide();
		$(".chatProfile2").show();
        $(".darkBack").show();
	});
	
	$(".searchBtnn").click(function(){
		getNoticeList_Search();
	});
	
	$(".searchBoxx").keypress(function(event){
	     if (event.which == 13) {
	         $(".searchBtnn").click();
	         return false;
	     }
	});
	
	$(".set99").click(function(){
		updateNotice();
		getChatMember_Me();
		$(".conditionMsg").hide();
		$(".chatProfile").hide();
	});
	

	//------------------ messenger.jsp -------------------------
	
	var room_id = $(".room_id").val();
	
	$(".sendBtn2").click(function(){
		insertMessenger(room_id);
		getMessengerList(room_id);
	});
	
	$(".textarea2").keypress(function(event){
	     if (event.which == 13) {
	         $(".sendBtn2").click();
	         return false;
	     }
	});
	
	$(".searchBtnn2").click(function(){
		getNoticeList_Search2();
	});
	
	$(".searchBoxx2").keypress(function(event){
	     if (event.which == 13) {
	         $(".searchBtnn2").click();
	         return false;
	     }
	});
})
