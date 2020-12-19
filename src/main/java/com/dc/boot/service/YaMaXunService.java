package com.dc.boot.service;

import com.dc.boot.dao.YaMaXunDao;
import com.dc.boot.spider.clear.WeiPingHuiClear;
import com.dc.boot.spider.clear.YaMaXunClear;
import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoList;
import com.dc.boot.vo.VoYaMaXunItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YaMaXunService implements YaMaXunServiceImpl {
    @Autowired
    private YaMaXunDao yaMaXunDao;
    public VoList getymxList(String title, String page) throws Exception {
        VoList voList = new VoList();
        List<VoYaMaXunItems> data = new YaMaXunClear().ListData(title,page);
        for (VoYaMaXunItems datum : data) {
            System.out.println(data.toString());
            int add = yaMaXunDao.add(datum);
        }
        voList.setItems(data);
        voList.setTotal(data.size());
        return voList;
    }
    //    page 第一页
//    limit 一页的数据
    public VoList getPageYmxList(int page,int limit){
//        转换成数据库中没次查询的开始位置
        int start=(page-1)*limit;
        VoList voList = new VoList();
        int count = yaMaXunDao.findCount();
        System.out.println(count);
//start 开始的位置 end 从开始的位置爬的数量
        List<VoDangDangItems> data = yaMaXunDao.findPage(start, limit);
        System.out.println(data);
        voList.setTotal(count);
        voList.setItems(data);
        return voList;
    }
}
