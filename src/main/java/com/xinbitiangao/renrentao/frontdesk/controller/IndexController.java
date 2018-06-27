package com.xinbitiangao.renrentao.frontdesk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制类
 * Created by 黄大胖子
 * 2018/6/21 17:17
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
