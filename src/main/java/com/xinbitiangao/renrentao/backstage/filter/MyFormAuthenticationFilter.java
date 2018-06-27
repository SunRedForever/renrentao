package com.xinbitiangao.renrentao.backstage.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义Shiro拦截器，用于登陆成功后转跳到指定页面
 * Created by 黄大胖子
 * 2018/6/21 17:02
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String successUrl = "/admin/index";
        WebUtils.issueRedirect(request, response, successUrl);
        return false;
    }
}
