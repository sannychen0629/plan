package com.cennavi.plan.mapper;

import com.cennavi.plan.model.BaseMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseMenu record);

    int insertSelective(BaseMenu record);

    BaseMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BaseMenu record);

    int updateByPrimaryKey(BaseMenu record);


    List<BaseMenu> queySubMenu(String pid);

    List<BaseMenu> queryByRoleids(@Param("list") List<String> rolelist);
}
