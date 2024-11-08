package com.toy.rtb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDTO {
    private String memberId;
    private String memberPwd;
    private String memberEmail;
    private String nickName;
}
