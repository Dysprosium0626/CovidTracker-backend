package com.dysprosium.portal.model.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dysprosium
 * @title: Need
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-152:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "need")
@ApiModel(value = "Need", description = "Need Table")
public class Need implements Serializable {

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

    @ApiModelProperty(value = "create time")
    @NotEmpty(message = "create time is not null")
    private Date createdTime;

    @ApiModelProperty(value = "update time")
    @NotEmpty(message = "update time is not null")
    private Date updatedTime;

    @ApiModelProperty(value = "logic delete")
    @TableLogic
    private Integer isDeleted;

    public Need(Object category, Object description, Object level, Object timeLimit) {
        this.category = category.toString();
        this.description = description.toString();
        this.level = Integer.valueOf(level.toString());
        this.timeLimit = timeLimit.toString();
    }
}
