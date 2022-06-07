package springtest3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트 초기 셋팅 : 1. 내장 톰캣 셋팅, 2 MVC 셋팅 3. Restful 셋팅
public class AppStart {

    public static void main(String[] args) {
        //스프링(api) > 스프링부트(:웹관련| (api(api))
        SpringApplication.run(AppStart.class);
    }
}

/*
*       프로젝트 폴더
*           src
*               main
*                   1. java [백 엔드 파일]
*                       2. 최상위 패키지[웹 사이트명]
*                           3. controller 패키지
*                           3. service 패키지
*                           3. domain 패키지
*                           3. 스프링 실행 클래스 [*] : AppStart.class (현 프로젝트 기준)
*                   1. resources [ 프론트 엔드 / 설정 파일 ]
*                       2. static [ CSS, JS, Img 등등 파일 ]
*                           3. js
*                           3. css
*                           3. img
*                       2. templates [ HTML 파일]
*                       2. application.properties [ 앱 설정 파일 ]
* */


/*
            설계 디자인 모델
               - MVC2 [JPA] : 작업파일 패키지 업무 분담
                    * 안정성 보장 [ VIEW -> CONTROLLER [변수, DTO, VO(수정 불가 객체) ] // CONTROLLER -> SERVICE [PARAM,DTO,VO]
                        // DTO : 데이터 이동 객체 (/이동/읽기/쓰기 모드)[ Controll -> Service ]
                        // VO : 데이터 이동 객체 (/이동/읽기모드)
                        // entity : DB 테이블과 맵핑된 객체 ( Service 에서만 사용 권장 )

            MVC2 [JPA]  
            
            
                  [FRONT-END]          | [                                   BACK-END                             ]
              VIEW ------- AJAX DTO--------> CONTROLL --------- DTO ---------> SERVICE ------  JPA(or DAO) --------> DB
              화면                         제어( view<-->service)                로직           엔티티 ---- 맵핑 ---->  table
                                                                                                      Entity 조작(CRUD ; Entity 조작) : JPARepository (DAO : prepared statement)
              -통신 방식 : AJAX                                                                         DTO ---> Entity 형 변환
                -URL :ex) create        @[Method]GetMapping(url)
                -Method :ex) get-------------↗
                                          SERVICE 호출                       기능 구현 로직

            JDBC : JAVA DATABASE CONNECTION 종류    (연동 방식)
               // 1. DAO [ JAVAFX, JSP ]
               // 2. JPA [ SPRING ]
               // 3. XML ( Mapper )

                * JPA : 맵핑 [ 연결 ]
                    // 목적 : SQL 최소화 [ 자바 개발자가 SQL 반복 작성 회피 ]  | JAVA -> Method 화
                    // 맵핑 : ENTITY( JAVA 클래스 ) --------- DB 테이블

            @RequestParam("요청 변수명") 자료형 변수명 < ------- >  request.getParameter   같은 기능

            // 1. 변수 요청 어노테이션
            // 2. 자동 형 변환

 */









