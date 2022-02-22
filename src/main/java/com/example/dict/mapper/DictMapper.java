package com.example.dict.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.dict.model.ParamModel1;
import com.example.dict.po.Dict1;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 数据搜索查询接口
 */
@Repository
@Mapper
public interface DictMapper {


    /*
        行业代码：

        采矿业 -> 煤炭开采和洗选业

        第一级：
            SELECT code_name,code_value2 FROM code_dictionary where code_value1 = '行业代码' and code_type like 'AAB%' and  length(code_value2) = 1
        第二级(第一类别选择采矿业)：
            SELECT code_name,code_value2 FROM code_dictionary where code_value1='行业代码'  and code_type like 'AAB%' and  length(code_value2)=3 and code_value2 like 'B%
        第三极(第一类别选择：煤炭开采和洗选业)：
            SELECT code_name,code_value2 FROM code_dictionary where code_value1='行业代码'  and code_type like 'AAB%' and  length(code_value2)=4 and code_value2 like 'B06%'
        第四级：

     */

    /*


       职工(工种)代码
       农业生产人员 -> 园艺工
       第一级：
            SELECT code_name,code_value2  FROM code_dictionary where code_value1= '职业工种' and length(code_value2)=4 and code_value2 like '%'
       第二级：农业生产人员
            SELECT code_name,code_value2  FROM code_dictionary where code_value1= '职业工种' and length(code_value2)=7 and code_value2 like '5010%'
       第三级：园艺工
            SELECT code_name,code_value2  FROM code_dictionary where code_value1= '职业工种' and length(code_value2)=9 and code_value2 like '5010202%'

     */

    /*

            SELECT code_name,code_value2 FROM code_dictionary where code_value1= '专业代码' and code_value2 like '%' and length(code_value2)=1;

        本科生 -> 工学 -> 电气信息类 -> 网络工程
        第一级：
            SELECT code_name,code_value2 FROM code_dictionary where code_value1= '专业代码' and length(code_value2)=3 and code_value2 like 'B%';
        第二级
            SELECT code_name,code_value2 FROM code_dictionary where code_value1= '专业代码' and length(code_value2)=5 and code_value2 like 'B08%'
        第三级
            SELECT code_name,code_value2 FROM code_dictionary where code_value1= '专业代码' and length(code_value2)=7 and code_value2 like 'B0806%'

     */

    // 民族信息查询 mapper
    // select * from code_dictionary where code_value1 = '民族'
    @Select("SELECT code_name,code_value2 FROM code_dictionary where code_value1 = '民族'")
    public List<Dict1> nationSearch();


    // 专业搜索
    @Select("SELECT code_name,code_value2 FROM code_dictionary " +
            "where code_value1= '专业代码' and length(code_value2)=#{level} and code_value2 like #{code_value2}")
    public List<Dict1> majorSearch(ParamModel1 model);


    // 行业代码
    @Select("SELECT code_name,code_value2 FROM code_dictionary " +
        "where code_value1='行业代码' and code_type like 'AAB%' and length(code_value2)=#{level} and code_value2 like #{code_value2}")
    public List<Dict1> industrySearch(ParamModel1 model);


    // 职工(工种)代码
    @Select("SELECT code_name,code_value2  FROM code_dictionary " +
            "where code_value1= '职业工种' and length(code_value2)=#{level} and code_value2 like #{code_value2}")
    public List<Dict1> careerSearch(ParamModel1 model);


    // 获取省份的列表
    @Select("SELECT ProvinceID, ProvinceName FROM dict_province")
    public List<JSONObject> listProvince();

    // 获取某个省下的所有城市
    @Select("SELECT CityID, CityName, ZipCode, ProvinceID FROM dict_city WHERE ProvinceID=#{ProvinceID};")
    public List<JSONObject> findCity(@Param("ProvinceID") Integer id);

    // 获取指定城市下的所有县镇
    @Select("SELECT DistrictID, DistrictName, CityID FROM dict_district WHERE CityID=#{CityID};")
    public List<JSONObject> findDistrict(@Param("CityID") Integer id);

}
