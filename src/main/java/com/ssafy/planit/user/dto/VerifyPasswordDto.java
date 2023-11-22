package com.ssafy.planit.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VerifyPasswordDto {
    private String userId;
    private String userPassword;
}
