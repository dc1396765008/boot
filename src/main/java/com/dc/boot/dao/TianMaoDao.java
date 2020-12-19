package com.dc.boot.dao;

import com.dc.boot.vo.VoListItems;
import com.dc.boot.vo.VoTianmaoList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TianMaoDao {
    public int add(VoTianmaoList voTianmaoList);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
