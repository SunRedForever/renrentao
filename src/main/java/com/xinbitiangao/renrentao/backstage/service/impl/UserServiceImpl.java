package com.xinbitiangao.renrentao.backstage.service.impl;

import com.xinbitiangao.renrentao.common.entity.UserEntity;
import com.xinbitiangao.renrentao.common.repository.UserRepository;
import com.xinbitiangao.renrentao.backstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员实现类
 * Created by 黄大胖子
 * 2018/5/5 17:02
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity findByUsernameEquals(String username) {
        return userRepository.findByUsernameEquals(username);
    }
}
