package com.cennavi.plan.controller;

import com.cennavi.plan.model.BaseMenu;
import com.cennavi.plan.service.IBaseMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统菜单
 * @author chenxiang
 * @Date 2018-12-24 14:37:25
 */
@Controller
@RequestMapping("/planService/menu")
public class MenuController {
    @Resource
    IBaseMenuService baseMenuService;

    @RequestMapping("/findMenusByToken")
    public @ResponseBody List<BaseMenu> findMenusByToken(@RequestParam String token){
        List<BaseMenu> menuList = baseMenuService.findMenuByToken(token);
        return  menuList;
    }

    /**
     * 查询子菜单
     * @param menuid
     * @return
     */
    @RequestMapping("/findSubMenu")
    public @ResponseBody List<BaseMenu> findSubMenu(@RequestParam(name = "menuid",required = false) String menuid){
        List<BaseMenu> menuList = baseMenuService.findSubMenuByPID(menuid);
        return  menuList;
    }
}

