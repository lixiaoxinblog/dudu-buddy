package com.xiaoxin.dudu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaoxin.dudu.mapper.UserMapper;
import com.xiaoxin.dudu.model.domain.User;
import com.xiaoxin.dudu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户服务
 *
 * @author xiaoxin
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    /**
     * 根据标签搜索用户
     * @return 查询到的用户列表
     */
    @Override
    public List<User> searchUserByTags(List<String> userTags){
        //在数据库中查询所有
        List<User> users = getBaseMapper().selectList(new LambdaQueryWrapper<>());
        //在内存中查询想要的数据
        return users.stream().filter(user -> {
            Set<String> tagNames = new Gson().fromJson(user.getTags(), new TypeToken<Set<String>>() {
            }.getType());
            Set<String> optionalTagNames = Optional.ofNullable(tagNames).orElse(new HashSet<>());
            for (String tagName : optionalTagNames) {
                if (userTags.toString().contains(tagName)) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }
}
