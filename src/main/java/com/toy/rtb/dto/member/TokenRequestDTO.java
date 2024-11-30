package com.toy.rtb.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRequestDTO {
    private String memberId;
    private String memberPwd;
}
