
function selectOneDate(){
   $.ajax("getPopupConfirm.do", {
      type: "get",
      dataType:"json",
      success: function(data) {
         $.each(data, function(){
            $(".todoTit").val(this.title);
	         });
	      },  error : function(request, error){
         alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
      }
   });
}

function confirmDetail(t_num){
	$.ajax("selectConfirm.do", {
		type: "get",
		dataType:"json",
		data: {"t_num" : t_num},
		success: function(data) {
			console.log(data);
			$(".confirmTitle").val(data.title);
			$(".confirmFeedBack").val(data.feedback);
			$(".t_num").val(t_num);
			
			var radioValue = data.state;
			console.log(radioValue);
			
			if(radioValue == '대기') {
				$(".confirmState1").prop('checked',true);
			} else if(radioValue =='보류'){
				$(".confirmState1").prop('checked',true);
			} else if(radioValue =='완료') {
				$(".confirmState2").prop('checked', true);
				}
			
			$(".penPopup").show();
			$(".darkBack").show();
		},
	   error:function(request,status,error){
	    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	   }
	});	
}

function confirmFeedback(t_num) {
		$.ajax("selectConfirm.do", {
		type: "get",
		dataType:"json",
		data: {"t_num" : t_num},
		success : function(data) {
			console.log(data);
			$(".feedbackText").val(data.feedback);
			$(".t_num").val(data.t_num);
			
			var feedValue = data.feedback;
			console.log(feedValue);
			
			$(".confirmPopup").show();
			$(".darkBack").show();
		},
	   error:function(request,status,error){
	    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	   
		}
	});
}


function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
	
$(document).ready(function() {
	$(".header li").removeClass("active");
	$(".allInfo li").eq(1).addClass("active");

	var patId = getParameterByName('page');
	
	$(".paging li").each(function(){
		var idx = $(this).find("a").text();
		if(idx == patId) {
			$(this).addClass("active");
		}
	});

	selectOneDate();
	
    /*$(".confirmTabMenu .tab_content").hide();
    $(".confirmTabMenu .tabs li:first").addClass("active").show();
    $(".confirmTabMenu #tab1").show();

    $(".confirmTabMenu .tabs li").click(function(){
        $(".confirmTabMenu .tabs li").removeClass("active");
        $(this).addClass("active");
		$(".confirmTabMenu .tab_content").hide();

        var activeTap = $(this).find('a').attr('href');
        $(activeTap).fadeIn();
        console.log('activeTap : ' + activeTap);
        return false;
    }); */

    
    $("#mess").click(function(){
        $(".confirmPopup").show();
        $(".darkBack").show();
    });

    $(".confirmTabMenu .tabs li:first").on('click',function(){
        $(this).addClass("active").show();
        $("#tab1").show();
    });
    
    
  	 $("input:radio[name=state]").click(function(){
 
        if($("input[name=state]:checked").val() == '대기'){
            $("input:text[name=feedback]").attr("readonly",false);
 
        }	else { //완료, 대기일 경우 피드백을 적을 수 없다
              $("input:text[name=feedback]").attr("readonly",true);
            
        } 
    });

	
  
});

