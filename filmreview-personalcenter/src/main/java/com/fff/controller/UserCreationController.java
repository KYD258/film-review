package com.fff.controller;

import com.fff.domain.Creation;
import com.fff.domain.User;
import com.fff.service.UserCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/*用户个人作品查询*/
@RestController
@RequestMapping("/UserCreation")
public class UserCreationController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserCreationService userCreationService;
    /*用户个人所有作品查询*/
@RequestMapping("/findAllUserCreation")
    public List<Creation> findAllUserCreation(){
    User user = (User) redisTemplate.opsForValue().get("user");
    // System.out.println(user+"user");
    Integer userId = user.getUserId();
    List<Creation> allUserCreation = userCreationService.findAllUserCreation(userId);
    return allUserCreation;
}
}
