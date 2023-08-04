package com.yanzhirong.easybuy.common.exception;

import com.yanzhirong.easybuy.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
// 面向切面
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody //返回json数据
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(null);
    }
    /**
     * 自定义异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(EasybuyException.class)
    @ResponseBody
    public Result error(EasybuyException e){
        return Result.build(null,e.getCode(), e.getMessage());
    }
}
