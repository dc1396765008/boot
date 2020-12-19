package com.dc.boot.service;


import com.dc.boot.vo.VoList;

public interface TaoBaoService {
    public VoList getList(String title, String username, String password, String page1) throws Exception;
    public VoList getPageHcList(int page,int limit);
}