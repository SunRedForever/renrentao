package com.xinbitiangao.renrentao.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by 黄大胖子
 * 2018/6/21 17:52
 */
@Data
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
@Accessors(chain = true) //链式写法
public class PageLayuiTableVO<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
