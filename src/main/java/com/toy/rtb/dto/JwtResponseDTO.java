package com.toy.rtb.dto;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
public class JwtResponseDTO {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
