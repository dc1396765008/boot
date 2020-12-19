package com.dc.boot.dao;

import com.dc.boot.vo.VoTianmaoList;
import com.dc.boot.vo.VoYaMaXunItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface YaMaXunDao {
    public int add(VoYaMaXunItems voYaMaXunItems);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
