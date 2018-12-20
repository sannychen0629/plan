package com.cennavi.plan.mapper;

import com.cennavi.plan.model.BaseUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(BaseUser record);


    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    List<BaseUser> login(@Param("username") String username, @Param("password") String password);

    BaseUser queryByUsername(String username);

    void updateStatus(@Param("userid") String userid, @Param("status") String status);
}
