package springtest3.domain.dto;


import lombok.*;
import springtest3.domain.entity.MemberEntity;

@Getter // Get 메소드 제공
@Setter // Set 메소드 제공
@AllArgsConstructor // 풀 생성자 제공
@NoArgsConstructor // 빈 생성자
@ToString // Tostring 메소드 제공
@Builder // 객체 생성 시 안전성 보장 builder 메소드 제공
public class MemberDto {

    public Integer no;

    public String name;

    public String phone;

    public String memo;

    //설계 관련 API : 롬복 : 생성자 , get, set, 빌더, tostring() 등 어노테이션 제공

    // 1. DTO -> Entity 변환 메소드
    public MemberEntity changeEntity(){

         MemberEntity memberEntity = MemberEntity.builder()
                .name(this.name)
                .phone(this.phone)
                .memo(this.memo)
                .build();
        return memberEntity;
    }
}
