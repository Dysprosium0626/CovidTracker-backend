package com.dysprosium.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dysprosium.portal.model.DO.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dysprosium
 * @title: CommentMapper
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2314:25
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
