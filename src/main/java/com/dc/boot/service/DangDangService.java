package com.dc.boot.service;

import com.dc.boot.vo.VoList;

public interface DangDangService {
    public VoList getddList(String title, String page) throws Exception;
    public VoList getPageddList(int page,int limit);
}

