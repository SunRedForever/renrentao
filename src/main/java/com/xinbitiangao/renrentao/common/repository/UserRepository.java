package com.xinbitiangao.renrentao.common.repository;

import com.xinbitiangao.renrentao.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 黄大胖子
 * 2018/5/22 10:57
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * 按照用户名查询用户
     *
     * @param username
     * @return
     */
    UserEntity findByUsernameEquals(String username);
}
