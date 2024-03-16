package com.xiaoxin.dudu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dudu.model.domain.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author xiaoxin
 */
public interface UserService extends IService<User> {

    /**
     * 根据标签搜索用户
     * @return 查询到的用户列表
     */
    List<User> searchUserByTags(List<String> userTags);
}
