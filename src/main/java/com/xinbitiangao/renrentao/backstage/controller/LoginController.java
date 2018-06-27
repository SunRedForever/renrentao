package com.xinbitiangao.renrentao.backstage.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 黄大胖子
 * 2018/5/29 19:46
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class LoginController {


    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map, Model model) throws Exception {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                msg = "验证码错误";
            } else {
                msg = "" + exception;
            }
            log.info("【登陆】错误-{}", msg);
        }
        model.addAttribute("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/admin/login";
    }
}
