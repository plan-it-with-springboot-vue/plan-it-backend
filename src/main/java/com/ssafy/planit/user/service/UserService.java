package com.ssafy.planit.user.service;

import com.ssafy.planit.user.dto.FindUserIdDto;
import com.ssafy.planit.user.dto.UserDto;

import java.sql.SQLException;
import java.util.Map;

public interface UserService {

    public UserDto login(UserDto userDto) throws Exception;
    public UserDto userInfo(String userId) throws Exception;
    public void saveRefreshToken(String userId, String refreshToken) throws Exception;
    public Object getRefreshToken(String userId) throws Exception;
    public void deleteRefreshToken(String userId) throws Exception;
    public void addUser(UserDto userDto) throws Exception;
    public String findUserId(FindUserIdDto findUserIdDto) throws Exception;
    public boolean checkDuplicateUserId(String userId) throws Exception;

}
