package com.xiaoxin.dudu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoxin.dudu.mapper.UserMapper;
import com.xiaoxin.dudu.model.domain.User;
import com.xiaoxin.dudu.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author xiaoxin
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


}
