package com.easyEat.handler;

import cn.hutool.jwt.JWTUtil;
import com.easyEat.common.CommonResult;
import com.easyEat.common.ResultEnum;
import com.easyEat.utils.SecurityHandlerUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lsilencej
 * @date ：Created in 2022/7/12 18:13
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        Map<String,Object> payload = new HashMap<>();
        payload.put("username",username);
        String token = JWTUtil.createToken(payload, "1234".getBytes(StandardCharsets.UTF_8));
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        SecurityHandlerUtil.responseHandler(response, CommonResult.success(ResultEnum.OK,map));
    }
}
