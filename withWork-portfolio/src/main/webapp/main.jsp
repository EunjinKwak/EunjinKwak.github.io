<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="include/mainHead.jsp" %>
    
    <!-- css -->
    <link rel="stylesheet" href="css/fullpage.css">
    <link rel="stylesheet" href="css/swiper.css">
    <link rel="stylesheet" href="css/animate.min.css">
    
    <!-- js -->
    <script src="js/fullpage.js"></script>
    <script src="js/swiper.min.js"></script>
    <script src="js/swiper.animate1.0.3.min.js"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
    <script src="js/nav.js"></script>
</head>
<body>
   <%@ include file="include/nav.jsp" %>
   <div id="fullpage">
      <div class="section active" id="section0">
          <div class="mainRolling">
              <div class="swiper-container">
                  <div class="swiper-wrapper">
                      <div class="swiper-slide">
                          <dl class="swiperText">
                              <dt>
                                  <p class="tit">쉽고 간단한 협업,<br>저희가 책임집니다.</p>
                                  <p class="txt">지금 바로  WithWork를 시작하세요!</p>
                              </dt>
                              <dd><a href="#">자세히 보기</a></dd>
                          </dl>
                      </div>
                      <div class="swiper-slide">
                          <dl class="swiperText">
                              <dt>
                                  <p class="tit">효과적인 팀워크,<br>가벼워진 업무</p>
                                  <p class="txt">WithWork를 체험해보세요!</p>
                              </dt>
                              <dd><a href="#">자세히 보기</a></dd>
                          </dl>
                      </div>
                  </div>
                  <div class="swiper-pagination_main">
                  </div>
              </div>
          </div>
      </div>
       <div class="section" id="section1">
          <ul>
             <li>
                <div class="mainGroupWrap">
                   <div class="txt">
                      <img src="img/groupCreateIcon.png" alt="">
                      <p>그룹 생성</p>
                      <span>여러분의 사업에 꼭 필요한<br>그룹을 생성해보세요.</span>
                      <c:choose>
                         <c:when test="${empty guest.email}">
                            <a href='#' class="login">로그인 후 이용가능</a>
                         </c:when>
                         <c:otherwise>
                            <a href="insertGroup.do">자세히 보기</a>
                         </c:otherwise>
                      </c:choose>
                   </div>
                </div>
             </li>
             <li>
                <div class="mainGroupWrap">
                      <div class="txt">
                      <img src="img/groupSearchIcon.png" alt="">
                      <p>그룹 검색</p>
                      <span>관심있는 주제로<br>그룹을 찾아보세요.</span>
                      <a href="searchGroup.do">자세히 보기</a>
                   </div>
                </div>
             </li>
          </ul>
       </div>
    </div>
    <script>
   $(document).ready(function(){
      /* swiper */
       var slides = $('.swiper-slide');
       var mySwiper = new Swiper('.swiper-container', {
           spaceBetween: 0,
           centeredSlides: true,
           pagination: {
               el: '.swiper-pagination_main',
               clickable: true,
           },
           on: {
               init: function(){
                   swiperAnimateCache(this);
                   swiperAnimate(this);
                   $(".swiper-slide-prev, .swiper-slide-next").removeClass("animate");
                   $(".swiper-slide-active").addClass("animate");
               },
               slideChangeTransitionEnd: function(){ 
               swiperAnimate(this);
               $(".swiper-slide-prev, .swiper-slide-next").removeClass("animate");
               $(".swiper-slide-active").addClass("animate");
               }
           } 
       }); 
       
       /* one page scroll */
        var myFullpage = new fullpage('#fullpage', {
           lazyLoad: true,
         onLeave: function(origin, destination, direction){
            var params = { destination:destination };
            if ( params["destination"]["index"] > 0 ){
               $("nav").addClass("fix");
            } else {
               $("nav").removeClass("fix");
            }
         }
       });
       
   });
   
   /* 그룹생성 회원 비회원 구분 */
   var email = '<c:out value="${guest.email}"/>';
   
   $(".login").on("click", function(){
        $(".loginPopup").show();
        $(".darkBack").show();
    });
    </script>
</body>

</html>