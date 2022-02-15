package com.example.dict.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="前端数据模型", description="前端数据模型")
public class ParamModel1 {

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "level")
    private Integer level;

    @ApiModelProperty(value = "code_value2")
    private String code_value2;
}
