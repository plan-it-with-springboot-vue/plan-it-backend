package com.ssafy.planit.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserModifyDto {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
}
