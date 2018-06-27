package com.xinbitiangao.renrentao.backstage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 黄大胖子
 * 2018/5/31 20:51
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    /**
     * 后台转发
     *
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("page", "index");
        log.info("【后台】访问后台首页");
        return "/admin/index";
    }


    /**
     * 优惠卷页转发
     *
     * @return
     */
    @RequestMapping("/coupon")
    public String coupon(Model model) {
        log.info("【后台】访问后台优惠卷页面");
        model.addAttribute("page", "coupon");
        return "/admin/coupon";
    }


}
