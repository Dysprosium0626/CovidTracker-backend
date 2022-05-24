package com.dysprosium.portal.model.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author Dysprosium
 * @title: CommentInfoVo
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2412:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentInfoVo {
    @ApiModelProperty(value = "主键id")
    @TableId(value = "comment_id", type = IdType.ASSIGN_ID)
    private String commentId;

    @ApiModelProperty(value = "commentText of the need")
    @NotEmpty(message = "commentText is not null")
    private String commentText;

    @ApiModelProperty(value = "userId of the need")
    @NotEmpty(message = "userId is not null")
    private UserInfoVo user;

    @ApiModelProperty(value = "needId of the need")
    @NotEmpty(message = "needId is not null")
    private NeedInfoVo need;

    @ApiModelProperty(value = "create time")
    @NotEmpty(message = "create time is not null")
    private Date createdTime;

}
