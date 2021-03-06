package com.zhao.erdreact.controller;

import com.zhao.erdreact.entity.ResultMsg;
import com.zhao.erdreact.service.impl.AdminServiceImpl;
import com.zhao.erdreact.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zhaojw zhaojw@si-tech.com.cn
 * @Description: 功能描述信息
 * @Copyright © SI-TECH 2017. All rights reserved
 * @date 2020-04-22 上午00:31:30
 * @version: V1.0
 */
@Slf4j
@Controller
@CrossOrigin
@RequestMapping("/erd")
public class ErdController {

    @Resource
    AdminServiceImpl adminService;

    @Resource
    UserServiceImpl userService;


    @RequestMapping("/login")
    @ResponseBody
    public ResultMsg Login(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String role) {
        ResultMsg msg = new ResultMsg();
        String id = parseRole(username, password, role);
        if (id != null) {
            log.info("{}--{}登录",role,username);
            msg.setData(id);
            msg.setSuccess(true);
        } else {
            log.warn("来自{}的失败登录 ，用户名{}",role,username);
            msg.setErrorMsg("用户名或密码错误");
        }
        return msg;
    }


    String parseRole(String name, String passwd, String role){
        try{
            if (role.equals("admin")) {
                if (adminService.getAdmin(name, passwd) != null)
                    return adminService.getAdmin(name, passwd).getAdminId();
                else
                    return adminService.getAdmin(name, passwd).getAdminId();

            } else if (role.equals("user")) {
                if (userService.getUser(name, passwd) != null)
                    return userService.getUser(name, passwd).getUserId();
                else
                    return userService.getUser(name, passwd).getUserId();

            }else {
                return null;
            }
        }catch (NullPointerException e){
            log.error("登陆失败！该用户不存在！");
            return null;
        }

    }
}
