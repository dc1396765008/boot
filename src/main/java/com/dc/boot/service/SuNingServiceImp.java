package com.dc.boot.service;

import com.dc.boot.dao.SuNingDao;
import com.dc.boot.spider.clear.DangDangClear;
import com.dc.boot.spider.clear.SuNingClear;
import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoList;
import com.dc.boot.vo.VosuningListitems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuNingServiceImp implements SuNingService {
    @Autowired
    private SuNingDao suNingDao;
    @Override
    public VoList getSnList(String title, String page) throws Exception {
            VoList voList = new VoList();
            List<VosuningListitems> data = new SuNingClear().ListData(title,page);
            for (VosuningListitems vosuningListitems : data) {
                System.out.println(vosuningListitems.toString());
                suNingDao.add(vosuningListitems);
            }
            voList.setItems(data);
            voList.setTotal(data.size());
            return voList;
    }
    //    page 第一页
//    limit 一页的数据
    public VoList getPageSnList(int page,int limit){
//        转换成数据库中没次查询的开始位置
        int start=(page-1)*limit;
        VoList voList = new VoList();
        int count = suNingDao.findCount();
        System.out.println(count);
//start 开始的位置 end 从开始的位置爬的数量
        List<VoDangDangItems> data = suNingDao.findPage(start, limit);
        System.out.println(data);
        voList.setTotal(count);
        voList.setItems(data);
        return voList;
    }
}
