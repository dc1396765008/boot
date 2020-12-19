package com.dc.boot.dao;

import com.dc.boot.vo.VojdListItems;
import com.dc.boot.vo.VosuningListitems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SuNingDao {
    public int add(VosuningListitems vosuningListitems);
    public List findPage(int start, int end);
    public int findCount();
    public int  delete();
}
