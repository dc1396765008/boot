package com.dc.boot.dao;

import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoHuiCongItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HuiCongWangDao {
    public int add(VoHuiCongItems voHuiCongItems);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
