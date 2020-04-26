package com.zhao.erdreact.entity;

import lombok.Data;

/**
 * @author zhaojw zhaojw@si-tech.com.cn
 * @Description: 功能描述信息
 * @Copyright © SI-TECH 2017. All rights reserved
 * @date 2020-04-22 上午00:38:00
 * @version: V1.0
 */
@Data
public class ResultMsg {

    private String data;
    private String errorMsg;
    private String errorCode;
    private boolean success = false;
}
