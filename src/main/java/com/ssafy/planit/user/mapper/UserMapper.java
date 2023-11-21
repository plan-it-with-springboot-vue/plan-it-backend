package com.ssafy.planit.user.mapper;

import com.ssafy.planit.user.dto.UserDto;
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
}
