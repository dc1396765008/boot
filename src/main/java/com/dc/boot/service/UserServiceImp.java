package com.dc.boot.service;

import com.dc.boot.bean.User;
import com.dc.boot.dao.UserDao;
import com.dc.boot.vo.VoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User verify(VoUser user) {
        try{

        User resuser = userDao.find(user);
        if (resuser.getUsername().equals(user.getUsername())){
            return resuser;
        }

        }catch (Exception e){
            return null;
        }
        return null;
    }
}
