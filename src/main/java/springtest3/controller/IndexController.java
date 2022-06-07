package springtest3.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springtest3.domain.dto.MemberDto;
import springtest3.service.IndexService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {

    // RestFul 정의의
        // 1. 자원(URL)
        // 2. 행위(Http Method)
            //
            // 2. 행위 (HTTP Method)       CRUD    차이 [ 멱등성 = 기록 O/X ]
                // 1. @PostMapping          C       X [보안 O 속도 느림]          등록 (ex:회원가입 / 로그인)
                // 2. @GetMapping           R       O
                // 3. @PutMapping           U       O
                // 4. @DeleteMapping        D       O

                // * 여러번 호출 시 POST는  호출 할 때마다 데이터 새롭게게 생성
                // *  Ajax ----->  Spring Controller
                //    Ajax  Method : POST -----> @PostMapping
                //    Ajax  Method : GET -----> @GetMapping
                //    Ajax  Method : PUT -----> @PutMapping
                //    Ajax  Method : DELETE -----> @DeleteMapping


        // 3. 표현(식)


    @GetMapping("/")
    public String index() {
        return "main";
    }

    //static IndexService indexService = new IndexService();
    @Autowired // 자동 빈(bean) 생성 = 빈(bean) 생성자 이용한 메모리 할당 // new 사용하지 않아도 메모리 할당
    IndexService indexService;

    @PostMapping("/create")
    @ResponseBody
    public boolean create( @RequestParam("name") String name,
                          @RequestParam("phone") String phone,
                          @RequestParam("memo") String memo
                          ) {
        //public String create(HttpServletRequest request){
             //request.getParameter("name");
             // Integer.parseInt(request.getParameter("name"));  --> @RequestParam

        // 1. DTO 생성
        MemberDto memberDto = new MemberDto(0,name,phone,memo);

        // 2. DTO 빈 생성자 사용
        MemberDto memberDto2 = new MemberDto();
            memberDto2.setNo(0);
            memberDto2.setName(name);
            memberDto2.setPhone(phone);
            memberDto2.setMemo(memo);

        // 3. builder 사용시 객체명 =Dto명.builder().필드명1(값1).필드명2(값2).필드명3(값3).build();
        MemberDto memberDto3 = MemberDto.builder()
                // No 삭제 상태
                .name(name)
                .phone(phone)
                .memo(memo)
                .build();
        // 생성자 vs 빌더 차이점 [ 빌더 : 안정성 보장  = > 객체 생성시 (생성자) 보장 ]
//                            생성자                                           빌더
            // 1. 생성자 인수 순서를 무조건 지켜야 한다.            |       순서 상관 없음
            // 2. 생성자 인수 개수를 무조건 맞춘다.                |        인수 갯수  상관 없음
        System.out.println();


        boolean result  = indexService.create(memberDto3);
        return result;
    }
    @GetMapping("/read")
    @ResponseBody
    public void read(HttpServletResponse response){
        List<MemberDto>   dtos = indexService.read();

        JSONArray JsonArray = new JSONArray(); // Json 형 변환
        for(MemberDto dto : dtos){
            JSONObject object = new JSONObject();
            object.put("no",dto.getNo());
            object.put("name",dto.getName());
            object.put("phone",dto.getPhone());
            object.put("memo",dto.getMemo());

            JsonArray.put(object);
        }
        try {
            System.out.println(JsonArray.toString());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(JsonArray);
        }catch(Exception e){System.out.println("e");}

    }

    @PutMapping("/update")
    @ResponseBody
    public String update(){
        indexService.update();
        return "수정 성공";
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(){
        indexService.delete();
        return "삭제 성공";
    }
}
