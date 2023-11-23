package com.ssafy.planit.user.mapper;

import com.ssafy.planit.user.dto.ChangePasswordDto;
import com.ssafy.planit.user.dto.FindUserIdDto;
import com.ssafy.planit.user.dto.UserDto;
import com.ssafy.planit.user.dto.UserModifyDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.Map;

@Mapper
public interface UserMapper {
    public UserDto login(UserDto userDto) throws SQLException;
    public UserDto userInfo(String userId) throws SQLException;
    public void saveRefreshToken(Map<String, String> map) throws SQLException;
    public Object getRefreshToken(String userId) throws SQLException;
    public void deleteRefreshToken(Map<String, String> map) throws SQLException;
    public void addUser(UserDto userDto) throws SQLException;
    public String findUserId(FindUserIdDto findUserIdDto) throws SQLException;
    public int checkDuplicateUserId(String userId) throws SQLException;
    public void deleteUserById(String userId) throws SQLException;
    public void updatePassword(String userId, String newPassword) throws SQLException;
    public void modifyUserAll(UserModifyDto userModifyDto) throws SQLException;
    public void modifyUserPhoneNumber(UserModifyDto userModifyDto) throws SQLException;
}
