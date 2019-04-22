package com.lemon.pojo;

import java.io.Serializable;

public class TCost implements Serializable {

    private static final long serialVersionUID = -6459745264358174425L;

    private Integer costid;

    private String costname;

    private String costdesc;

    private String costmark;

    //用于显示复选框赋值
    private String ck;

    public String getCk() {
        return "<input type='checkbox' name='ids' value='"+this.costid+"'/>";
    }

    public void setCk( String ck ) {
        this.ck = ck;
    }

    public Integer getCostid() {
        return costid;
    }

    public void setCostid(Integer costid) {
        this.costid = costid;
    }

    public String getCostname() {
        return costname;
    }

    public void setCostname(String costname) {
        this.costname = costname == null ? null : costname.trim();
    }

    public String getCostdesc() {
        return costdesc;
    }

    public void setCostdesc(String costdesc) {
        this.costdesc = costdesc == null ? null : costdesc.trim();
    }

    public String getCostmark() {
        return costmark;
    }

    public void setCostmark(String costmark) {
        this.costmark = costmark == null ? null : costmark.trim();
    }
}