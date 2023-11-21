package com.ssafy.planit.user.service;

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
}
