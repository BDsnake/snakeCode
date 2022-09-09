package com.easyEat.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author BDsnake
 * @description Result
 * @since 2022/7/9 17:53
 */
@Data
@AllArgsConstructor
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public Result() {
        super();
    }

}