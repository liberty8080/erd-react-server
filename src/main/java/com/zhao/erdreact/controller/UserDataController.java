package com.zhao.erdreact.controller;


import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zhao.erdreact.entity.ErdData;
import com.zhao.erdreact.entity.ResultMsg;
import com.zhao.erdreact.service.impl.ErdDataServiceImpl;
import com.zhao.erdreact.service.impl.UserDataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-22
 */
@RestController
@Slf4j
@RequestMapping("/erd/user-data")
public class UserDataController {

    @Resource
    ErdDataServiceImpl dataService;

    @Resource
    UserDataServiceImpl userDataService;

    @RequestMapping("/saveErd")
    @ResponseBody
    public ResultMsg saveErd(@RequestBody Map<String, String> erdData) {
        ResultMsg msg = new ResultMsg();
        String data = erdData.get("data");
        String userId = erdData.get("userId");
        String desc = erdData.get("desc");
        String name = erdData.get("name");
        String dataId = erdData.get("dataId");

        dataService.saveErd(userId, data, desc, name,dataId);
        msg.setSuccess(true);
        msg.setData(erdData.toString());
        System.out.println(erdData.toString());
        return msg;
    }

    @RequestMapping("/updateErd")
    @ResponseBody
    public ResultMsg updateErd(@RequestBody Map<String,String> erdData){
        ResultMsg msg = new ResultMsg();
        try {
            String data = erdData.get("data");
            String dataId = erdData.get("dataId");
            dataService.updateErd(dataId,data);
            msg.setSuccess(true);
        }catch (Exception e){
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("Er图保存失败！");
        }
        return msg;
    }

    @RequestMapping("/deleteErd")
    @ResponseBody
    public ResultMsg delete(@RequestParam String dataId) {
        ResultMsg msg = new ResultMsg();
        try {
            dataService.removeById(dataId);
            userDataService.removeErd(dataId);
            msg.setSuccess(true);
        } catch (Exception e) {
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("er图删除失败");
        }
        return msg;
    }

    @RequestMapping("/listErd")
    @ResponseBody
    public ResultMsg listErd(String userId) {
        ResultMsg msg = new ResultMsg();
        try {
            List<ErdData> dataList = userDataService.listErd(userId);
            JSONArray jsonArray = new JSONArray(dataList);
            msg.setSuccess(true);
            msg.setData(jsonArray.toString());
        } catch (Exception e) {
            msg.setErrorMsg(ExceptionUtil.getMessage(e));
            log.error("关系图获取失败！");
        }
        return msg;
    }

    @RequestMapping("/getDataById")
    @ResponseBody
    public ResultMsg getDataBuId(String dataId) {
        ResultMsg msg = new ResultMsg();
        ErdData erdData ;
        try {
            erdData = dataService.getById(dataId);
            msg.setSuccess(true);
            JSONObject jsonObject = new JSONObject(erdData);
            log.info(jsonObject.toString());
            msg.setData(jsonObject.toString());
        }catch (Exception e){
            msg.setErrorMsg("获取er图失败");
            log.error("获取er图失败！");
        }
        return msg;
    }

}
