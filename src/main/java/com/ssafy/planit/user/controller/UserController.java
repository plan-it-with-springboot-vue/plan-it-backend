package com.ssafy.planit.user.controller;

import com.ssafy.planit.user.dto.ChangePasswordDto;
import com.ssafy.planit.user.dto.EmailCheckDto;
import com.ssafy.planit.user.dto.FindUserIdDto;
import com.ssafy.planit.user.dto.UserDto;
import com.ssafy.planit.user.service.EmailService;
import com.ssafy.planit.user.service.UserService;
import com.ssafy.planit.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final EmailService emailService;

    public UserController(UserService userService, JWTUtil jwtUtil, EmailService emailService) {
        super();
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.emailService=emailService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto) {
        log.debug("login user : {}", userDto);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            UserDto loginUser = userService.login(userDto);
            if(loginUser != null) {
                String accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
                String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
                log.debug("access token : {}", accessToken);
                log.debug("refresh token : {}", refreshToken);

                userService.saveRefreshToken(loginUser.getUserId(), refreshToken);

                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);

                status = HttpStatus.CREATED;
            } else {
                resultMap.put("message", "아이디 또는 패스워드를 확인해주세요.");
                status = HttpStatus.UNAUTHORIZED;
            }

        } catch (Exception e) {
            log.debug("로그인 에러 발생 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<Map<String, Object>> getInfo(@PathVariable String userId, HttpServletRequest request) {
//		logger.debug("userId : {} ", userId);
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        if (jwtUtil.checkToken(request.getHeader("Authorization"))) {
            log.info("사용 가능한 토큰!!!");
            try {
//				로그인 사용자 정보.
                UserDto userDto = userService.userInfo(userId);
                resultMap.put("userInfo", userDto);
                status = HttpStatus.OK;
            } catch (Exception e) {
                log.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            System.out.println(request);
            log.error("사용 불가능 토큰!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/logout/{userId}")
    public ResponseEntity<?> removeToken(@PathVariable ("userId") String userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            userService.deleteRefreshToken(userId);
            System.out.println("로그아웃성공");
            status = HttpStatus.OK;
        } catch (Exception e) {
            log.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);

    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request)
            throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String token = request.getHeader("refreshToken");
        log.debug("token : {}, userDto : {}", token, userDto);
        if (jwtUtil.checkToken(token)) {
            if (token.equals(userService.getRefreshToken(userDto.getUserId()))) {
                String accessToken = jwtUtil.createAccessToken(userDto.getUserId());
                log.debug("token : {}", accessToken);
                log.debug("정상적으로 액세스토큰 재발급!!!");
                resultMap.put("access-token", accessToken);
                status = HttpStatus.CREATED;
            }
        } else {
            log.debug("리프레쉬토큰도 사용불가!!!!!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/join")
    public ResponseEntity<String> signUpUser(@RequestBody UserDto userDto) {
        try {
            System.out.println(userDto);
            userService.addUser(userDto);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findUserId")
    public String findUserId(@RequestBody FindUserIdDto findUserIdDto) throws Exception {
        return userService.findUserId(findUserIdDto);
    }

    @GetMapping("/checkDuplicate/{userId}")
    public boolean checkDuplicateUserId(@PathVariable String userId) throws Exception {
        return userService.checkDuplicateUserId(userId);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) throws Exception {
        try {
            userService.deleteUserById(userId);
            return new ResponseEntity<>("User delete successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to delete user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @PostMapping("/emailSend")
    public ResponseEntity<String> EmailCheck(@RequestBody EmailCheckDto emailCheckReq) throws MessagingException, UnsupportedEncodingException {
        try {
            String authCode = emailService.sendEmail(emailCheckReq.getEmail());
            return new ResponseEntity<>("Email success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Email Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/emailAuthCheck")
    public ResponseEntity<String> AuthCheck(@RequestBody EmailCheckDto emailCheckReq){
        boolean Checked=emailService.checkAuthNum(emailCheckReq.getEmail(),emailCheckReq.getAuthNum());
        if(Checked){
            return new ResponseEntity<>("Auth code check success", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("failed auth check", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDto changePasswordDto) throws Exception {
        if (userService.verifyPassword(changePasswordDto.getUserId(), changePasswordDto.getCurrentPassword())) {
            userService.changePassword(changePasswordDto);
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to change password. Verify current password.");
        }
    }
}
