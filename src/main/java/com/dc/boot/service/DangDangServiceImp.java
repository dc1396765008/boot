package com.dc.boot.service;

import com.dc.boot.dao.DangDangWangDao;
import com.dc.boot.spider.clear.DangDangClear;
import com.dc.boot.spider.clear.JingDonClear;
import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangDangServiceImp implements DangDangService{

    @Autowired
    private DangDangWangDao dangDangWangDao;
    public VoList getddList(String title, String page) throws Exception {
        VoList voList = new VoList();
        List<VoDangDangItems> data = new DangDangClear().ListData(title,page);
        for (VoDangDangItems voDangDangItems:data) {
            System.out.println(voDangDangItems.toString());
            int add = dangDangWangDao.add(voDangDangItems);
        }
        voList.setItems(data);
        voList.setTotal(data.size());
        return voList;
    }
    public VoList getPageddList(int page,int limit){
        int start=(page-1)*limit;
        VoList voList = new VoList();
        int count = dangDangWangDao.findCount();
        System.out.println(count);
        List<VoDangDangItems> data = dangDangWangDao.findPage(start, limit);
        System.out.println(data);
        voList.setTotal(count);
        voList.setItems(data);
        return voList;
    }
}
