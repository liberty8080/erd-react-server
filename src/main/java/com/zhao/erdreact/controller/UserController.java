package com.zhao.erdreact.controller;


import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zhao.erdreact.entity.ResultMsg;
import com.zhao.erdreact.entity.User;
import com.zhao.erdreact.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
@RestController
@RequestMapping("/erd/user")
@Slf4j
public class UserController {

    @Resource
    UserServiceImpl userService;

    @RequestMapping("/addUser")
    @ResponseBody
    public ResultMsg addUser(@RequestBody User user) {
        ResultMsg msg = new ResultMsg();
        try {
            userService.save(user);
            msg.setSuccess(true);
        } catch (DuplicateKeyException e) {
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("用户已存在");
        } catch (Exception e) {
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("添加用户失败！");
        }
        return msg;
    }

    @RequestMapping("deleteUser")
    public ResultMsg deleteUser(@RequestParam String userId) {
        ResultMsg msg = new ResultMsg();
        try {
            userService.removeById(userId);
            msg.setSuccess(true);
            log.info("删除用户成功，id{}", userId);
        } catch (Exception e) {
            msg.setSuccess(false);
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("删除失败");
        }
        return msg;
    }

    @RequestMapping("updateUser")
    public ResultMsg updateUser(@RequestBody User user) {
        ResultMsg msg = new ResultMsg();
        try {
            userService.updateById(user);
            msg.setSuccess(true);
        } catch (Exception e) {
            msg.setSuccess(false);
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("更新失败！", e);
        }
        return msg;
    }

    @RequestMapping("/listUsers")
    public ResultMsg listUsers() {
        ResultMsg msg = new ResultMsg();
        try {
            List<User> users = userService.list();
            JSONArray array = new JSONArray();
            array.addAll(users);
            msg.setSuccess(true);
            msg.setData(array.toString());
        } catch (Exception e) {
            log.error("查询失败");
            msg.setSuccess(false);
            msg.setErrorMsg("查询失败");
            msg.setErrorCode(ExceptionUtil.getMessage(e));
        }
        return msg;
    }

    @RequestMapping("/getUserById")
    public ResultMsg getUserById(@RequestParam String userId) {
        ResultMsg msg = new ResultMsg();
        JSONObject jsonObject;
        try {
            User user = userService.getById(userId);
            jsonObject = JSONUtil.parseObj(user, false);
            msg.setData(jsonObject.toString());
            msg.setSuccess(true);
        } catch (Exception e) {
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("获取用户失败");
        }
        return msg;
    }
}
