package com.cennavi.plan.service;

import com.cennavi.plan.model.BasePoi;

import java.util.List;

public interface IBasePoiService {
    List<BasePoi> findPoi();
    List<BasePoi> findSubPoiByPID(String pid);
}
