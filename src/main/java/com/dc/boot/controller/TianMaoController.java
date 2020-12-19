package com.dc.boot.controller;

import com.dc.boot.Response.UserResponse;
import com.dc.boot.Util.Constants;
import com.dc.boot.service.TianMaoService;
import com.dc.boot.vo.VoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class TianMaoController {
    @Autowired
    private TianMaoService tianMaoService;
    @GetMapping("/tm/list/getList")
    public UserResponse getList(String title, String username, String password, String page) {
        UserResponse userResponse = null;
        try {
            System.out.println("/tm/list/getList" + title);
            userResponse = new UserResponse();
            VoList list = tianMaoService.getList(title, username, password,page);
            userResponse.setData(list);
            userResponse.setMessage(Constants.MESSAGE_OK);
            userResponse.setCode(Constants.STATUS_OK);

        } catch (Exception e) {
            userResponse.setMessage(Constants.MESSAGE_FAIL);
            userResponse.setCode(Constants.STATUS_FAIL);
            userResponse.setData(Constants.MESSAGE_FAIL);
        }

        return userResponse;
    }
    @GetMapping("/tm/listpage/getList")
    public UserResponse getPageSnList(int page, int limit) {
        UserResponse userResponse = null;
        try {
            System.out.println("/sn/listpage/getList" + page);
            userResponse = new UserResponse();
            VoList list = tianMaoService.getPageTmList(page,limit);
            userResponse.setData(list);
            userResponse.setMessage(Constants.MESSAGE_OK);
            userResponse.setCode(Constants.STATUS_OK);

        } catch (Exception e) {
            userResponse.setMessage(Constants.MESSAGE_FAIL);
            userResponse.setCode(Constants.STATUS_FAIL);
            userResponse.setData(Constants.MESSAGE_FAIL);
        }

        return userResponse;
    }
}
