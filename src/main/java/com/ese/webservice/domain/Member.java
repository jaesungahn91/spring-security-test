package com.ese.webservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = "memail")
public class Member {

    @Id
    @GeneratedValue
    //private Long id;
    private Long mseq;

    @Column(nullable = false, unique = true, length = 50)
    //private String uemail;
    private String memail;

    @Column(nullable = false, length = 50)
    //private String uid;
    private String mname;

    @Column(nullable = false, length = 200)
    //private String upw;
    private String mpwd;

    @CreationTimestamp
    private Date regdate;

    @UpdateTimestamp
    private Date updatedate;

    // cascade 경우 엔티티들의 영속관계를 한번에 처리하지 못하기 때문에 이에 대한 cascade 설정 추가
    // member와 member_role 둘다 동시 조회하기위해 fetch 설정을 즉시 로딩으로 EAGER 설정 해줘야함.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "mseq")
    private List<MemberRole> roles;

}
