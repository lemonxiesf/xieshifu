package com.lemon.pojo;


import java.io.Serializable;

/**
 * 查询条件
 */
public class PoExpense implements Serializable {

    private static final long serialVersionUID = 6536539811519200313L;

    private String username;

    private String beginDate;

    private String endDate;

    private String expensestate;

    private String expensename;

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getBeginDate() {
        return beginDate ;
    }

    public void setBeginDate( String beginDate ) {
        this.beginDate = beginDate ;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate( String endDate ) {
        this.endDate = endDate ;
    }

    public String getExpensestate() {
        return expensestate;
    }

    public void setExpensestate( String expensestate ) {
        this.expensestate = expensestate;
    }

    public String getExpensename() {
        return expensename;
    }

    public void setExpensename( String expensename ) {
        this.expensename = expensename;
    }
}
