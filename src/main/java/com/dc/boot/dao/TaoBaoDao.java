package com.dc.boot.dao;

import com.dc.boot.vo.VoHuiCongItems;
import com.dc.boot.vo.VoListItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TaoBaoDao {
    public int add(VoListItems voListItems);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
