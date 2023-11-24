package com.ssafy.planit.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class UserDto {

    private String userId;
    private String userPassword;
    private String userName;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirth;
    private String userGender;
    private Timestamp userJoinDate;
    private String refreshToken;

}
