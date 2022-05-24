package com.dysprosium.portal.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dysprosium.portal.mapper.CommentMapper;
import com.dysprosium.portal.model.DO.Comment;
import com.dysprosium.portal.model.VO.CommentInfoVo;
import com.dysprosium.portal.model.VO.NeedInfoVo;
import com.dysprosium.portal.model.VO.UserInfoVo;
import com.dysprosium.portal.service.CommentService;
import com.dysprosium.portal.service.NeedService;
import com.dysprosium.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dysprosium
 * @title: CommentServiceImpl
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:31
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private NeedService needService;


    @Override
    public List<CommentInfoVo> getCommentsByNeedId(String needId) {
        List<Comment> need_id = this.list(new QueryWrapper<Comment>().eq("need_id", needId));

        ArrayList<CommentInfoVo> commentInfoVos = new ArrayList<>();
        for (Comment comment : need_id) {
            UserInfoVo userById = userService.getUserById(comment.getUserId());
            NeedInfoVo needById = needService.getNeedById(comment.getNeedId());
            commentInfoVos.add(new CommentInfoVo(comment.getCommentId(), comment.getCommentText(), userById, needById, comment.getCreatedTime()));
        }
        return commentInfoVos;
    }

    @Override
    public int addComment(String commentText, String userId, String needId) {
        int insert = commentMapper.insert(new Comment(commentText, userId, needId));
        return insert;
    }


}
