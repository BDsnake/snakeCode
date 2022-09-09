package com.easyEat.service;

import com.easyEat.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BDsnake
 * @since 2022-09-09
 */
public interface IUserService extends IService<SysUser> {
    SysUser getByUsername(String username);
    public int addUser(SysUser sysUser);
}
