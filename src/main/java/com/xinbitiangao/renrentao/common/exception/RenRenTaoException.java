package com.xinbitiangao.renrentao.common.exception;

import com.xinbitiangao.renrentao.common.enums.ResultEnum;
import lombok.Getter;

/**
 * 系统自定义异常类，针对预期异常
 * Created by 黄大胖子
 * 2018/5/5 22:57
 */
@Getter
public class RenRenTaoException extends Exception {

    //  异常编号
    private Integer code;
    //  异常信息
    private String message;

    public RenRenTaoException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
