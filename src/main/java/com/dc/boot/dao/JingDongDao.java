package com.dc.boot.dao;

import com.dc.boot.vo.VoHuiCongItems;
import com.dc.boot.vo.VoListItems;
import com.dc.boot.vo.VojdListItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JingDongDao {
    public int add(VojdListItems vojdListItems);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
