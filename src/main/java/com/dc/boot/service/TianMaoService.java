package com.dc.boot.service;

import com.dc.boot.vo.VoList;

public interface TianMaoService {
    public VoList getList(String storeName, String username, String password, String page1)throws Exception;
    public VoList getPageTmList(int page,int limit);
}
