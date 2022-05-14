package com.dysprosium.portal.model.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dysprosium
 * @title: NeedVO
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-152:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeedInfoVo implements Serializable {

    @ApiModelProperty(value = "主键id")
    @TableId(value = "need_id", type = IdType.ASSIGN_ID)
    private String needId;

    @ApiModelProperty(value = "category of the need")
    @NotEmpty(message = "category is not null")
    private String category;

    @ApiModelProperty(value = "description of the need")
    @NotEmpty(message = "description is not null")
    private String description;

    @ApiModelProperty(value = "level of the need")
    @NotEmpty(message = "level is not null")
    private Integer level;

    @ApiModelProperty(value = "time limit of the need")
    @NotEmpty(message = "time limit is not null")
    private String timeLimit;


}
