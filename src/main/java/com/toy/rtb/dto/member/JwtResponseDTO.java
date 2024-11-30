package com.toy.rtb.dto.member;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
public class JwtResponseDTO {
    private String accessToken;
}
