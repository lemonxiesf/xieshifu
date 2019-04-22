package com.lemon.pojo;

import java.io.Serializable;

public class TExpenseDetail implements Serializable {

    private static final long serialVersionUID = 2375206506733806879L;

    private Integer detailid;

    private Integer expenseid;

    private Integer costid;

    private String detaildesc;

    private Float detailmoney;

    //显示费用名称
    private String costname;

    public String getCostname() {
        return costname;
    }

    public void setCostname( String costname ) {
        this.costname = costname;
    }
    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Integer getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(Integer expenseid) {
        this.expenseid = expenseid;
    }

    public Integer getCostid() {
        return costid;
    }

    public void setCostid(Integer costid) {
        this.costid = costid;
    }

    public String getDetaildesc() {
        return detaildesc;
    }

    public void setDetaildesc(String detaildesc) {
        this.detaildesc = detaildesc == null ? null : detaildesc.trim();
    }

    public Float getDetailmoney() {
        return detailmoney;
    }

    public void setDetailmoney(Float detailmoney) {
        this.detailmoney = detailmoney;
    }
}