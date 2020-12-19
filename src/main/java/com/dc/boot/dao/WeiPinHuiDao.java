package com.dc.boot.dao;

import com.dc.boot.vo.VoWeiPingHuiItems;
import com.dc.boot.vo.VoYaMaXunItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WeiPinHuiDao {
    public int add(VoWeiPingHuiItems VoWeiPingHuiItems);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
