package com.dc.boot.controller;

import com.dc.boot.Response.UserResponse;
import com.dc.boot.Util.Constants;
import com.dc.boot.Util.JwtUtils;
import com.dc.boot.bean.User;
import com.dc.boot.service.UserService;
import com.dc.boot.vo.VoInfo;
import com.dc.boot.vo.VoToken;
import com.dc.boot.vo.VoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class UserContrller {
    @Autowired
    private UserService userService;
    User reuser =null;
    @PostMapping("/user/login")
    public UserResponse login(@RequestBody VoUser user){
        UserResponse res = new UserResponse();

        try{
         reuser= this.userService.verify(user);
        if (reuser!=null){
            String token = JwtUtils.sign(user.getUsername(), "-1");
            res.setCode(Constants.STATUS_OK);
            res.setMessage(Constants.MESSAGE_OK);
            res.setData(new VoToken(token));
        }else {
            res.setCode(Constants.STATUS_FAIL);
            res.setMessage(Constants.MESSAGE_FAIL);
            res.setData(Constants.MESSAGE_FAIL);
        }
        }catch (Exception e){
            res.setCode(Constants.STATUS_FAIL);
            res.setMessage(Constants.MESSAGE_FAIL+e.getMessage());
            res.setData(Constants.MESSAGE_FAIL);
        }finally {
            return res ;
        }
    }
    @GetMapping("/user/info")
    public UserResponse info(@RequestParam("token") String token){
        UserResponse res = new UserResponse();
        String verity = JwtUtils.verity(token);
        if (verity!=null&& verity.startsWith(JwtUtils.TOKEN_SUCCESS)){
            String username = verity.replaceFirst(JwtUtils.TOKEN_SUCCESS, "");
            VoInfo voInfo = new VoInfo();
            voInfo.setAvatar(reuser.getAvatar());
            voInfo.setIntroduction(reuser.getIntroduction());
            voInfo.setName(username);
            List<String> roles = Arrays.asList(username);
            voInfo.setRoles(roles);

            res.setCode(Constants.STATUS_OK);
            res.setMessage(Constants.MESSAGE_OK);
            res.setData(voInfo);
            return res;
        }else{
            res.setCode(Constants.STATUS_FAIL);
            res.setMessage(Constants.MESSAGE_FAIL);
            res.setData(Constants.MESSAGE_FAIL);
            return res;

        }
    }
    @RequestMapping("/user/logout")
    public UserResponse logout(@RequestHeader("X-Token") String token){
        UserResponse userResponse=new UserResponse();
        String voToken=JwtUtils.verity(token);
        userResponse.setMessage(Constants.MESSAGE_OK);
        userResponse.setCode(Constants.STATUS_OK);
        userResponse.setData(Constants.MESSAGE_OK);
        return userResponse;
    }

}
