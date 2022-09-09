package com.easyEat.handler;

import com.easyEat.common.CommonResult;
import com.easyEat.utils.SecurityHandlerUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：lsilencej
 * @date ：Created in 2022/7/12 20:33
 * @description：
 * @modified By：
 * @version: $
 */
public class LoginFailHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        SecurityHandlerUtil.responseHandler(response, CommonResult.custom(1001, "账号或密码错误"));
    }
}
