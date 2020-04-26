package com.zhao.erdreact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import javax.annotation.Resource;


/**
 * @author zhaojw zhaojw@si-tech.com.cn
 * @Description: 功能描述信息
 * @Copyright © SI-TECH 2017. All rights reserved
 * @date 2020-04-23 上午17:40:24
 * @version: V1.0
 */
@SpringBootTest
class ErdControllerTest {

    @Resource
    ErdController controller;

    @Test
    void parseUserRole() {
        assertNotNull(controller.parseRole("user","user","user"));
    }

    @Test
    void parseAdminRole(){
        assertNotNull(controller.parseRole("admin","admin","admin"));
    }


}