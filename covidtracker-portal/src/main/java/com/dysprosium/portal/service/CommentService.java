package com.dysprosium.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dysprosium.portal.model.DO.Comment;
import com.dysprosium.portal.model.VO.CommentInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dysprosium
 * @title: CommentService
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:26
 */
@Service
public interface CommentService extends IService<Comment> {

    List<CommentInfoVo> getCommentsByNeedId(String needId);
    int addComment(String commentText, String userId, String needId);


}
