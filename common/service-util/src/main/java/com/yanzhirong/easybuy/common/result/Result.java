package com.yanzhirong.easybuy.common.result;

import lombok.Data;

/**
 * 创建统一返回结果类
 * @param <T>
 */
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    //构造私有化
    private Result() {
    }
    //设置数据，返回对象的方法
    public static <T> Result<T> build(T data,ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }
    //成功的方法
    public static <T> Result<T> ok(T data) {
        return build(data,ResultCodeEnum.SUCCESS);
    }
    //失败的方法
    public static <T> Result<T> fail(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }

    public static<T> Result<T> build(T data, Integer code, String message) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
