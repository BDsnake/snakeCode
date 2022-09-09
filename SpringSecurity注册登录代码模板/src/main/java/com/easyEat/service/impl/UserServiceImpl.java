package com.easyEat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easyEat.entity.SysUser;
import com.easyEat.mapper.UserMapper;
import com.easyEat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BDsnake
 * @since 2022-09-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements IUserService {
    @Resource
    UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public SysUser getByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<SysUser>().eq("username",username));
    }

    public int addUser(SysUser sysUser){
        // 加密密码
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        return userMapper.addUser(sysUser);
    }
}
