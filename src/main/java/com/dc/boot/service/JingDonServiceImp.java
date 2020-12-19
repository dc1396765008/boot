package com.dc.boot.service;

import com.dc.boot.dao.JingDongDao;
import com.dc.boot.spider.clear.JingDonClear;
import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoHuiCongItems;
import com.dc.boot.vo.VoList;
import com.dc.boot.vo.VojdListItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JingDonServiceImp implements JingDonService {

   @Autowired
    private  JingDongDao jingDongDao;
    public VoList getJdList(String title,String page) throws Exception {
        VoList voList = new VoList();

        List<VojdListItems> data = new JingDonClear().listJdData(title, page);
        for (VojdListItems vojdListItems:data) {
            System.out.println(vojdListItems.toString());
            int add = jingDongDao.add(vojdListItems);
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
        int count = jingDongDao.findCount();
        System.out.println(count);
//start 开始的位置 end 从开始的位置爬的数量
        List<VoDangDangItems> data = jingDongDao.findPage(start, limit);
        System.out.println(data);
        voList.setTotal(count);
        voList.setItems(data);
        return voList;
    }

}
