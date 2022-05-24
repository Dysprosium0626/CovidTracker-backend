package com.dysprosium.portal.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dysprosium.portal.mapper.NeedMapper;
import com.dysprosium.portal.model.DO.Need;
import com.dysprosium.portal.model.VO.NeedInfoVo;
import com.dysprosium.portal.service.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dysprosium
 * @title: NeedServiceImpl
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-152:24
 */
@Service
public class NeedServiceImpl extends ServiceImpl<NeedMapper, Need> implements NeedService {

    @Autowired
    private NeedMapper needMapper;
    
    @Override
    public List<NeedInfoVo> getAllNeeds() {
        List<Need> needs = needMapper.selectList(null);
        ArrayList<NeedInfoVo> needInfoVos = new ArrayList<>();
        for (Need need : needs) {
            needInfoVos.add(new NeedInfoVo(need.getNeedId(), need.getTitle(), need.getCategory(), need.getDescription(), need.getTel(), need.getTimeLimit()));
        }
        return needInfoVos;
    }

    @Override
    public boolean addNeed(Need need) {
        int insert = needMapper.insert(need);
        if(insert == 0) return false;
        return true;
    }

    @Override
    public NeedInfoVo getNeedById(String needId) {
        Need need = needMapper.selectById(needId);
        NeedInfoVo needInfoVo = new NeedInfoVo(need.getNeedId(), need.getTitle(), need.getCategory(), need.getDescription(), need.getTel(), need.getTimeLimit());
        return needInfoVo;
    }
}
