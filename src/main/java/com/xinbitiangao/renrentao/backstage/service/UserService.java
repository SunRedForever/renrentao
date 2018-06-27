package com.xinbitiangao.renrentao.backstage.service;

import com.xinbitiangao.renrentao.common.entity.UserEntity;

/**
 * 管理员服务接口
 * Created by 黄大胖子
 * 2018/5/5 17:01
 */
public interface UserService {

    /**
     * 按管理员名字查找账户
     * @param username
     * @return
     */
    UserEntity findByUsernameEquals(String username);
}
