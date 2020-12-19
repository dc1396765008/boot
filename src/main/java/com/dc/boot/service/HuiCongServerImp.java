package com.dc.boot.service;

import com.dc.boot.dao.HuiCongWangDao;
import com.dc.boot.spider.clear.DangDangClear;
import com.dc.boot.spider.clear.HuiCongClear;
import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoHuiCongItems;
import com.dc.boot.vo.VoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuiCongServerImp implements HuiCongServer {

    @Autowired
   private  HuiCongWangDao huiCongWangDao;
    @Override
    public VoList getHcList(String title, String page) throws Exception {
        VoList voList = new VoList();
        List<VoHuiCongItems> data = new HuiCongClear().ListData(title,page);
        for (VoHuiCongItems voHuiCongItems:data) {
            System.out.println(voHuiCongItems.toString());
            int add = huiCongWangDao.add(voHuiCongItems);
        }
        voList.setItems(data);
        voList.setTotal(data.size());
        return voList;
    }
//    page 第一页
//    limit 一页的数据
    public VoList getPageHcList(int page,int limit){
//        转换成数据库中没次查询的开始位置
        int start=(page-1)*limit;
        VoList voList = new VoList();
        int count = huiCongWangDao.findCount();
        System.out.println(count);
//start 开始的位置 end 从开始的位置爬的数量
        List<VoDangDangItems> data = huiCongWangDao.findPage(start, limit);
        System.out.println(data);
        voList.setTotal(count);
        voList.setItems(data);
        return voList;
    }
}
