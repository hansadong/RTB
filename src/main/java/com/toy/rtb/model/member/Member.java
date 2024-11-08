package com.toy.rtb.model.member;

import com.toy.rtb.model.common.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberSn;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPwd;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String nickName;

    // 권한 설정
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<String> roles;
}
