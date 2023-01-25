# Petwogether👩‍💻


## Summary
-  반려동물을 키우는 사람들, 혹은 키우려는 사람들과 펫 시터들에게 반려동물 돌봄 서비스 플랫폼을 제공하는 사이트입니다.
-  반려동물 관련 커뮤니티 기능과 유기동물 입양 가능한 플랫폼을 제공합니다.


&nbsp;
&nbsp;

### ✨프로젝트 목적
1.  갑작스럽게 반려동물을 누군가에게 맡겨야 하는 경우가 발생할 때 이용할 수 있는 플랫폼 제공
2.  유기동물 입양과 입양 이후의 이야기를 남기고 소통할 수 있는 플랫폼 제공

&nbsp;
&nbsp;

### ✨ERD
![git_erd](https://user-images.githubusercontent.com/111338981/214502487-8901dccb-1529-423f-849f-2c222179ddae.png)


&nbsp;
&nbsp;

### ✨주요기능
☑️ 회원가입

☑️ 로그인

☑️ 돌봄 서비스 신청하기

☑️ 돌봄 서비스 후기

☑️ 유기동물 입양하기

☑️ 유기동물 입양 후기

☑️ 펫시터 신청하기

☑️ QnA / 의료정보 게시판


&nbsp;
&nbsp;

### ✨ 사용 기술
| 기술분야 | 상세내용 |
| ------ | ------ |
| Front-end | HTML5, CSS, JavaScript, JQuery, Tiles, Thymeleaf |
| Back-end | JAVA, Spring, SpringBoot, MyBatis, Insomnia, REST JSON, JDBC |
| Server | Apache Tomcat |
| DB | Oracle, SQL |

&nbsp;
 &nbsp;     

### ✨ 담당 업무
     1. 돌봄 서비스 신청하기 클릭 시 펫 시터 목록 출력 및 선택
     2. 펫시터 선택 이후 서비스 이용 시작 날짜/종료 날짜, 서비스 종류, 맡길 반려동물 선택
     3. 서비스 신청하기 버튼 클릭 시 신청 완료
     4. 입양후기 게시판 CRUD
     
&nbsp;
&nbsp;
&nbsp;
     
     


 ### ✨주요 구현 화면
 &nbsp;
 &nbsp;  
#### ✅ _입양후기 게시판 (게시판 목록)_
![입양후기 게시판](https://user-images.githubusercontent.com/111338981/214503876-c8113768-3f36-4d3a-a503-376beab57b5a.png)

&nbsp;
&nbsp;
- __내용__
 

    입양 후기 게시판입니다.
    홈페이지 회원들이 자유롭게 입양 후기를 남길 수 있는 게시판입니다.




- __기술__
     ###### Spring Boot, MyBatis, JDBC, jQuery, Tiles, Thymeleaf, Ajax, REST
    Spring Boot를 이용하여 게시판을 구현하였습니다.
    게시판 목록 데이터를 가져올 때, REST 방식을 이용하여 데이터를 가져왔습니다.
    이때, Insomnia를 활용하여 데이터를 제대로 가져오는지 확인하였습니다. 
    REST로 가져온 데이터를 바로 화면에 연결해주기 위해 ModelAndView 객체로 메소드를 생성했으며,
    검색 결과를 가져올 때는, Ajax를 활용하여 화면에 가져온 데이터를 출력해주었습니다.



&nbsp;
&nbsp;
&nbsp;    
#### ✅ _입양후기 게시판 (게시글 작성하기)_
![입양후기 게시판 작성하기](https://user-images.githubusercontent.com/111338981/214503998-a48d8fb8-ab38-4b57-a16b-12391c5c92d4.png)



&nbsp;
&nbsp;
- __내용__
 

    입양 후기 게시판의 작성하기 화면입니다.
    제목, 내용, 파일을 추가하고 작성하기를 클릭하면 게시판에 게시물을 등록할 수 있습니다.






- __기술__
     ###### Spring Boot, MyBatis, JDBC, jQuery, JSTL, EL, Tiles, Thymeleaf

    이전에 JSP, Servlet을 활용한 게시판은 조금 익숙했지만, Spring Boot과 MyBatis를 활용한
    게시판을 만들면서, MyBatis와 Spring Boot를 사용하여 Database에 접근하고, CRUD 중 CREATE
    하는 방법에 대해 보다 확실하게 정리할 수 있었습니다.




&nbsp;
&nbsp;
&nbsp;    
#### ✅ _입양후기 게시판 (게시글 조회 / 삭제하기)_
![입양후기 게시판 조회하기](https://user-images.githubusercontent.com/111338981/214504030-faa3854c-4650-41ff-94d9-796e4d283053.png)



&nbsp;
&nbsp;
- __내용__
 

    입양 후기 게시판의 게시물 조회 화면입니다.
    작성자가 등록한 사진, 제목, 내용과 작성자, 작성날짜, 조회수를 출력합니다.
    본인이 작성하지 않은 게시물의 경우 하단에 돌아가기만 가능하며, 본인 작성 게시물의 경우 
    수정/삭제가 가능합니다.






- __기술__
     ###### Spring Boot, MyBatis, JDBC, jQuery, Tiles, Thymeleaf

    MyBatis와 Spring Boot를 사용하여 Database에 접근하고, CRUD 중 READ와 DELETE에 대해 
    보다 확실하게 정리할 수 있었습니다.
    또한, thymeleaf를 활용하여 데이터를 View에서 출력하는 방법과  session값을 활용하는 방법에
    대해서도 정리할 수 있는 기능이었습니다.




&nbsp;
&nbsp;
&nbsp; 
#### ✅ _입양후기 게시판 (게시글 수정하기)_
![일정요약페이지](https://user-images.githubusercontent.com/111338981/214493213-0df7ccb0-0964-4307-aa5d-4cd823009303.png)



&nbsp;
&nbsp;
- __내용__
 

    입양 후기 게시판의 게시물 수정 화면입니다.
    작성자가 작성했던 제목, 내용을 자동으로 입력된 상태로 보여줍니다.






- __기술__
     ###### Spring Boot, MyBatis, JDBC, jQuery, Tiles, Thymeleaf

    MyBatis와 Spring Boot를 사용하여 Database에 접근하고, CRUD 중 Update에 대해 
    보다 확실하게 정리할 수 있었습니다.




&nbsp;
&nbsp;
&nbsp;    


 ### ✨프로젝트를 통해
 
 ### ✅ 최종 파이널 프로젝트

 
JSP, Servlet을 활용한 프로젝트를 진행한 이후에 Spring Framework와 Spring Boot를 배우면서, 이전보다 훨씬 간편한 방식으로 Model, View, Controller를 활용할 수 있다는 점이 매우 편리하게 느껴졌습니다. 

의존성 주입의 대상에 대해 이론으로는 다소 어렵게 느껴졌던 부분이 프로젝트를 진행하면서 보다 명확하게 이해가 되었습니다. 또한, include 방식을 통해서 조각 페이지 관리를 했던 것과 다르게 Tiles를 사용하여 layout을 미리 설정하고 내부 html 코드만 수정하는 방식이 매우 편리했습니다.

MyBatis를 활용하여 이전보다 쿼리 코드를 효율적으로 관리할 수 있었으며, MyBatis를 사용할 때 binding 방식을 #과 $을 각각의 데이터 형태에 따라 사용하는 방법에 대해서도 확실하게 정리할 수 있었습니다.

돌봄 서비스 신청 페이지를 만드는데 있어서, 한 페이지에 여러 기능들 각각의 데이터를 원하는 형태로 Controller로 넘겨주는 방법에 대해서 많이 고민할 수 있었으며, 지난 JSP, Servlet 프로젝트에 이어서 원하는 데이터를 어떻게 얻어야 하는지 명확하게 알게 되었습니다. 

REST를 활용하여 데이터를 가져와 화면에 출력하고, 검색시에 Ajax를 활용하여 목록을 비동기 방식으로 업데이트 하면서 REST 방식에 대해 많이 공부할 수 있었고, 다양한 API들이 REST 방식으로 제공되는 것을 알게 되면서 REST 방식의 Open API를 더 많이 활용해보고 싶단 생각을 하게 되었습니다.

마지막 프로젝트를 진행하면서, 프로젝트 셋팅을 Spring과 Spring Boot에 각각 해주어야 하는 상황에서 Spring Boot 프로젝트 생성 및 셋팅을 완성하여 팀원들에게 배포하였습니다.

맡은 기능이 다른 팀원과 공유되는 부분이 있을 때는 적극적으로 소통을 시도하여, 작업 효율을 높일 수 있었습니다.

팀 프로젝트는 누군가 혼자 하는 것이 아닌 서로 일을 적절하게 분배하여 진행할 때, 효율이 많이 늘어난다는 것을 다시 한번 느낄 수 있는 프로젝트였습니다.









&nbsp;
&nbsp;
---
&nbsp;
&nbsp;
###### _프로젝트 기간_
- 2023.01.12 ~ 2023.01.30


###### _프로젝트 참여인원_
- 6명


