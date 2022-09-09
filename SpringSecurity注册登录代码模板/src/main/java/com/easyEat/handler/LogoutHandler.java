package com.easyEat.handler;

import com.easyEat.common.CommonResult;
import com.easyEat.utils.SecurityHandlerUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：lsilencej
 * @date ：Created in 2022/7/12 20:45
 * @description：
 * @modified By：
 * @version: $
 */
public class LogoutHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        SecurityHandlerUtil.responseHandler(response, CommonResult.custom(1002, "注销成功"));
    }
}
