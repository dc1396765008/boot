package com.dc.boot.controller;

import com.dc.boot.Response.UserResponse;
import com.dc.boot.Util.Constants;
import com.dc.boot.service.JingDonService;
import com.dc.boot.vo.VoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class JingDonController {
        @Autowired
        private JingDonService jingDonService;
         @GetMapping("/jd/list/getList")
        public UserResponse getList(String title, String page) {
        UserResponse userResponse = null;
        try {
            System.out.println("/jd/list/getList" + title);
            userResponse = new UserResponse();
            VoList list = jingDonService.getJdList(title,page);
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
    @GetMapping("/jd/listpage/getList")
    public UserResponse getpageList(int page, int limit) {
        UserResponse userResponse = null;
        try {
            System.out.println("/jd/listpage/getList" + page);
            userResponse = new UserResponse();
            VoList list = jingDonService.getPageHcList(page,limit);
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
