package com.cennavi.plan.service.impl;

import com.cennavi.plan.mapper.BaseUserMapper;
import com.cennavi.plan.model.BaseUser;
import com.cennavi.plan.service.IBaseUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseUserServiceImpl implements IBaseUserService {

    @Resource
    BaseUserMapper BaseUserMapper;

    public BaseUser loadUserByUsername(String username){
        BaseUser baseUser = BaseUserMapper.queryByUsername(username);
        return baseUser;
    }
}
