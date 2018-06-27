package com.xinbitiangao.renrentao.common.enums;

import lombok.Getter;

/**
 * Created by 黄大胖子
 * 2018/5/5 23:00
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    UNKNOWN(1, "未知错误");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
