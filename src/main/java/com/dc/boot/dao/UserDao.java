package com.dc.boot.dao;

import com.dc.boot.bean.User;
import com.dc.boot.vo.VoUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface UserDao {
    public User find(VoUser user);

}
