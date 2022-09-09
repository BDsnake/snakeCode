package com.easyEat.handler;

import com.easyEat.common.CommonResult;
import com.easyEat.utils.SecurityHandlerUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author     ：lsilencej
 * @date       ：Created in 2022/7/12 20:47
 * @description：
 * @modified By：
 * @version:     $
 */
public class LoginEntryHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        SecurityHandlerUtil.responseHandler(response, CommonResult.custom(1003, "用户未登录"));
    }
}
