package com.example.dict.service;

import com.example.dict.mapper.DictMapper;
import com.example.dict.model.ParamModel1;
import com.example.dict.po.Dict1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
