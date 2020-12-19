package com.dc.boot.service;

import com.dc.boot.vo.VoList;

public interface YaMaXunServiceImpl {
    public VoList getymxList(String title, String page) throws Exception;
    public VoList getPageYmxList(int page,int limit);
}
