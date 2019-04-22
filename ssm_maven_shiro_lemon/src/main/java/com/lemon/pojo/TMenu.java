package com.lemon.pojo;

import java.io.Serializable;

public class TMenu implements Serializable {

    private static final long serialVersionUID = -1433483473335676447L;

    private Integer menuid;

    private String menuname;

    private Integer pid;

    private String url;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }


    @Override
    public String toString() {
        return "TMenu{" +
                "menuid=" + menuid +
                ", menuname='" + menuname + '\'' +
                ", pid=" + pid +
                ", url='" + url + '\'' +
                '}';
    }
}