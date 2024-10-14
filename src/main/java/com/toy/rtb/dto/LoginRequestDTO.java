package com.toy.rtb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    private String memberId;
    private String memberPwd;
}
