package com.ssafy.planit.user.service;

import com.ssafy.planit.user.dto.ChangePasswordDto;
import com.ssafy.planit.user.dto.FindUserIdDto;
import com.ssafy.planit.user.dto.UserDto;
import com.ssafy.planit.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @Override
    public UserDto login(UserDto userDto) throws Exception {
        return userMapper.login(userDto);
    }

    @Override
    public UserDto userInfo(String userId) throws Exception {
        return userMapper.userInfo(userId);
    }

    @Override
    public void saveRefreshToken(String userId, String refreshToken) throws Exception {
        Map<String, String> map = new HashMap<String, String >();
        map.put("userId", userId);
        map.put("token", refreshToken);
        userMapper.saveRefreshToken(map);
    }

    @Override
    public Object getRefreshToken(String userId) throws Exception {
        return userMapper.getRefreshToken(userId);
    }

    @Override
    public void deleteRefreshToken(String userId) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("token", null);
        userMapper.deleteRefreshToken(map);
    }

    @Override
    public void addUser(UserDto userDto) throws Exception {
        userMapper.addUser(userDto);
    }

    @Override
    public String findUserId(FindUserIdDto findUserIdDto) throws Exception {
        return userMapper.findUserId(findUserIdDto);
    }

    @Override
    public boolean checkDuplicateUserId(String userId) throws Exception {
        int count = userMapper.checkDuplicateUserId(userId);
        return count>0;
    }

    @Override
    public void deleteUserById(String userId) throws Exception {
        userMapper.deleteUserById(userId);
    }

    @Override
    public boolean verifyPassword(String userId, String userPassword) throws Exception {
        UserDto userDto = userMapper.userInfo(userId);
        return userDto != null && userDto.getUserPassword().equals(userPassword);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) throws Exception {
        userMapper.updatePassword(changePasswordDto.getUserId(), changePasswordDto.getNewPassword());
    }


}
