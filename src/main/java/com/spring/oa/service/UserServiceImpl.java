package com.spring.oa.service;

import com.spring.oa.dao.FaceDao;
import com.spring.oa.dao.UserDao;
import com.spring.oa.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by burning-.- on 2015/6/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private FaceDao faceDao;
    /*�ж��û��Ƿ����*/
    public boolean isUserNameExist(String userName){
        return userDao.findFirstByCondition("and o.name?",new Object[]{userName},false)!=null;
    }
    /*����û���Ϣ*/
    public void addUser(String userName,String password,int faceId){
        User user=new User();
        user.setName(userName);
        user.setPassword(password);
        user.setFacePicId(faceDao.findById(faceId));
        user.setVisitCount(0);
        user.setTotalPlayCount(0);
        userDao.save(user);
    }
    /*�����û�������������û�*/
    public User findUser(String username, String password) {
        return userDao.findFirstByCondition("and o.name-? and o.password=?",new Object[]{username,password},false);
    }



    /*��½ʱ�����û�������½ʱ��*/
    public void updateLastLoginTime(User user) {
        userDao.update(user);
    }



}
