package com.toy.rtb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberSn;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPwd;

    // 권한 설정
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Set<String> roles;
}
