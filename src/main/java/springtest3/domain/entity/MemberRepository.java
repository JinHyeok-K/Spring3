package springtest3.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<MemberEntity, Integer> {
                                                        ///// 여기 dto에서 entity로 변경함
}
