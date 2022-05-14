package com.dysprosium.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dysprosium.portal.model.DO.Need;
import com.dysprosium.portal.model.VO.NeedInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dysprosium
 * @title: NeedService
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-152:19
 */

public interface NeedService extends IService<Need> {
    List<NeedInfoVo> getAllNeeds();
    boolean addNeed(Need need);


}
