package com.dc.boot.service;

import com.dc.boot.dao.TaoBaoDao;
import com.dc.boot.spider.clear.TaoBaoClear;
import com.dc.boot.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaoBaoServiceImp  implements TaoBaoService    {

    @Autowired
    private TaoBaoDao taoBaoDao;
    public VoList getList( String title,String username,String password,String page1) throws Exception  {

        VoList voList = new VoList();

        List<VoListItems> data = new TaoBaoClear().ListData(title, username, password,page1);
        for (VoListItems voListItems:data) {
            System.out.println(voListItems.toString());
            int add = taoBaoDao.add(voListItems);
        }
        voList.setItems(data);
        voList.setTotal(data.size());


        return voList;
    }
    public VoList getPageHcList(int page,int limit){
        int start=(page-1)*limit;
        VoList voList = new VoList();
        int count = taoBaoDao.findCount();
        System.out.println(count);
        List<VoDangDangItems> data = taoBaoDao.findPage(start, limit);
        System.out.println(data);
        voList.setTotal(count);
        voList.setItems(data);
        return voList;
    }


}

