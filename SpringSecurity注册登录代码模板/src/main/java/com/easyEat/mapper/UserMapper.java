package com.easyEat.mapper;

import com.easyEat.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BDsnake
 * @since 2022-09-09
 */
public interface UserMapper extends BaseMapper<SysUser> {
    // 插入用户
    @Insert("insert into sys_user(user_id,username, password, user_role) value(#{userId},#{username}, #{password}, 'ROLE_USER')")
    int addUser(SysUser sysUser);
}
