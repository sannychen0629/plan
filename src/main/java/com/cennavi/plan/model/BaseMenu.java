package com.cennavi.plan.model;

import java.util.List;

/**
 * 系统菜单表
 */
public class BaseMenu {

    private String id;

    private String pid;

    private int level;

    private String name;

    private int order;

    private String fixed;

    private String color;

    private String panel;

    private String active;

    private String globaltime;

    private String globalvil;

    private String func;

    private String remark;

    private List<BaseMenu> menuList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed == null ? null : fixed.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel == null ? null : panel.trim();
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }

    public String getGlobaltime() {
        return globaltime;
    }

    public void setGlobaltime(String globaltime) {
        this.globaltime = globaltime == null ? null : globaltime.trim();
    }

    public String getGlobalvil() {
        return globalvil;
    }

    public void setGlobalvil(String globalvil) {
        this.globalvil = globalvil == null ? null : globalvil.trim();
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func == null ? null : func.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


    public List<BaseMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<BaseMenu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "BaseMenu{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", fixed='" + fixed + '\'' +
                ", color='" + color + '\'' +
                ", panel='" + panel + '\'' +
                ", active='" + active + '\'' +
                ", globaltime='" + globaltime + '\'' +
                ", globalvil='" + globalvil + '\'' +
                ", func='" + func + '\'' +
                ", remark='" + remark + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
