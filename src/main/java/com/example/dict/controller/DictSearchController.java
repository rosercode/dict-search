package com.example.dict.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.dict.model.ParamModel1;
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
import java.util.ArrayList;
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


    /**
     * 专业相关搜索接口
     * @param model
     * @return
     */
    // TODO: 2022/2/15
    @ApiOperation(value = "专业", notes = "专业相关搜索接口")
    @GetMapping(value = "/major")
    public List<Dict1> majorSearch(ParamModel1 model){
        model.setType("专业代码");
        return searchService.majorSearch(model);
    }

    @ApiOperation(value = "行业代码", notes = "行业代码")
    @GetMapping(value = "/industry")
    public List<Dict1> industrySearch(ParamModel1 model){
        model.setType("行业代码");
        return searchService.industrySearch(model);
    }


    @ApiOperation(value = "职工(工种)代码", notes = "职工(工种)代码")
    @GetMapping(value = "/career")
    public List<Dict1> careerSearch(ParamModel1 model){
        model.setType("职业工种");
        return searchService.careerSearch(model);
    }

    @ApiOperation(value = "地区联动", notes = "地区联动（省份->城市->县镇）")
    @GetMapping(value = "/area")
    public List<JSONObject> areaSearch(ParamModel1 model){
        if (model.getLevel() == 1){
            return searchService.listProvince();
        }
        if (model.getLevel() == 2){
            return searchService.findCity(Integer.valueOf(model.getCode_value2()));
        }

        if (model.getLevel() == 3){
            return searchService.findDistrict(Integer.valueOf(model.getCode_value2()));
        }
        return new ArrayList<>();
    }
}
