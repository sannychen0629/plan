package com.cennavi.plan.model;

import java.io.Serializable;
import java.util.List;

public class BasePoi implements Serializable {
    private String id;
    private String pid;
    private int level;
    private int order;
    private String poiname;
    private String poicode;
    private List<BasePoi> poiList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id==null?null:id.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid==null?null:pid.trim();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname==null?null:poiname.trim();
    }

    public String getPoicode() {
        return poicode;
    }

    public void setPoicode(String poicode) {
        this.poicode = poicode==null?null:poicode.trim();
    }

    public List<BasePoi> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<BasePoi> poiList) {
        this.poiList = poiList;
    }

    @Override
    public String toString()
    {
        return "BaseMenu{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", level=" + level +
                ", order=" + order +
                ", poiname='" + poiname + '\'' +
                ", poicode='" + poicode + '\'' +
                '}';
    }
}
