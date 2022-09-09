package com.easyEat.common;

/**
 * @author BDsnake
 * @description CommonResult
 * @since 2022/7/9 17:55
 */
public class CommonResult {
    /**成功且带数据**/
    public static Result success(ResultEnum resultEnum,Object object){
        Result result = new Result();
        result.setCode(ResultEnum.OK.getCode());
        result.setMessage(ResultEnum.OK.getMessage());
        result.setData(object);
        return result;
    }

    /**成功但不带数据**/
    public static Result success(ResultEnum resultEnum){
        return success(resultEnum,null);
    }

    /**失败**/
    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    /**
     * 自定义参数类型
     * @param code
     * @param msg
     * @return
     */
    public static Result custom(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

}
