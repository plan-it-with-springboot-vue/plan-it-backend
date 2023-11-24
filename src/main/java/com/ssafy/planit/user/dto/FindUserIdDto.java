package com.ssafy.planit.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FindUserIdDto {

    private String userEmail;
    private String userBirth;

}
