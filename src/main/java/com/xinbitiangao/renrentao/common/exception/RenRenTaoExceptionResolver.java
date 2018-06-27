package com.xinbitiangao.renrentao.common.exception;

import com.xinbitiangao.renrentao.common.enums.ResultEnum;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 全局异常处理器
 * springmvc提供一个HandlerExceptionResolver接口
 * 只要实现该接口，并配置到spring 容器里，该类就能成为默认全局异常处理类
 * 全局异常处理器只有一个，配置多个也没用。
 */
@RestControllerAdvice
public class RenRenTaoExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //        准备视图层
        ModelAndView modelAndView = new ModelAndView();
        //        处理错误
        RenRenTaoException renRenTaoException = null;
        if (e instanceof RenRenTaoException) {
            renRenTaoException = (RenRenTaoException) e;
        } else if (e instanceof UnknownAccountException) {
            //用户名错误异常
            modelAndView.addObject("message", "账户名不存在");
            modelAndView.setViewName("/admin/login");
            return modelAndView;
        } else if (e instanceof IncorrectCredentialsException) {
            //用户名错误异常
            modelAndView.addObject("message", "密码错误");
            modelAndView.setViewName("/admin/login");
            return modelAndView;
        } else {
            renRenTaoException = new RenRenTaoException(ResultEnum.UNKNOWN);
        }
        //错误信息
        Integer code = renRenTaoException.getCode();
        String message = renRenTaoException.getMessage();
        //错误信息传递和错误页面跳转
        modelAndView.addObject("message", message);
        modelAndView.addObject("code", code);
        modelAndView.setViewName("403");
        return modelAndView;
    }
}
