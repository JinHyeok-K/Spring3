package springtest3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest3.domain.dto.MemberDto;
import springtest3.domain.entity.MemberEntity;
import springtest3.domain.entity.MemberRepository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService { // 자바 로직이 실행되는 클래스

    @Autowired // 자동 빈 생성
    MemberRepository memberRepository;


    // 1. 생성
    public boolean create(MemberDto memberDto){
        System.out.println("save service");

        MemberEntity memberEntity = memberDto.changeEntity();
        int no = memberRepository.save(memberEntity).getNo();
     //   memberRepository.save(memberEntity);
        System.out.println();

        if(no>0){return true;}
        else{return false;}
    }
    // 2. 호출
    public List <MemberDto> read(){;
        System.out.println("read service");

        List<MemberEntity> entitys = memberRepository.findAll(); // 아무 조건 없는 모든 엔티티 호출

        // entity -> dto 변환
        List<MemberDto> dtos = new ArrayList<>(); // DTO 담는 리스트 선언

        for(MemberEntity entity : entitys) // 반복문

        {
            dtos.add(MemberDto.builder()
                    .no(entity.getNo())
                    .name(entity.getName())
                    .phone(entity.getPhone())
                    .memo(entity.getMemo())
                    .build());
        }
        return dtos;
        }


    // 3. 수정
    public void update(){
        System.out.println("update service");
    }
    // 4. 삭제
    public void delete(){
        System.out.println("delete service");
    }

}
