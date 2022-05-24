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

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dysprosium
 * @title: Comment
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "comment")
@ApiModel(value = "Comment", description = "Comment Table")
public class Comment implements Serializable {
    @ApiModelProperty(value = "主键id")
    @TableId(value = "comment_id", type = IdType.ASSIGN_ID)
    private String commentId;

    @ApiModelProperty(value = "commentText of the need")
    @NotEmpty(message = "commentText is not null")
    private String commentText;

    @ApiModelProperty(value = "userId of the need")
    @NotEmpty(message = "userId is not null")
    private String userId;

    @ApiModelProperty(value = "needId of the need")
    @NotEmpty(message = "needId is not null")
    private String needId;

    @ApiModelProperty(value = "create time")
    @NotEmpty(message = "create time is not null")
    private Date createdTime;

    @ApiModelProperty(value = "update time")
    @NotEmpty(message = "update time is not null")
    private Date updatedTime;

    @ApiModelProperty(value = "logic delete")
    @TableLogic
    private Integer isDeleted;

    public Comment(String commentText, String userId, String needId) {
        this.commentText = commentText;
        this.userId = userId;
        this.needId = needId;
    }
}
