package com.cennavi.plan.service.impl;

import com.cennavi.plan.mapper.BasePoiMapper;
import com.cennavi.plan.model.BasePoi;
import com.cennavi.plan.service.IBasePoiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BasePoiServiceImpl implements IBasePoiService {
    @Resource
    BasePoiMapper basePoiMapper;

    @Override
    public List<BasePoi> findPoi() {
        List<BasePoi> poi =basePoiMapper.queryPoi();
        return poi;
    }

    @Override
    public List<BasePoi> findSubPoiByPID(String pid) {
        List<BasePoi> poi = basePoiMapper.querySubPoi(pid);
        return poi;
    }
}
