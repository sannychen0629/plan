package com.cennavi.plan.service;

import com.cennavi.plan.model.BaseMenu;

import java.util.List;

public interface IBaseMenuService {
    List<BaseMenu> findMenuByToken(String token);
    List<BaseMenu> findSubMenuByPID(String pid);
}
