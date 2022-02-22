package com.example.dict.service;

import com.alibaba.fastjson.JSONObject;
import com.example.dict.model.ParamModel1;
import com.example.dict.po.Dict1;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dict.mapper.DictMapper;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private DictMapper dictMapper;

    public List<Dict1> nationSearch(){
        return dictMapper.nationSearch();
    }

    public List<Dict1> majorSearch(ParamModel1 model){

        if (model.getCode_value2()==null || model.getCode_value2().equals("")){
            model.setCode_value2("%");
        }else {
            model.setCode_value2(model.getCode_value2()+"%");
        }
        return dictMapper.majorSearch(model);
    }
    public List<Dict1> industrySearch(ParamModel1 model){
        if (model.getCode_value2()==null || model.getCode_value2().equals("")){
            model.setCode_value2("%");
        }else {
            model.setCode_value2(model.getCode_value2()+"%");
        }
        return dictMapper.industrySearch(model);
    }


    public List<Dict1> careerSearch(ParamModel1 model){
        if (model.getCode_value2()==null || model.getCode_value2().equals("")){
            model.setCode_value2("%");
        }else {
            model.setCode_value2(model.getCode_value2()+"%");
        }
        return dictMapper.careerSearch(model);
    }

    public List<JSONObject> listProvince(){
        return dictMapper.listProvince();
    }

    // 获取某个省下的所有城市
    public List<JSONObject> findCity(Integer id){
        return dictMapper.findCity(id);
    }

    // 获取指定城市下的所有县镇
    public List<JSONObject> findDistrict(Integer id){
        return dictMapper.findDistrict(id);
    }

}
