package com.cennavi.plan.model;

import java.util.List;

/**
 * 用户权限表
 */
public class BaseRole {
    private String roleid;

    private String rolename;

    private String desc;

    private List<BaseMenu> menuList;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public List<BaseMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<BaseMenu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "BaseRole{" +
                "roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                ", desc='" + desc + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
