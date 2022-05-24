package com.dysprosium.portal.controller;

import com.dysprosium.portal.model.DO.Comment;
import com.dysprosium.portal.model.VO.CommentInfoVo;
import com.dysprosium.portal.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dysprosium
 * @title: CommentController
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-241:09
 */


@Api(tags = "Comment Module")
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;


    @GetMapping("/all")
    @ApiOperation(value = "Get all comments of a need", notes = "needId")
    public List<CommentInfoVo> getNeedComments(String needId) {
        List<CommentInfoVo> commentsByNeedId = commentService.getCommentsByNeedId(needId);
        return commentsByNeedId;
    }

    @PutMapping("/add")
    @ApiOperation(value = "add a comment", notes = "String commentText, String userId, String needId")
    public int addComment(String commentText, String userId, String needId) {
        return commentService.addComment(commentText, userId, needId);
    }

}
