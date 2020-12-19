package com.dc.boot.service;

import com.dc.boot.vo.VoList;

public interface HuiCongServer {
    public VoList getHcList(String title, String page) throws Exception;
    public VoList getPageHcList(int page,int limit);
}
