package com.dc.boot.controller;

import com.dc.boot.Response.UserResponse;
import com.dc.boot.Util.Constants;

import com.dc.boot.service.WeiPingHuiService;
import com.dc.boot.vo.VoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WeiPingHuiController {
    @Autowired
    private WeiPingHuiService WeiPingHuiService;

    @GetMapping("/wph/list/getList")
    public UserResponse getList(String title, String page) {
        UserResponse userResponse = null;
        try {
            System.out.println("/wph/list/getList" + title);
            userResponse = new UserResponse();
            VoList list = WeiPingHuiService.getWphList(title, page);
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
    @GetMapping("/wph/listpage/getList")
    public UserResponse getPageSnList(int page, int limit) {
        UserResponse userResponse = null;
        try {
            System.out.println("/wph/listpage/getList" + page);
            userResponse = new UserResponse();
            VoList list = WeiPingHuiService.getPageWphList(page,limit);
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
