package com.lemon.pojo;

import java.util.List;

public class ExpenseDetailVo {

   private String[] costid;

   private String[] detaildesc;

   private String[] detailmoney;

    public String[] getCostid() {
        return costid;
    }

    public void setCostid( String[] costid ) {
        this.costid = costid;
    }

    public String[] getDetaildesc() {
        return detaildesc;
    }

    public void setDetaildesc( String[] detaildesc ) {
        this.detaildesc = detaildesc;
    }

    public String[] getDetailmoney() {
        return detailmoney;
    }

    public void setDetailmoney( String[] detailmoney ) {
        this.detailmoney = detailmoney;
    }
}
