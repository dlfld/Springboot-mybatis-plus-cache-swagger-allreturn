package com.cuit.travel.controller;

import com.cuit.travel.pojo.response.ResponseData;
import com.cuit.travel.service.CommonMsgService;
import com.cuit.travel.utils.ResponseDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/commonmsg")
@Api(tags = "测试标签")
public class CommonMsgController {
    @Autowired
    CommonMsgService commonMsgService;

    @ApiOperation("查询数据库内数据条数")
    @GetMapping("/totalcount")
    public Integer getTotalCount() {
        return commonMsgService.getTotalCount();
    }
}
