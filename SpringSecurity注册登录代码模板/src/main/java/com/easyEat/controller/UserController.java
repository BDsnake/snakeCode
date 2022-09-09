package com.easyEat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easyEat.common.CommonResult;
import com.easyEat.common.Result;
import com.easyEat.common.ResultEnum;
import com.easyEat.entity.SysUser;
import com.easyEat.service.IUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BDsnake
 * @since 2022-07-16
 */
@RestController
@CrossOrigin
public class UserController {
    @Resource
    IUserService userService;
    @GetMapping("/get-user")
    public Result getUser(String username){
        SysUser sysUser = userService.getOne(new QueryWrapper<SysUser>().eq("username", username));
        return CommonResult.success(ResultEnum.OK, sysUser);
    }
    @PostMapping("/register")
    public Result addUser(String username,String password){
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        int i = userService.addUser(sysUser);
        if(i>0) return CommonResult.success(ResultEnum.CREATED);
        else return CommonResult.error(ResultEnum.UNKNOWN_ERROR);
    }

    @GetMapping("/user")
    public String user(){
        return "user角色访问";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin角色访问";
    }
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return CommonResult.success(ResultEnum.OK);
    }
}

