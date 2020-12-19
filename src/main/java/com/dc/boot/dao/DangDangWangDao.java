package com.dc.boot.dao;

import com.dc.boot.vo.VoDangDangItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DangDangWangDao {
    public int add(VoDangDangItems voDangDangItems);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
