package com.lemon.pojo;

import java.io.Serializable;
import java.util.Date;

public class TAuditRecord implements Serializable {

    private static final long serialVersionUID = 4194572738318147679L;

    private Integer auditid;

    private Integer expenseid;

    private Integer userid;

    private String auditstate;

    private String auditsugg;

    private Date auditdate;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public Integer getAuditid() {
        return auditid;
    }

    public void setAuditid(Integer auditid) {
        this.auditid = auditid;
    }

    public Integer getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(Integer expenseid) {
        this.expenseid = expenseid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(String auditstate) {
        this.auditstate = auditstate == null ? null : auditstate.trim();
    }

    public String getAuditsugg() {
        return auditsugg;
    }

    public void setAuditsugg(String auditsugg) {
        this.auditsugg = auditsugg == null ? null : auditsugg.trim();
    }

    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }
}