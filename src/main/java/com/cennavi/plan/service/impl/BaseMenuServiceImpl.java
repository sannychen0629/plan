package com.cennavi.plan.service.impl;

import com.cennavi.plan.mapper.BaseMenuMapper;
import com.cennavi.plan.model.BaseMenu;
import com.cennavi.plan.model.BaseRole;
import com.cennavi.plan.model.BaseUser;
import com.cennavi.plan.service.IBaseMenuService;
import com.cennavi.plan.utils.UserUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaseMenuServiceImpl implements IBaseMenuService {
    @Resource
    UserUtil userUtil;
    @Resource
    BaseMenuMapper baseMenuMapper;
    @Override
    public List<BaseMenu> findMenuByToken(String token) {
        BaseUser user = userUtil.getUserInfo(token);
        List<BaseRole> roleList = user.getRoleList();
        List<String> list =  new ArrayList<>();
        for (BaseRole role: roleList){
            list.add(role.getRoleid());

        }
        List<BaseMenu> menus = baseMenuMapper.queryByRoleids(list);

        return menus;
    }

    public List<BaseMenu> findSubMenuByPID(String pid) {
        List<BaseMenu> menus = baseMenuMapper.queySubMenu(pid);

        return menus;
    }
}
