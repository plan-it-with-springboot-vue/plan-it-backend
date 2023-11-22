package com.ssafy.planit.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePasswordDto {

    private String userId;
    private String currentPassword;
    private String newPassword;

}
