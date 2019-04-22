package com.lemon.pojo;

import java.io.Serializable;

/**
 * 用于ajax传值
 */
public class Result implements Serializable {

    private static final long serialVersionUID = -4501034831568625191L;

    private Boolean success;

    private String massage;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess( Boolean success ) {
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage( String massage ) {
        this.massage = massage;
    }

    public Result( Boolean success, String massage ) {
        this.success = success;
        this.massage = massage;
    }
    public Result() {
    }
}
