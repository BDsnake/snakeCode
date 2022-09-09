package com.easyEat.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author BDsnake
 * @since 2022-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    private String userId;

    private String username;

    private String password;

    private String userRole;

    private Integer userLocked;

    private LocalDateTime createTime;


}
