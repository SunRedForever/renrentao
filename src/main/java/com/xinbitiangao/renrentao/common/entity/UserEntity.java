package com.xinbitiangao.renrentao.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by 黄大胖子
 * 2018/5/22 11:51
 */
@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    private String username;
    private String password;
}
