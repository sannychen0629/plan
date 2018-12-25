package com.cennavi.plan.mapper;

import com.cennavi.plan.model.BasePoi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasePoiMapper {
    List<BasePoi> queryPoi();
    List<BasePoi> querySubPoi(String pid);
}
