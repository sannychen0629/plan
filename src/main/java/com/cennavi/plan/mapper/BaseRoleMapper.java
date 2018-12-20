package com.cennavi.plan.mapper;

import com.cennavi.plan.model.BaseRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaseRoleMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    BaseRole selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);

    List<BaseRole> queryByRoleID(String roleid);
}
