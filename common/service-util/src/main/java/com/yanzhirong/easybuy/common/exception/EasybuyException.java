package com.yanzhirong.easybuy.common.exception;

import com.yanzhirong.easybuy.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class EasybuyException  extends RuntimeException{
    private    Integer code;
    public EasybuyException(String message, Integer code){
        super(message);
        this.code=code;
    }
    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public EasybuyException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "EasybuyException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }

}
