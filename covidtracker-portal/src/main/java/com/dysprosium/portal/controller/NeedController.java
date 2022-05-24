package com.dysprosium.portal.controller;

import com.dysprosium.portal.model.DO.Need;
import com.dysprosium.portal.model.VO.NeedInfoVo;
import com.dysprosium.portal.service.Impl.NeedServiceImpl;
import com.dysprosium.portal.service.NeedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Dysprosium
 * @title: NeedController
 * @projectName covidtracker
 * @description: TODO
 * @date 2022-05-152:30
 */

@Api(tags = "Need Module")
@RestController
@RequestMapping("/need")
@CrossOrigin
public class NeedController {

    @Autowired
    private NeedService needService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all needs", notes = "Get all needs")
    public List<NeedInfoVo> getAllNeeds() {
        return needService.getAllNeeds();
    }

    @PutMapping("/add")
    @ApiOperation(value = "Add need", notes = "Add need")
    public boolean addNeed(@RequestBody Map<String, Object> needMap) {
        System.out.println(needMap.toString());
        return needService.addNeed(new Need(needMap.get("title") ,needMap.get("category"), needMap.get("description"), needMap.get("tel"), needMap.get("timeLimit")));
    }


}
