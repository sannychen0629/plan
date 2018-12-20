package com.cennavi.plan.service;

import com.cennavi.plan.model.BaseUser;

public interface IBaseUserService {
    BaseUser loadUserByUsername(String username);
}
