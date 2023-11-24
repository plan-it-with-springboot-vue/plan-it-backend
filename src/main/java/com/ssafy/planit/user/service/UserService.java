package com.ssafy.planit.user.service;

import com.ssafy.planit.user.dto.ChangePasswordDto;
import com.ssafy.planit.user.dto.FindUserIdDto;
import com.ssafy.planit.user.dto.UserDto;
import com.ssafy.planit.user.dto.UserModifyDto;

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
    public void deleteUserById(String userId) throws Exception;
    public  boolean verifyPassword(String userId, String userPassword) throws Exception;
    public void changePassword(ChangePasswordDto changePasswordDto) throws Exception;

    public void modifyUser(UserModifyDto userModifyDto) throws Exception;
}
