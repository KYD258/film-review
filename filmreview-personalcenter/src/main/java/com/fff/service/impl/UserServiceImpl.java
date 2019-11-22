package com.fff.service.impl;

import com.fff.dao.UserRepository;
import com.fff.domain.User;
import com.fff.service.UserService;
import com.fff.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void updateUserMessage(User user) {
        String md5Password = Md5Utils.getMd5Password(user.getPassWord());
        user.setPassWord(md5Password);
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(Integer userId) {
        if (userId!=null) {
            return userRepository.findById(userId).get();
        }
        return null;
    }
}
