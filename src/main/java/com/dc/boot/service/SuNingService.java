package com.dc.boot.service;

import com.dc.boot.vo.VoList;

public interface SuNingService {
    public VoList getSnList(String title, String page) throws Exception;
    public VoList getPageSnList(int page,int limit);
}
