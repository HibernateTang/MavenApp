package com.spring.oa.service;

import com.spring.oa.domain.User;

/**
 * Created by burning-.- on 2015/6/27.
 */
public interface UserService {
    public User findUser(String username, String password);
    public void updateLastLoginTime(User user);
    public boolean isUserNameExist(String userName);
    public void addUser(String userName, String password, int faceId);
}
