package com.dc.boot.service;

import com.dc.boot.dao.TianMaoDao;
import com.dc.boot.spider.clear.TaoBaoClear;
import com.dc.boot.spider.clear.TianMaoClear;
import com.dc.boot.vo.VoDangDangItems;
import com.dc.boot.vo.VoList;
import com.dc.boot.vo.VoTianmaoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TianMaoServiceImp implements TianMaoService {
    @Autowired
    private TianMaoDao tianMaoDao;
    @Override
    public VoList getList(String storeName, String username, String password, String page1) throws Exception {
        VoList voList = new VoList();
        List<VoTianmaoList> data = new TianMaoClear().ListData(storeName, username, password,page1);
        for (VoTianmaoList datum : data) {
            System.out.println(data.toString());
            int add = tianMaoDao.add(datum);
        }
        voList.setItems(data);
        voList.setTotal(data.size());
        return voList;
    }
    //    page 第一页
//    limit 一页的数据
    public VoList getPageTmList(int page,int limit){
//        转换成数据库中没次查询的开始位置
        int start=(page-1)*limit;
        VoList voList = new VoList();
        int count = tianMaoDao.findCount();
        System.out.println(count);
//start 开始的位置 end 从开始的位置爬的数量
        List<VoDangDangItems> data = tianMaoDao.findPage(start, limit);
        System.out.println(data);
        voList.setTotal(count);
        voList.setItems(data);
        return voList;
    }
}
