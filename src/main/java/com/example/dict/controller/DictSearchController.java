package com.example.dict.controller;


import com.example.dict.po.Dict1;
import com.example.dict.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * description: DictSearch1Controller <br>
 * date: 2022/2/14 上午1:08 <br>
 * author: ngsh <br>
 * version: 1.0 <br>
 */

@RestController
@RequestMapping(value = "/dict",headers = "Accept=application/json")
@Api(value = "搜索", tags = "搜索信息接口", description = "搜索信息接口:35种类型的数据、35个接口")
public class DictSearchController {

    @Autowired
    private SearchService searchService;

    private final Log log = LogFactory.getLog(DictSearchController.class);

    public String uuid;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request){
        this.uuid = (String) request.getAttribute("uuid");
    }

    /**
     * 民族搜索 【共一级】
     * @return
     */
    @ApiOperation(value = "民族", notes = "")
    @GetMapping(value = "/nation")
    public List<Dict1> nationSearch(){
        return searchService.nationSearch();
    }


}
