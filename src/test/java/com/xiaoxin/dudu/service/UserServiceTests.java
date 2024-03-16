package com.xiaoxin.dudu.service;

import com.xiaoxin.dudu.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    public void searchUserByTagsTest(){
        List<String> list = Arrays.asList("aa", "bb");
        List<User> users = userService.searchUserByTags(list);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
