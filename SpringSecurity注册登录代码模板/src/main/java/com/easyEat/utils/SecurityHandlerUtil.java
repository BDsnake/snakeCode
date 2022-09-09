package com.easyEat.utils;

import com.alibaba.fastjson2.JSON;
import com.easyEat.common.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：lsilencej
 * @date ：Created in 2022/7/12 20:18
 * @description：
 * @modified By：
 * @version: $
 */
public class SecurityHandlerUtil {

    /**
     *
     * @param response 响应
     * @param result 返回 JSON
     * @throws IOException
     */
    public static void responseHandler(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(JSON.toJSONString(result));
        pw.flush();
        pw.close();
    }

}
