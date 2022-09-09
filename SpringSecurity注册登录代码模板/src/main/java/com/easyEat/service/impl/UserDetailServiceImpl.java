package com.easyEat.service.impl;

import com.easyEat.entity.SysUser;
import com.easyEat.service.IUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BDsnake
 * @since 2022/7/17 17:52
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private IUserService userService;

    /**
     * 需新建配置类注册一个指定的加密方式Bean，或在下一步Security配置类中注册指定
     */
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过用户名从数据库获取用户信息
        SysUser sysUser = userService.getByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if(sysUser.getUserLocked()==1){
            throw new UsernameNotFoundException("账号被封禁");
        }
        // 得到用户角色
        String role = sysUser.getUserRole();

        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority(role));
//        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        return new User(
                sysUser.getUsername(),
                // 因为数据库是明文，所以这里需加密密码
                sysUser.getPassword(),
                authorities
        );
    }
}

