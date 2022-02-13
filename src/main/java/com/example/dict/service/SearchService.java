package com.example.dict.service;

import com.example.dict.mapper.DictMapper;
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


}
