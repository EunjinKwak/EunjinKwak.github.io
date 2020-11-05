
	
	/* otherlogin API 시작*/
	
	<!-- Kakao API -->
	/*
		카카오 로그인은 사용하지 않음.
	*/
	
	/*
		kakao api를 사용하여 javascript로 카카오 아이디를 통해 회원가입을 설정하였음.
		token에 대한 response 로 받은 id를 db에 select하여 없는 값이면 자동으로 회원가입을 설정하였고,
		있는 값이면 login만 되도록 처리하였음.
	*/
	
	function kakaoInit() {
	   	// SDK를 초기화 합니다.
   		Kakao.init('34a62fd0597315633988b8d54a2c0ed4');
		
        // SDK 초기화 여부를 판단합니다.
        console.log('kakao isinit?' + Kakao.isInitialized());
	}
	
	/* 카카오톡 로그인 창이 뜨는 부분 */
	function loginWithKakao() {
		Kakao.Auth.login({
			success: function(authObj) {
				//alert(JSON.stringify(authObj));
				
				Kakao.API.request({
					url: '/v2/user/me',
					success: function(res) {
						
						/* session에 있는 id값이 null이면 카카오 로그인을 시도한다.*/
						if(id == '') {
							kakaoLogin(res)
						}
					}
				})
				//var token = authObj.access_token;
			},
			fail: function(err) {
				alert(JSON.stringify(err));
			},
		})
	}
	
	/* 
		카카오 로그인 
		카카오로그인은 사용하지 않기 때문에 ajax로그인 업데이트를 진행하지 않았음.
	*/
	function kakaoLogin(res) {
		
		formObj = $(".kakao");
		
		var kakaoId = res.id;
		var kakaoName = res.properties.nickname;
		authStatus = 'kakao';
		
		html = "<input type='hidden' name='g_name' value='"+kakaoName+"'>";
		html += "<input type='hidden' name='id' value='"+kakaoId+"'>";
		html += "<input type='hidden' name='authStatus' value='"+authStatus+"'>";
		
		formObj.html(html);
		formObj.submit();
	}
	
	kakaoInit();
	
	/*
		구글 로그인
		회원의 id, email, name을 기본정보로 제공받음.
	*/

	<!-- Google API -->

	/* 구글 초기화 함수. */
	function init() {
		console.log("google init");
		gapi.load('auth2', function() {
		    /* Ready. Make a call to gapi.auth2.init or some other API */
		    window.gauth = gapi.auth2.init({
		    	client_id: '940869694876-gflbqncmm64cb9h041j0a8ilepps113l.apps.googleusercontent.com'
		    })
		    gauth.then(function(){
		    	checkLoginStatus();
		    }, function(){
		    
		    });
		});
	}
	
	/* 구글 아이디가 로그인되어있는 상태인지 확인하는 함수 */
	function checkLoginStatus() {
		
    	if(gauth.isSignedIn.get()) {
  			var profile = gauth.currentUser.get().getBasicProfile();
  			
  			if(email == '') {
  				googleLogin(profile);
  			}
  			
		} else {
		
    	}
	}
	
	/* 구글 로그인 함수 */
	function googleLogin(profile) {
		
		formObj = $(".google");
		
		id = profile.getId();
		email = profile.getEmail();
		name = profile.getName();
		authStatus = 'google';
		
		$.ajax({
			url: "/biz/otherLogin.do",
			type: "post",
			data: "email=" + email + "&g_name=" + name + "&authStatus=" + authStatus,
			success: function(data) {
				
				if(data == 'success') {
					window.location.href="main.do";
				} else {
					alert("로그인 실패");
					gauth.signOut().then(function(){
					
                	});
                	email = '';
				}
			},
			error: function(error) {
				alert("에러 : " + error);
			}
		});
	}
	
	/* otherlogin API 끝*/
	
	/* 1009수정 최은서 */
	
	function getProjectMe(g_num) {
		console.log("g_num : " + g_num);
		$.ajax("/biz/getProjectMe.do", {
			type : "get",
			dataType : "json",
			data : { "g_num":  g_num },
			async: false,
			success : function(data){
				var dispHtml = $(".navMyGroup").html();
				
				$.each(data, function(){
					dispHtml += "<option value='groupLogin.do?c_num=" + this.c_num +"'>"+ this.c_name +"</option>"
				});
				
				$(".navMyGroup").html(dispHtml);
			}
		});
	}
	
	$(document).ready(function(){
	    /* 그룹 생성 팝업 */
	    $(".insertGroup").on("click", function(){
	        $(".insertGroupPop").show();
	        $(".darkBack").show();
	    });
	
	    /* 네비게이션 바 우측 상단 로그인 클릭 시 팝업 창 열림 처리 */
	    $(".login").on("click", function(){
	        $(".loginPopup").show();
	        $(".darkBack").show();
	    });
	
	    /* 팝업창 이외의 영역 클릭시 팝업창 닫힘 처리 */
		$(".darkBack").on("click", function(){
			$(".popup").hide();
			$(".darkBack").hide();
			$(".displayNone").hide();
		});
		
		/* controller에서 보낸 result 메세지를 변수에 저장 */
		
		checkMsg(result);
		function checkMsg(result) {
		
			/* 회원탈퇴 후 메인페이지 이동할 때 authstatus가 witndrawal이면 로그아웃 처리*/
			if(authstatus == 'withdrawal') {
				$("#logout").trigger("click");
			}
		
			if(result == '') {
				return;
			} 
			
			if(parseInt(result) == 1) {
				alert("회원가입이 정상적으로 완료되었습니다.");
			} else if(parseInt(result) == 2) {
				alert("가입 시 입력한 이메일로 인증메일을 보냈습니다.\n인증버튼을 누르면 회원가입이 완료됩니다.");
			} 
		}
		
		/* 아이디 찾기 클릭시 팝업창 */
		$(".findId").on("click", function(e){
			$(".loginPopup").hide();
			$(".findIdPwd").show();
			$(".findIdPopup").show();
		});
		
		/* 암호 찾기 클릭시 팝업창 */
		$(".findPwd").on("click", function(){
			$(".loginPopup").hide();
			$(".findIdPwd").show();
			$(".findPwdPopup").show();
		});
		
		/* 기본 로그인 */
		$(".loginBtn").on("click", function(e){
			
			e.preventDefault();
			
			formObj = $(".loginForm");
			
			email = $("#email").val();
			var password = $("#password").val();
			authstatus = $("input[name=authStatus]").val();
			
			$.ajax({
				url: "/biz/login.do",
				type: "post",
				data: "email=" + email + "&password=" + password + "&authStatus=" + authstatus,
				success: function(data) {
					
					if(parseInt(data) == 1) {
						window.location.href="main.do";
					} else {
						alert("로그인에 실패하였습니다.\n아이디와 비밀번호를 다시 입력해주세요.");
						$("#email").val('');
						$("#password").val('').focus();
						email = '';
						return;
					}
				},
				error: function(error) {
					alert("에러 : " + error);
				}
			});
		})
		/* 비밀번호 찾기(아이디체크) ajax */
		
		$(".chkId").on("click", function(e){

			e.preventDefault();
			var str = '';
			
			email = $("#findEmail").val();
			var g_name = $("#findName").val();
			
			$.ajax({
				url: "/biz/findPassword.do",
				type: "post",
				data: "email=" + email + "&g_name=" + g_name,
				success: function(data) {
					if(parseInt(data) == 1) {
						$(".findPwdPopup").hide();
						$(".findPwdPopup2").show();
					} else {
						alert("입력한 정보가 일치하지 않습니다.");
						$("#findId").val('');
						$("#findName").val('');
					}
				},
				error: function(error) {
					alert(error);
				}
			})
		});
		
		/* 비밀번호 찾기 후 새로운 비밀번호로 변경 */
		
		$(".updatePwd").on("click", function(e){
			
			e.preventDefault();
			
			pwd1 = $("#chkPwd").val();
			pwd2 = $("#chkPwd2").val();
			console.log("pwd1 : " + pwd1 + "pwd2 : " + pwd2);
			if(pwd1 === pwd2) {
			} else {
				alert("비밀번호가 일치하지 않습니다.\n다시 입력해 주세요.");
				pwd1.val('');
				pwd2.val('');
				return;
			}
			
			$.ajax({
				url: "/biz/updatePassword.do",
				type: "post",
				data: "email=" + email + "&password=" + pwd1,
				success: function(data) {
					
					if(parseInt(data) == 1) {
						alert("비밀번호가 변경되었습니다.");
						window.location.href="main.do";
					}
				},
				error: function(error) {
					alert(error);
				}
			});
		});
		
		/* 아이디 찾기 */
		
		$(".chkId2").on("click", function(e){
			
			e.preventDefault();
			findEmail2 = $("#findEmail2").val();
			findName2 = $("#findName2").val();
			console.log('findEmail2 : '+findEmail2);
			console.log('findName2 : '+findName2);
			
			$.ajax({
				url: "/biz/findId.do",
				type: "post",
				data: "g_name=" + findName2 + "&email=" + findEmail2,
				success: function(data) {
					console.log(data);
					if(data == '') {
						alert("일치하는 정보가 없습니다.");
					} else {
						alert("찾으시는 아이디는 " + data + " 입니다.");
					}
				},
				error: function(error) {
					alert(error);
				}
			});
		});
	});