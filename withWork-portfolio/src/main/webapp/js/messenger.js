$().ready(function(){
    
    // 팝업열기
    $(".chatBtn a").click(function(){
        $(".msgPopup").toggleClass("show");
        $(".msgPopupAll > div").hide();
        $(".msgPopupAll > div").eq(0).show();
    });

    // 팝업닫기
    $(".popupOK").click(function(){
        $(".popupM").removeClass("show");
    });
    
    //채팅 멤버/대화방 탭
    $(".msgPopupC li").click(function(){
        var idx = $(this).index(); // --> 0
        $(".msgPopupAll > div").hide();
        $(".msgPopupAll > div").eq(idx).show();
    });
    
    // 첫 팝업창에서 멤버 탭 default
    $(".msgPopupC li").click(function(){
        $(this).addClass("active").show();
        $(".chatMenu1").show();
    });
    
    //프로필 창 열기
    $(".profileImg").click(function(){
        $(".chatProfile").show();
        $(".darkBack").show();
    });
    
    //프로필 창 닫기
    $(".popupOK1").click(function(){
        $(".chatProfile").hide();
        $(".msgPopup").show();
        $(".darkBack").hide();
    });
    
    $(".darkBack").click(function(){
        $(".chatProfile").hide();
        $(".msgPopup").show();
        $(".darkBack").hide();
    });
    
});