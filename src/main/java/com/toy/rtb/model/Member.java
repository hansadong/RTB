package com.toy.rtb.model;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
}
