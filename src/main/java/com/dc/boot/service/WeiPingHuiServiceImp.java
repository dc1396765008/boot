package com.dc.boot.service;

import com.dc.boot.vo.VoList;

public interface WeiPingHuiServiceImp {
    public VoList getWphList(String title, String page) throws Exception;
    public VoList getPageWphList(int page,int limit);
}
