package com.dysprosium.portal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dysprosium.portal.model.DO.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dysprosium
 * @title: UserMapper
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-2313:59
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
