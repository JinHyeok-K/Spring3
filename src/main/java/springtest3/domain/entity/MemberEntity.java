package springtest3.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MemberEntity {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto key
    public Integer no;

    @Column
    public String name;
    @Column
    public String phone;
    @Column
    public String memo;


}
